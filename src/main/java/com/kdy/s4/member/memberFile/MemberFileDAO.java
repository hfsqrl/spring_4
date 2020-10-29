package com.kdy.s4.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdy.s4.member.MemberDTO;

@Repository
public class MemberFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kdy.s4.member.memberFile.MemberFileDAO.";
	
	// setInsert
	// memberFile 테이블에 insert, insert문이니까 int????????
	public int setInsert(MemberFileDTO memberFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", memberFileDTO);
	}
	
	// getOne
	public MemberFileDTO getOne(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getOne", memberDTO);
	}

}
