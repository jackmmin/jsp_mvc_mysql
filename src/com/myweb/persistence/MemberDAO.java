package com.myweb.persistence;

import com.myweb.domain.MemberVO;

public interface MemberDAO {
	int insert(MemberVO mvo);
	MemberVO selectOne(MemberVO mvo);
	int selectOne(String email);
	
}

/*

selectOne 메서드가 두 개지만 오버로딩을 통해 사용이 가능하다.

*/