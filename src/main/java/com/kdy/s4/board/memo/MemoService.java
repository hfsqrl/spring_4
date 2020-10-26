package com.kdy.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdy.s4.util.Pager;

@Service
public class MemoService {
	
	@Autowired
	private MemoDAO memoDAO;	// dao를 참조
	
	public int setDelete(MemoDTO memoDTO) throws Exception {
		return memoDAO.setDelete(memoDTO);
	}
	
	public MemoDTO getOne(MemoDTO memoDTO) throws Exception {
		return memoDAO.getOne(memoDTO);
	}
	
	public int setInsert(MemoDTO memoDTO) throws Exception {
		return memoDAO.setInsert(memoDTO);
	}
	
	public List<MemoDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(memoDAO.getCount(pager));	// makePage 만들기 전에 
		pager.makePage();
		
		return memoDAO.getList(pager);
	}

}
