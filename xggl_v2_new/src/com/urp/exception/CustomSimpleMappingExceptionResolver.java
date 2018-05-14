package com.urp.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.util.NestedServletException;

import com.urp.tool.JsonResult;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	//@Autowired
	//ObjectMapper opbjeMapper;
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		if(ex instanceof PlatformException){
			PlatformException platformException=(PlatformException)ex;
			// 判断是否 Ajax 请求 
	        if ((request.getHeader("accept").indexOf("application/json") > -1 ||
	          (request.getHeader("X-Requested-With") != null && 
	          request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))){
	           try {
	               response.setContentType("application/json;charset=utf-8");
	               response.setCharacterEncoding("UTF-8");
	               JsonResult<String> jsonResult=new JsonResult<String>();
	               jsonResult.fail("主鍵錯誤");
	               PrintWriter writer = response.getWriter();
	               writer.write(jsonResult.toString());
	              // writer.write(opbjeMapper.writeValueAsString(jsonResult));
	               writer.flush();
	               writer.close();
	           } catch (Exception e) {
	               System.out.println("出现错误");
	           }
	           return null;
	        }
		}
		return super.doResolveException(request, response, handler, ex);
	}

   
}
