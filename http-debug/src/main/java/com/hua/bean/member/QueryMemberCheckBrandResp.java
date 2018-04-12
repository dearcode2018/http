/**
  * @filename QueryMemberCheckBrandResp.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean.member;

import java.util.List;

 /**
 * @type QueryMemberCheckBrandResp
 * @description  
 * @author qianye.zheng
 */
public final class QueryMemberCheckBrandResp {

	/* 成功/失败原因 */
	private String reason;
	
	/* 返回状态，0表示成功，负数失败 */
	private int status;
	
	private List<QueryPerformanceResult> result;

	/**
	 * @return the reason
	 */
	public final String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public final void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the status
	 */
	public final int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the result
	 */
	public final List<QueryPerformanceResult> getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public final void setResult(List<QueryPerformanceResult> result) {
		this.result = result;
	}
	
}
