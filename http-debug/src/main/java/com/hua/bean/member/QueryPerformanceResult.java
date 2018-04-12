/**
  * @filename QueryPerformanceResult.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean.member;

 /**
 * @type QueryPerformanceResult
 * @description  
 * @author qianye.zheng
 */
public final class QueryPerformanceResult {

	/* 品牌Id */
	private Integer brandId;
	
	/* 品牌名称 */
	private String brandName;

	/**
	 * @return the brandId
	 */
	public final Integer getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public final void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the brandName
	 */
	public final String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public final void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
