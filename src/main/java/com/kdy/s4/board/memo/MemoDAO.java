package com.kdy.s4.board.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.kdy.s4.util.Pager;

@Repository
public class MemoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kdy.s4.board.memo.MemoDAO.";
	
	public int setDelete(MemoDTO memoDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", memoDTO);
	}
	
	public MemoDTO getOne(MemoDTO memoDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getOne", memoDTO);
	}
	
	public int setInsert(MemoDTO memoDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", memoDTO);
	}
	
	public List<MemoDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

}
