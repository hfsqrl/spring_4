package com.kdy.s4.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	// MultipartFile transferTo
	public String saveTransfer(File dest, MultipartFile multipartFile) throws Exception {

		// 저장 폴더 생성
		if(!dest.exists()) {
			dest.mkdir();
		}
		
		// 저장할 이름 완성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		// 저장할 곳
		dest = new File(dest, fileName);
		
		multipartFile.transferTo(dest);
		
		return fileName;
	}
	
	// FilecopyUtil.copy 사용
	public String saveCopy(File dest, MultipartFile multipartFile) throws Exception {
		
		// 저장 폴더 생성
		if(!dest.exists()) {
			dest.mkdir();
		}
		
		// 저장할 이름 완성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		// 저장할 곳
		dest = new File(dest, fileName);
		
		FileCopyUtils.copy(multipartFile.getBytes(), dest);
		
		return fileName;
		
	}

}
