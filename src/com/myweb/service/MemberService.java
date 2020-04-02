package com.myweb.service;

import com.myweb.domain.MemberVO;

public interface MemberService {
	int register(MemberVO mvo);
	MemberVO login(MemberVO mvo);
	int idCheck(String email);
}
