

package com.alibaba.nacos.config.server.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.config.server.constant.Constants;
import com.alibaba.nacos.config.server.model.ConfigTemplateAllInfo;
import com.alibaba.nacos.config.server.model.ConfigTemplateInfo;
import com.alibaba.nacos.config.server.model.Page;
import com.alibaba.nacos.config.server.model.RestResult;
import com.alibaba.nacos.config.server.service.PersistService;
import com.alibaba.nacos.config.server.utils.TimeUtils;

/**
 * 公共模板控制器
 *
 * @author stream.li
 */
@RestController
@RequestMapping(Constants.CONFIG_TEMPLATE_CONTROLLER_PATH)
public class ConfigTemplateController {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigTemplateController.class);
	
	private final PersistService persistService;
	
	@Autowired
    public ConfigTemplateController(PersistService persistService) {
        this.persistService = persistService;
    }
	
	@PostMapping("/new")
    public Boolean createConfigTemplate(HttpServletRequest request, HttpServletResponse response,
    							 @RequestParam("name") String name,
                                 @RequestParam(value = "tenant") String tenant,
                                 @RequestParam("content") String content,
                                 @RequestParam(value = "src_user", required = false) String srcUser,
                                 @RequestParam(value = "desc", required = false) String desc,
                                 @RequestParam(value = "type") String type)
        throws NacosException {
		final Timestamp time = TimeUtils.getCurrentTime();
		
		ConfigTemplateInfo configTemplateInfo = new ConfigTemplateInfo();
		configTemplateInfo.setContent(content);
		configTemplateInfo.setName(name);
		configTemplateInfo.setTenant(tenant);
		configTemplateInfo.setType(type);
		configTemplateInfo.setDesc(desc);
		
		return persistService.addConfigTemplateInfo(srcUser, configTemplateInfo, time);
	}
	
	@PostMapping("/update")
	public Boolean updateConfigTemplate(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam("name") String name,
             @RequestParam(value = "tenant") String tenant,
             @RequestParam("content") String content,
             @RequestParam(value = "src_user", required = false) String srcUser,
             @RequestParam(value = "desc", required = false) String desc,
             @RequestParam(value = "type") String type)
            		 throws NacosException {
		
		final Timestamp time = TimeUtils.getCurrentTime();
		
		ConfigTemplateInfo configTemplateInfo = new ConfigTemplateInfo();
		configTemplateInfo.setContent(content);
		configTemplateInfo.setName(name);
		configTemplateInfo.setTenant(tenant);
		configTemplateInfo.setType(type);
		configTemplateInfo.setDesc(desc);

		return persistService.updateConfigTemplateInfo(srcUser, configTemplateInfo, time);
	}
	
	@PostMapping("/delete")
	public Boolean deleteConfigTemplate(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam("name") String name,
             @RequestParam(value = "tenant") String tenant,
             @RequestParam(value = "src_user", required = false) String srcUser)
            		 throws NacosException {
		
		final Timestamp time = TimeUtils.getCurrentTime();
		
		ConfigTemplateInfo configTemplateInfo = new ConfigTemplateInfo();
		configTemplateInfo.setName(name);
		configTemplateInfo.setTenant(tenant);
		
		return persistService.deleteConfigTemplateInfo(configTemplateInfo, srcUser, time);
	}
	
	@PostMapping("/deleteall")
	public Boolean deleteAllConfigTemplate(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam("name") String name,
             @RequestParam(value = "tenant") String tenant,
             @RequestParam(value = "src_user", required = false) String srcUser)
            		 throws NacosException {
		
		final Timestamp time = TimeUtils.getCurrentTime();
		
		ConfigTemplateInfo configTemplateInfo = new ConfigTemplateInfo();
		configTemplateInfo.setName(name);
		configTemplateInfo.setTenant(tenant);
		
		return persistService.deleteRelatedAllConfigTemplateInfo(configTemplateInfo, srcUser, time);
	}
	
	@GetMapping(params = "search=accurate")
	public Page<ConfigTemplateAllInfo> searchConfigTemplate(@RequestParam(value = "name", required = false) String name,
            		@RequestParam(value = "tenant") String tenant,
            		@RequestParam("pageNo") int pageNo,
            		@RequestParam("pageSize") int pageSize)
            		 throws NacosException {		
		return persistService.findConfigTemplateInfoByTenantAndName(pageNo, pageSize, name, tenant);
	}
	
	@GetMapping(params = "search=blur")
	public List<String> fuzzySearchNameList(@RequestParam(value = "key") String key, @RequestParam(value = "tenant") String tenant) {		
		return persistService.fuzzySearchNameWithCondition(key, tenant);
	}
	
	@GetMapping("/info")
	public ConfigTemplateInfo getConfigTemplateInfo(@RequestParam(value = "name") String name,
    		@RequestParam(value = "tenant") String tenant)
		 throws NacosException {		
		return persistService.getConfigTemplateInfoByNameAndTenant(name, tenant);
	}
	
	@PostMapping(params = "import=true")
    public RestResult<Map<String, Object>> importConfigTemplate(HttpServletRequest request,
                                                                  @RequestParam(value = "src_user", required = false) String srcUser,
                                                                  @RequestParam(value = "namespace") String namespace,
                                                                  @RequestParam(value = "type") String type,
                                                                  MultipartFile file) throws NacosException {
		
		return null;
	}
	
	@PostMapping(params = "export=true")
    public RestResult<Map<String, Object>> exportConfigTemplate(HttpServletRequest request,
                                                                  @RequestParam(value = "src_user", required = false) String srcUser,
                                                                  @RequestParam(value = "namespace") String namespace,
                                                                  @RequestParam(value = "type") String type,
                                                                  MultipartFile file) throws NacosException {
		
		return null;
	}
	
	@PostMapping("/copybynamespace")
	public Boolean copyConfigTemplateFromOtherNamespace(
			@RequestParam(value = "src_user", required = false) String srcUser,
			@RequestParam(value = "src") String srcEnv,
			@RequestParam(value = "dst") String dstEnv,
			@RequestParam(value = "name", required = false) String name) {
		return persistService.copyConfigTemplateFromOtherNamespace(srcUser, srcEnv, dstEnv, name, false);
	}
	
	@PostMapping("/newconfigwithtemplate")
	public Boolean createConfigWithTemplate(@RequestParam(value = "tenant") String tenant,
			@RequestParam("dataId") String dataId, @RequestParam("group") String group,
			@RequestParam(value = "appName", required = false) String appName,
			@RequestParam(value = "src_user", required = false) String srcUser,
			@RequestParam(value = "templates") String templates) {
		String[] temps = StringUtils.split(templates, ",");
		return persistService.createConfigWithTemplates(tenant, group, dataId, appName, srcUser, temps);
	}
	
}
