package com.kdy.s4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kdy.s4.MyTestCase;
import com.kdy.s4.board.BoardDTO;
import com.kdy.s4.util.Pager;

public class QnaDAOTest extends MyTestCase {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getListTest() throws Exception {
		
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> ar = qnaDAO.getList(pager);
		
		System.out.println(ar.size());
		
		assertNotEquals(0, ar.size());
		
	}
	
	//@Test
	public void setInsertTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title test");
		boardDTO.setWriter("writer test");
		boardDTO.setContents("contents test");
		
		int result = qnaDAO.setInsert(boardDTO);
		
		assertEquals(1, result);
	}

}
