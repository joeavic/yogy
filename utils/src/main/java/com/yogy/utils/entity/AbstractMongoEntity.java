package com.yogy.utils.entity;

import org.springframework.data.annotation.Id;

public abstract class AbstractMongoEntity {
	@Id
	private String id;

	private Long creationTime;
	private Long lastUpdatedTime;

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Long lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

}

