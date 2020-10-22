package com.kdy.s4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kdy.s4.MyTestCase;
import com.kdy.s4.board.BoardDTO;
import com.kdy.s4.util.Pager;

public class QnaServiceTest extends MyTestCase {
	
	@Autowired
	private QnaService qnaService;
	
	@Test
	public void getListTest() throws Exception {
		
		Pager pager = new Pager();
		
		List<BoardDTO> ar = qnaService.getList(pager);
		
		assertEquals(10, ar.size());
		
	}

}
