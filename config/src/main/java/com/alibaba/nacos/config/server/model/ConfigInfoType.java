package com.alibaba.nacos.config.server.model;

import java.io.Serializable;

/**
 * 配置类型
 *
 * @author stream.li
 */
public class ConfigInfoType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String dataId;
    private String group;
    private String tenant;
    /**
     * 0-配置管理 1-配置变更
     */
    private int type;
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

}
