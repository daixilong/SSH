package com.urp.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 全局的异常处理
 * @author a
 *
 */
public class CustomerException implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception) {
		// TODO Auto-generated method stub
		//判断是否是ajax请求
		PlatformException platformException=null;
		if(exception instanceof PlatformException){
			platformException=(PlatformException)exception;
		}else if(exception instanceof BindException){
			BindException bindException=(BindException) exception;
			List<FieldError> fileErrors= bindException.getBindingResult().getFieldErrors();
			for (FieldError fieldError : fileErrors) {
				System.out.println(fieldError.getField());
				System.out.println(fieldError.getDefaultMessage());
			}
		} else{
			platformException=new PlatformException("系统出现异常请及时处理");
		}
		ModelAndView view=new ModelAndView();
		view.addObject("message", platformException.getMessage());
		view.setViewName("error");
		return view;
	}

}
