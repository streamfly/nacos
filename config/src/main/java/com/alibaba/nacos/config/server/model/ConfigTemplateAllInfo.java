package com.alibaba.nacos.config.server.model;

/**
 * 公共模板全部信息
 *
 * @author stream.li
 */
public class ConfigTemplateAllInfo extends ConfigTemplateInfo {

	private static final long serialVersionUID = 1L;
	
	private long createTime;
    private long modifyTime;
    private String createUser;
    
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
