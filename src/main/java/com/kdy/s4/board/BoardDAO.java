package com.kdy.s4.board;

import java.util.List;

import com.kdy.s4.util.Pager;

public interface BoardDAO {
	
	// 추상메서드
	// abstract
	// 메서드의 선언부만 있는, body가 없는
	
	// insert
	public int setInsert(BoardDTO boardDTO) throws Exception; // 선언부까지라서 ()하고 바로 ;
	
	// update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	// delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	// list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	// selectOne
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception;
	
	// count
	public long getCount(Pager pager) throws Exception;

}
