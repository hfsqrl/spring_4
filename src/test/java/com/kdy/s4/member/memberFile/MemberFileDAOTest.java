package com.kdy.s4.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kdy.s4.MyTestCase;

public class MemberFileDAOTest extends MyTestCase {
	
	@Autowired
	private MemberFileDAO memberFileDAO;

	@Test(expected = RuntimeException.class)
	public void setInsertTest() throws Exception {
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("id2");
		memberFileDTO.setfileName("test file name");
		memberFileDTO.setoriName("test ori name");
		
		int result = memberFileDAO.setInsert(memberFileDTO);
		
		assertEquals(1, result);
	}
}
