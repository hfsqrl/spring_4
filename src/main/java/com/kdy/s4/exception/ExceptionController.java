package com.kdy.s4.exception;

import java.sql.SQLException;

import javax.servlet.jsp.jstl.sql.SQLExecutionTag;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex1() {
		ModelAndView mv = new ModelAndView();
		System.out.println("null pointer exception");
		mv.setViewName("error/error_back");
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView ex2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("sql exception");
		mv.setViewName("error/error_back");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ex3() {
		ModelAndView mv = new ModelAndView();
		System.out.println("그 외 exception");
		mv.setViewName("error/error_back");
		return mv;
	}

}
