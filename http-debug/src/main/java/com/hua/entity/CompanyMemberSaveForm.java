package com.hua.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 新增企业会员表单
 * @author ruffy
 *
 */
public class CompanyMemberSaveForm {

	/**
	 * 会员ID
	 */
	private Integer memId ;
	
	/**
	 * 销售人员ID
	 */
	@NotNull(message="销售人员ID不能为空")
	private Integer sellerID  ;
	
	/**
	 * 会员卡号
	 */
	private String cardNo ; 
	
	/**
	 * 会员姓名
	 */
	@NotNull(message="姓名不能为空")
	@Size(max=8 , message="姓名过长")
	private String name ;
	
	/**
	 * 会员电话
	 */
	@NotNull(message="电话号码不能为空")
	private String phone ;
	
	/**
	 * 邮件
	 */
	@NotNull(message="邮箱不能为空")
	private String email ;
	
	/**
	 * 身份证号
	 */
	@NotNull(message="身份证号码不能为空")
	private String idNo ;
	
	/* 公司卡号 */
	@NotNull(message="公司卡号不能为空")
	private String companyCardNo;
	
	/**
	 * 公司名称
	 */
	@NotNull(message="公司名称不能为空")
	private String companyName ;
	
	
	/**
	 * 打款账户名
	 */
	@NotNull(message="打款账户名不能为空")
	private String payName ;
	
	
	/**
	 * 公司营业执照编号
	 */
	@NotNull(message="公司营业执照不能为空")
	private String companyNo ;
	
	
	/**
	 * 发票抬头，使用 打款账户名 字段的值
	 */
	//@NotNull(message="发票抬头不能为空")
	private String invoiceName ;
	
	
	/**
	 * 邮寄地址
	 */
	@NotNull(message="邮寄地址不能为空")
	private String invoiceAddress ;
	
	
	/**
	 * 营业执照图片地址
	 */
	private String companyNoImg ;
	
	
	/**
	 * CONTRACT_IMG
	 */
	private String contractImg ;
	
	/**
	 *  微信ID
	 */
	private String openId ;
	
	/**
	 * 店铺ID
	 */
	@NotNull(message="门店ID不能为空")
	private Integer storeId ;
	
	/**
	 * 微信头像地址
	 */
	private String wxImg ;
	
	/**
	 * 联系人信息
	 */
	/* 联系人-姓名 */
	@NotNull(message="联系人-姓名不能为空")
	private String concatName;
	
	/* 联系人-邮箱 */
	@NotNull(message="联系人-邮箱不能为空")
	private String concatMail;
	
	/* 联系人-手机号码 */
	@NotNull(message="联系人-手机号码不能为空")
	private String concatPhone;
	
	/**
	 * 业务状态
	 * 在注册企业会员时:
	 * 个人注册失败: 0
	 * 企业注册失败: 1
	 */
	private Integer regStatus;
	
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	public String getCompanyNoImg() {
		return companyNoImg;
	}

	public void setCompanyNoImg(String companyNoImg) {
		this.companyNoImg = companyNoImg;
	}

	public String getContractImg() {
		return contractImg;
	}

	public void setContractImg(String contractImg) {
		this.contractImg = contractImg;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getSellerID() {
		return sellerID;
	}

	public void setSellerID(Integer sellerID) {
		this.sellerID = sellerID;
	}

	public String getWxImg() {
		return wxImg;
	}

	public void setWxImg(String wxImg) {
		this.wxImg = wxImg;
	}

	/**
	 * @return the companyCardNo
	 */
	public String getCompanyCardNo() {
		return companyCardNo;
	}

	/**
	 * @param companyCardNo the companyCardNo to set
	 */
	public void setCompanyCardNo(String companyCardNo) {
		this.companyCardNo = companyCardNo;
	}

	/**
	 * @return the concatName
	 */
	public String getConcatName() {
		return concatName;
	}

	/**
	 * @param concatName the concatName to set
	 */
	public void setConcatName(String concatName) {
		this.concatName = concatName;
	}

	/**
	 * @return the concatMail
	 */
	public String getConcatMail() {
		return concatMail;
	}

	/**
	 * @param concatMail the concatMail to set
	 */
	public void setConcatMail(String concatMail) {
		this.concatMail = concatMail;
	}

	/**
	 * @return the concatPhone
	 */
	public String getConcatPhone() {
		return concatPhone;
	}

	/**
	 * @param concatPhone the concatPhone to set
	 */
	public void setConcatPhone(String concatPhone) {
		this.concatPhone = concatPhone;
	}

	/**
	 * @return the regStatus
	 */
	public final Integer getRegStatus() {
		return regStatus;
	}

	/**
	 * @param regStatus the regStatus to set
	 */
	public final void setRegStatus(Integer regStatus) {
		this.regStatus = regStatus;
	}
	
}
