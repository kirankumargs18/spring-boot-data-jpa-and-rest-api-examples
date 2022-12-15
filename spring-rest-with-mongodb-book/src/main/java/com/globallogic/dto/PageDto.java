/**
 * @author kiran
 * */
package com.globallogic.dto;

public class PageDto {

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
		return "PageDto [pageNumber=" + pageNumber + ", topic=" + topic + "]";
	}

}
