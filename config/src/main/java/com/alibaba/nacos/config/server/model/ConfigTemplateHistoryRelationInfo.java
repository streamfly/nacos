package com.alibaba.nacos.config.server.model;

import java.io.Serializable;

/**
 * 公共模板历史关系信息
 *
 * @author stream.li
 */
public class ConfigTemplateHistoryRelationInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long cId;
	private long tId;
	private String dataId;
    private String group;
    private String tenant;
    private long createTime;
    private String createUser;
    private String appName;
    private String opsType;
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getcId() {
		return cId;
	}
	
	public void setcId(long cId) {
		this.cId = cId;
	}
	
	public long gettId() {
		return tId;
	}
	
	public void settId(long tId) {
		this.tId = tId;
	}
	
	public String getDataId() {
		return dataId;
	}
	
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getTenant() {
		return tenant;
	}
	
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	
	public long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getAppName() {
		return appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getOpsType() {
		return opsType;
	}

	public void setOpsType(String opsType) {
		this.opsType = opsType;
	}
	
}
