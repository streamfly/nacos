package com.alibaba.nacos.config.server.model;

import java.io.Serializable;

/**
 * 公共模板历史信息
 *
 * @author stream.li
 */
public class ConfigTemplateHistoryInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long tId;
    private String name;
    private String content;
    private String tenant;
    private String desc;
    private String md5;
    private String type;
    private String opsType;
	private long createTime;
    private long modifyTime;
    private String createUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getOpsType() {
		return opsType;
	}

	public void setOpsType(String opsType) {
		this.opsType = opsType;
	}

	public long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	public long getModifyTime() {
		return modifyTime;
	}
	
	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

}
