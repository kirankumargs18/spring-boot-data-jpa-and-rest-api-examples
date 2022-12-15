/**
 * @author kiran
 * */
package com.globallogic.entity;

public class Page {

	private Long pageNumber;
	private String topic;

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Page [pageNumber=" + pageNumber + ", topic=" + topic + "]";
	}

}
