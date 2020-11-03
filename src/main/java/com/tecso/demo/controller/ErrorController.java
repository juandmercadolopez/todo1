package com.tecso.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "page_500";
	        } else if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "page_404";
	        }else if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
	            return "page_403";
	        }
	    }
	    return "error";
	}
	
	@Override
    public String getErrorPath() {
        return "/error";
    }
	
	

}
