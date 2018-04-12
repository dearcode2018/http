/**
  * @filename BrandBean.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean.member;

import java.util.Date;

 /**
 * @type BrandBean
 * @description  
 * @author qianye.zheng
 */
public final class BrandBean {

	private Integer memberId;
	
	private Date createTimeBegin;
	
	private Date createTimeEnd;

	/**
	 * @return the memberId
	 */
	public final Integer getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public final void setMemberId(Integer memberId) {
		this.memberId = memberId;
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
