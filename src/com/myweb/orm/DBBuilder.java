package com.myweb.orm;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBBuilder {
	private static Logger log = LoggerFactory.getLogger(DBBuilder.class);
	private static SqlSessionFactory factory;
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("com/myweb/orm/MybatisConfig.xml"));
		} catch (IOException e) {
			log.info(">>> DB Config Fail");
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}

/*

static 중괄호열고닫고 는 라인은 스태틱 생성자
SqlSessionFactoryBuilder는 구현체

저장하려면 setter 가져오려면 getter

implement는 규격화
class는 구현

*/
