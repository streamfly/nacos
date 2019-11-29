package com.alibaba.nacos.config.server.model;

import java.io.Serializable;

/**
 * 公共模板基础信息
 *
 * @author stream.li
 */
public class ConfigTemplateInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
    private String name;
    private String content;
    private String tenant;
    private String desc;
    private String md5;
    private String type;
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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

}
