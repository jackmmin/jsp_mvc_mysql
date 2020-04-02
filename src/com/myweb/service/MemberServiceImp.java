package com.myweb.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.MemberVO;
import com.myweb.persistence.MemberDAO;
import com.myweb.persistence.MemberDAOImp;

public class MemberServiceImp implements MemberService {
	private static Logger log = LoggerFactory.getLogger(MemberServiceImp.class);
	private MemberDAO mdao;
	
	public MemberServiceImp() {
		mdao = new MemberDAOImp();
	}

	@Override
	public int register(MemberVO mvo) {
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return mdao.selectOne(mvo);
	}

	@Override
	public int idCheck(String email) {
		return mdao.selectOne(email);
	}
}

/*

mdao = new MemberDAOImp(); 를 수행하게 되면 DB와 연결이 가능한 상태가 된다.

*/
