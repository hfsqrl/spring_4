package com.kdy.s4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kdy.s4.member.MemberDTO;

@Component
public class QnaInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Controller 진입 전");
		
		System.out.println("preHandle request : "+request);
		System.out.println("preHandle response : "+response);
		System.out.println("preHandle handler : "+handler);
		
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Controller 진입 후");
		
		System.out.println("postHandle request : "+request);
		System.out.println("postHandle response : "+response);
		System.out.println("postHandle handler : "+handler);
		System.out.println("postHandle modelAndView : "+modelAndView);
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("jsp(view)를 렌더링 후 response가 나가기 전");
		
		System.out.println("afterCompletion request : "+request);
		System.out.println("afterCompletion response : "+response);
		System.out.println("afterCompletion handler : "+handler);
		System.out.println("afterCompletion ex : "+ex);
		
		super.afterCompletion(request, response, handler, ex);
	}

}
