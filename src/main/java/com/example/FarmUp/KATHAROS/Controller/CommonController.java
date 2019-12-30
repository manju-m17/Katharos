package com.example.FarmUp.KATHAROS.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CommonController {
	@Value("${spring.application.name}")
	private String applName;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("app-name")
	public String appName() {
		//return applName;
		return env.getProperty("spring.application.name");
	}
	
	@RequestMapping("app-detail")
	public Map<String, String> appInfo() {
		Map<String,String> appDetails = new HashMap<String, String>();
		//return applName;
		appDetails.put("Application Name", env.getProperty("app.name"));
		appDetails.put("App version",env.getProperty("app.version"));
		appDetails.put("App Desc",env.getProperty("app.description"));
		return appDetails;
	}
}
