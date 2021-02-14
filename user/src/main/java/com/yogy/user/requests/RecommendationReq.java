package com.yogy.user.requests;

public class RecommendationReq {
	private Double lang;
	private Double lat;
	private Integer start;
	private Integer size;
	private Integer range;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	public Double getLang() {
		return lang;
	}

	public void setLang(Double lang) {
		this.lang = lang;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
}
