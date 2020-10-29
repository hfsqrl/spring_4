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
import com.kdy.s4.member.memberFile.MemberFileDAO;
import com.kdy.s4.member.memberFile.MemberFileDTO;
import com.kdy.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private MemberFileDAO MemberFileDAO;
	@Autowired
	private FileSaver fileSaver;
	
	// my page 정보를 보기 위해
//	public MemberFileDTO getOne(MemberDTO memberDTO) throws Exception {
//		return MemberFileDAO.getOne(memberDTO);
//	}
	
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
		// getRealPath - 하고 있는 프로젝트가 hdd어디에 저장 되어 있냐
		// 파일을 저장하기 위한 폴더를 지정하기 위해 getRealPath를 이용. 어느 컴퓨터에 있든, 정확한 위치를 반환 할 수 있도록
		File file2 = new File(path);
		if(!file2.exists()) {
			file2.mkdirs();
		}
		
		System.out.println(path);
		File file = new File(path);
		
		int result = memberUserDAO.setMemberJoin(memberDTO);
		
		// 이름 > 중복될 수 없는 이름
		String fileName = "";
		if(photo.getSize()!=0) {	// 
			fileName = fileSaver.saveCopy(file, photo);
			
			// hdd 저장
			//fileSaver.saveCopy(file, photo);
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(photo.getOriginalFilename());
			
			result = MemberFileDAO.setInsert(memberFileDTO);
		}

		
		//System.out.println("test"); // 중간 테스트
		
		
		//System.out.println(result); // 중간 테스트
		
		
		//System.out.println("test : "+result); // 중간 테스트
		
		return result;
		
		
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
