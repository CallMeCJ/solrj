package com.cjzheng.bean;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @date: 2016年6月22日上午11:48:58
 * @author: zhengchaojie
 * @version: v1.0
 */

public class Blog {
	@Field
	private int id;
	@Field
	private String hunterTitle;
	@Field
	private String hunterAuthor;
	@Field
	private String hunterContent;
	@Field
	private String hunterQuestion;
	@Field
	private String hunterAnswers;
	@Field
	private Date hunterCreateTime;
	@Field
	private Date hunterUpdateTime;
	@Field
	private String hunterUrl;

	public String getHunterTitle() {
		return hunterTitle;
	}

	public void setHunterTitle(String hunterTitle) {
		this.hunterTitle = hunterTitle;
	}

	public String getHunterAuthor() {
		return hunterAuthor;
	}

	public void setHunterAuthor(String hunterAuthor) {
		this.hunterAuthor = hunterAuthor;
	}

	public String getHunterContent() {
		return hunterContent;
	}

	public void setHunterContent(String hunterContent) {
		this.hunterContent = hunterContent;
	}

	public String getHunterQuestion() {
		return hunterQuestion;
	}

	public void setHunterQuestion(String hunterQuestion) {
		this.hunterQuestion = hunterQuestion;
	}

	public String getHunterAnswers() {
		return hunterAnswers;
	}

	public void setHunterAnswers(String hunterAnswers) {
		this.hunterAnswers = hunterAnswers;
	}

	public Date getHunterCreateTime() {
		return hunterCreateTime;
	}

	public void setHunterCreateTime(Date hunterCreateTime) {
		this.hunterCreateTime = hunterCreateTime;
	}

	public Date getHunterUpdateTime() {
		return hunterUpdateTime;
	}

	public void setHunterUpdateTime(Date hunterUpdateTime) {
		this.hunterUpdateTime = hunterUpdateTime;
	}

	public String getHunterUrl() {
		return hunterUrl;
	}

	public void setHunterUrl(String hunterUrl) {
		this.hunterUrl = hunterUrl;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
