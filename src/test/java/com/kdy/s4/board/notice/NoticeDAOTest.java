package com.kdy.s4.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kdy.s4.MyTestCase;
import com.kdy.s4.board.BoardDTO;
import com.kdy.s4.board.file.BoardFileDTO;
import com.kdy.s4.util.Pager;

public class NoticeDAOTest extends MyTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void setInsertFileTest() throws Exception {
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		
		boardFileDTO.setNum(117);
		boardFileDTO.setFileName("test file name");
		boardFileDTO.setOriName("test ori name");
		
		int result = noticeDAO.setInsertFile(boardFileDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void getListTest() throws Exception {
		
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> ar = noticeDAO.getList(pager);
		
		System.out.println(ar.size());
		
		assertEquals(10, ar.size());
		
	}
	
	//@Test
	public void setInsertTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title test");
		boardDTO.setWriter("writer test");
		boardDTO.setContents("contents test");
		
		int result = noticeDAO.setInsert(boardDTO);
		
		assertEquals(1, result);
		
	}

}
