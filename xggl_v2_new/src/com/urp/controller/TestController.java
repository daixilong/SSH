package com.urp.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urp.model.User;
import com.urp.tool.JsonResult;
import com.urp.util.ValidateUtils;

@Controller
public class TestController {

	@RequestMapping("/test")
	public String test(){
		return "view/test";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult<User> save(@RequestBody User user){
		ValidateUtils.validateEntity(user);
		return JsonResult.success(user);
	} 
	
	
	@RequestMapping("/error")
	public String error(){
		return "error";
	}
}
