package com.kenny.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kenny.configuration.PropertiesConfig;

@Controller
public class PageController {
	
	
	@Autowired
	private PropertiesConfig propertiesConfig;
	
	@RequestMapping(value={"/","index"},method=RequestMethod.GET,produces=MediaType.TEXT_HTML_VALUE)
	public String index(){
		return propertiesConfig.getIindexPageViewName();
	}

	@RequestMapping("{module}/{path1}")
	public String page1(//
			@PathVariable("module") String module,//
			@PathVariable("path1") String path1){
		return  new StringBuilder(module)//
				.append("/").append(path1).toString();
	}

	@RequestMapping("{module}/{path1}/{path2}")
	public String page2(//
			@PathVariable("module") String module,//
			@PathVariable("path1") String path1,//
			@PathVariable("path2") String path2){
		return  new StringBuilder(module)//
				.append("/").append(path1)//
				.append("/").append(path2).toString();
	}

	@RequestMapping("{module}/{path1}/{path2}/{path3}")
	public String page3(//
			@PathVariable("module") String module,//
			@PathVariable("path1") String path1,//
			@PathVariable("path2") String path2,//
			@PathVariable("path3") String path3){
		return  new StringBuilder(module)//
				.append("/").append(path1)//
				.append("/").append(path2)//
				.append("/").append(path3).toString();
	}
}
