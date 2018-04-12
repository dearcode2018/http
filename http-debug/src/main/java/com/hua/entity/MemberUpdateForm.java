package com.hua.entity;

import javax.validation.constraints.NotNull;

/**
 * 
 * @type MemberUpdateForm
 * @description 会员更新表单
 * @author qianye.zheng
 */
public class MemberUpdateForm {

	/**
	 * 会员ID
	 */
	@NotNull(message="会员ID不能为空")
	private Integer memId ;
	
	/**
	 * 销售人员ID
	 */
	@NotNull(message="销售人员不能为空")
	private Integer sellerID ;
	
	/**
	 * 会员类型
	 * 0: 个人会员
	 * 1: 企业会员
	 */
	@NotNull(message="会员类型不能为空")
	private Integer type ;
	
	/**
	 * 会员卡号
	 */
	private String cardNo ; 
		
	/**
	 * 会员电话
	 */
	@NotNull(message="电话不能为空")
	private String phone ;
	
	/**
	 * 邮件
	 */
	@NotNull(message="邮件不能为空")
	private String email ;
	
	/**
	 * 身份证号
	 */
	@NotNull(message="身份证能为空")
	private String idNo ;
				
	/**
	 * 用户标签
	 * 用逗号分卡
	 */
	private String tags ;

	public Integer getSellerID() {
		return sellerID;
	}

	public void setSellerID(Integer sellerID) {
		this.sellerID = sellerID;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

}
