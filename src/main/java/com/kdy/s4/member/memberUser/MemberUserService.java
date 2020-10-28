package com.kdy.s4.member.memberUser;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kdy.s4.member.MemberDTO;
import com.kdy.s4.member.MemberService;
import com.kdy.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		// hdd 어느 폴더에 어떤 이름으로 저장을 할거냐 > 경로명을 써야 > 워크스페이스 실제 경로명?
		// path : 저장할 폴더 경로, 이클립스에서 만든 경로와 동일하게. src/main/webapp을 제외하고
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		System.out.println(path);
		File file = new File(path);
		
		//fileSaver.saveCopy(file, photo);
		fileSaver.saveCopy(file, photo);
		
		
		
//		// 이름 > 중복될 수 없는 이름
//		// 1. 현재시간
//		Calendar ca = Calendar.getInstance();
//		long time = ca.getTimeInMillis();
//		String name = photo.getOriginalFilename();
//		name = time+"_"+name;
//		System.out.println(name);
//		
//		// 2. unique한 이름 생성하는 객체
//		name = UUID.randomUUID().toString();
//		name = name+"_"+photo.getOriginalFilename();
//		System.out.println(name);
//		
//		File file = new File(path, name);
//		
//		// hdd 저장
//		// 1. FileCopyUtils(소스, 목적지) 라는 객체의 메서드 활용. 이클립스에서 제공
//		// byte [] ar = photo.getBytes(); // 파일의 2진 데이터 넣는 배열
//		// FileCopyUtils.copy(ar, file);
//		
//		// 2. MultipartFile 객체에 있는 메서드 활용
//		photo.transferTo(file);
//		
//		//fileSaver.save(files, session);
//		
		/*
		 매개변수 받아와서 > 경로 만들고 > 중복될 수 없는 이름 설정 
		 > 2진 데이터로 넘어오는 파일을 저장할 byte 타입 배열 만들고
		 > FileCopyUtils(소스, 목적지) 라는 객체의 메서드 활용해서 만든 경로에 저장
		*/
		
		return 0; //memberUserDAO.setMemberJoin(memberDTO);
	}
	
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}

}
