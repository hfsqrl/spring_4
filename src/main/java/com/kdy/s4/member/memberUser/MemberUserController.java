package com.kdy.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kdy.s4.member.MemberDTO;

@Controller
@RequestMapping("/member/**")
public class MemberUserController {
	
	@Autowired
	private MemberUserService memberUserService;
	
	// idcheck
	@GetMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberIdCheck(memberDTO);
		
		int result = 1; // 중복
		if(memberDTO == null) {
			result = 0;
		}
		
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}

	// join
	@GetMapping("memberJoin")
	public ModelAndView setMemberJoin() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberJoin(MemberDTO memberDTO, MultipartFile photo) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getName());
		System.out.println(photo.getSize());
		System.out.println(photo.getContentType());
		
		//int result = memberUserService.setMemberJoin(memberDTO);
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	// setMemberDelete
	@GetMapping("memberDelete")
	public ModelAndView setMemberDelete(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberUserService.setMemberDelete(memberDTO);
		
		session.invalidate();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	// setMemberUpdate
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberUpdate");
		
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO s = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(s.getId());
		System.out.println(memberDTO.getEmail());
		System.out.println(memberDTO.getName());
		System.out.println(memberDTO.getId());
		int result = memberUserService.setMemberUpdate(memberDTO);
		
		if(result>0) {
			s.setName(memberDTO.getName());
			s.setEmail(memberDTO.getEmail());
			session.setAttribute("member", s);
		} 
		
		mv.setViewName("redirect:./memberPage");
		
		return mv;
	}
	
	// getMemberPage
	@GetMapping("memberPage")
	public ModelAndView getMemberPage() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		
		return mv;
	}
	
	// memberLogout
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession session) throws Exception {
		// 웹브라우저 종료
		// 일정시간 경과
		// memberDTO를 null로 대체
		// 세션 유지 시간을 강제로 0으로 변경
		session.invalidate(); // 세션 유지 시간을 강제로 0으로 변경
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	// getMemberLogin
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		
		return mv;
	}

	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		
		if(memberDTO != null) {
			// 로그인이 성공하면 index.jsp로 이동
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		} else {
			// 로그인이 실패하면 메세지를 alert
			// 로그인 입력 폼으로 이동
			// foward
			mv.addObject("msg", "login fail");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
			
		}
		
		return mv;
	}

}
