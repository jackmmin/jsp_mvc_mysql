package com.myweb.persistence;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.MemberVO;
import com.myweb.orm.DBBuilder;

public class MemberDAOImp implements MemberDAO {
	private static Logger log = LoggerFactory.getLogger(MemberDAOImp.class);
	private SqlSession sql;
	private static final String NS = "memberMapper.";
	
	public MemberDAOImp() {
		DBBuilder DBBuilder = new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		int isOk = sql.insert(NS+"madd", mvo);
		sql.commit();
		return isOk;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public int selectOne(String email) {
		return sql.selectOne(NS+"idCheck", email);
	}
}

/*

NS는 namespace
이곳의 namespace는 MemberMapper.xml의 namespace와 같아야 한다.
DBBuilder는 static으로 만들어졌기 때문에 사라지지 않는다.
DBBuilder는 getFactory로 openSession이란 메서드.

getFactory()는 내가 만들 메서드
openSession()은 SqlSession을 통해 가져와서 사용하는 메서드

cn에서 가져온 값을 ds에 저장  
ds에서 가져온 값을 pst에 저장
pst에서 가져온 값을 rs에 저장해서 if와 while을 돌리는데 이 계산들을 다 자동으로 해준다.
 
SqlSession이 규격을 주고 sqlsessionFactory를 통해

insert는 

*/