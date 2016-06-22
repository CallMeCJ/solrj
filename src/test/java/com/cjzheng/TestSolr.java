package com.cjzheng;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

import com.cjzheng.bean.Blog;

/**
 * @date: 2016年6月22日上午11:16:53
 * @author: zhengchaojie
 * @version: v1.0
 */

public class TestSolr {
	private String baseUrl = "http://localhost:8983/solr/cjzheng";

	@Test
	public void createSolrClient() {
		try {
			SolrClient solr = new HttpSolrClient(baseUrl);
			SolrPingResponse response = solr.ping();
			// 打印执行时间
			System.out.println("连接成功，时间：" + response.getElapsedTime());
			solr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addBeanIndex() {
		SolrClient solr = new HttpSolrClient(baseUrl);
		Blog blog = new Blog();
		blog.setId(123);
		blog.setHunterContent("添加内容");
		blog.setHunterTitle("添加标题");
		UpdateResponse response = null;
		try {
			response = solr.addBean(blog);
			System.out.println("添加成功：" + response.getElapsedTime());
			solr.commit();
			solr.close();
		} catch (IOException | SolrServerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 增加索引
	 * 
	 * @throws Exception
	 */
	@Test
	public void addIndex() throws Exception {
		SolrClient solr = new HttpSolrClient(baseUrl);
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", 123, new Float(1.0));
		document.addField("content", "test");
		UpdateResponse response = solr.add(document);
		System.out.println(response.getElapsedTime());
		solr.commit();
		solr.close();
	}

	/**
	 * 删除索引
	 */
	@Test
	public void delIndex() throws Exception {
		SolrClient solr = new HttpSolrClient(baseUrl);
		UpdateResponse response = solr.deleteById("123");
		System.out.println(response.getElapsedTime());
		solr.commit();
		solr.close();
	}

	/**
	 * 简单查询
	 * 
	 * @throws IOException
	 * @throws SolrServerException
	 */
	@Test
	public void query() throws Exception {
		SolrClient solr = new HttpSolrClient(baseUrl);
		Map<String, String> map = new HashMap<String, String>();
		map.put("q", "content:test");
		SolrParams params = new MapSolrParams(map);
		QueryResponse resp = solr.query(params);
		// 以下是第二种方法
		// String queryString="content:test";
		// MultiMapSolrParams mParams =
		// SolrRequestParsers.parseQueryString("queryString");
		// QueryResponse resp = solr.query(mParams);
		SolrDocumentList docsList = resp.getResults();
		System.out.println(docsList.size());
		for (SolrDocument doc : docsList) {
			System.out.println(doc.get("id"));
		}
		solr.close();
	}
}
