package com.daling.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 放置于 Session的标识当前登录用户的信息。这是一个泛指。
 * 
 */
@SuppressWarnings("serial")
public class DLoginUser implements Serializable {

	public static final String COOKIE_SEPARATOR = "^";

	public DLoginUser() {
	}

	public DLoginUser(Long id) {
		this.id = id;
	}

	public Long id = 1L; // 用户表 T_USER.id 的主键
	public String userType = "0"; // 管理员、职员、外部员工 // CommonCD.SubUserType
	public String roleAssignType = "1"; // 角色指派类型 CommonCD.RoleAssignType
	/**
	 * 登录名
	 */
	public String userId = "admin"; // 登录帐号 T_USER_ALIAS.loginName , 一个用户可能有多个登录名
	public String userLoginId = ""; // 登录账号
	/**
	 * 用户名称
	 */
	public String userNm = "测试用户"; // 用户昵称 ,可以随意变的
	/**
	 * 人的编号，一旦录入系统，不能轻易改变的，如：员工编码、会员卡号等
	 */
	public String userCode = "";
	/**
	 * 部门编码 T_DEPARTMENT.dept_code, 工作流分配任务用
	 */
	public String deptCode = "";
	public String email;
	public String passwd; // 可以不存放该值
	public String clientIp; // 访问来源 ip
	public Date loginDate = new Date(); // 登录日期
	public String isChangedPwd;
	public String logonToken; // 2010-12-26 登录令牌
	/**
	 * 表明用户当前访问的模块
	 */
	public String moduleCode;
	public String currentUrl = "";
	public Long applicationId = 1L;
	public Date accessDate = new Date(); // 最后访问日期

	private String mobile;
	/**
	 * 2010-03-12 aibo zeng 表明是否已经登录 Session中可以放入一个 new BsUser() , 如果 logined==false，表明没有登录
	 */
	public boolean logined = false;

	/** 登录失败次数及最后登录失败日期，失败两次加验证码 */
	private Long loginErrorTimes;
	private Date lastLoginErrorTime;

	/**
	 * 公司
	 */
	private Long companyId;
	private String companyName;


	/** partnerType供应商, 客户,经销商,门店,运输商,物流商，厂商 */
	private String partnerType;

	private Long creatorId = 100L;
	private String creatorName = "admin";
	private Date createdDate = new Date();

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isLogined() {
		return logined;
	}

	public void setLogined(boolean logined) {
		this.logined = logined;
	}

	public Long getLoginErrorTimes() {
		return loginErrorTimes;
	}

	public void setLoginErrorTimes(Long loginErrorTimes) {
		this.loginErrorTimes = loginErrorTimes;
	}

	public Date getLastLoginErrorTime() {
		return lastLoginErrorTime;
	}

	public void setLastLoginErrorTime(Date lastLoginErrorTime) {
		this.lastLoginErrorTime = lastLoginErrorTime;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getName() {

		return userNm;
	}

	public void setName(String userNm) {

		this.userNm = userNm;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

	public String getLogonToken() {
		return logonToken;
	}

	public void setLogonToken(String logonToken) {
		this.logonToken = logonToken;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}

	public String getRoleAssignType() {
		return roleAssignType;
	}

	public void setRoleAssignType(String roleAssignType) {
		this.roleAssignType = roleAssignType;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


}
