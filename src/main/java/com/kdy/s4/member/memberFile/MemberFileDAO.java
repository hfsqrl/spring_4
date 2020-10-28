package com.kdy.s4.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
