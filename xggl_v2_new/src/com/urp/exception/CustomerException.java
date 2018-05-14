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
 * ȫ�ֵ��쳣����
 * @author a
 *
 */
public class CustomerException implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception) {
		// TODO Auto-generated method stub
		//�ж��Ƿ���ajax����
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
			platformException=new PlatformException("ϵͳ�����쳣�뼰ʱ����");
		}
		ModelAndView view=new ModelAndView();
		view.addObject("message", platformException.getMessage());
		view.setViewName("error");
		return view;
	}

}
