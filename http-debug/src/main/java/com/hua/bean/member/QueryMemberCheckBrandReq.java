/**
  * @filename QueryMemberCheckBrandReq.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean.member;

import java.util.Date;

 /**
 * @type QueryMemberCheckBrandReq
 * @description  
 * @author qianye.zheng
 */
public class QueryMemberCheckBrandReq {
	
	/* 会员Id */
	private Integer memberid;
	
	private Date createTimeBegin;
	
	private Date createTimeEnd;

	/**
	 * @return the memberid
	 */
	public final Integer getMemberid() {
		return memberid;
	}

	/**
	 * @param memberid the memberid to set
	 */
	public final void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	/**
	 * @return the createTimeBegin
	 */
	public final Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	/**
	 * @param createTimeBegin the createTimeBegin to set
	 */
	public final void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	/**
	 * @return the createTimeEnd
	 */
	public final Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	/**
	 * @param createTimeEnd the createTimeEnd to set
	 */
	public final void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
}
