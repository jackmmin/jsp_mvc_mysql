package com.myweb.persistence;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.ProductVO;
import com.myweb.orm.DBBuilder;
public class ProductDAOImp implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImp.class);
	private SqlSession sql;
	private static final String NS = "productMapper.";

	public ProductDAOImp() {
		new DBBuilder();
		sql = DBBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(ProductVO pvo) {
		int isOk = sql.insert(NS+"padd", pvo);
		sql.commit();
		return isOk;
	}

	@Override
	public List<ProductVO> selectList() {
		return sql.selectList(NS+"list");
	}

	@Override
	public ProductVO selectOne(int pno) {
		return sql.selectOne(NS+"detail", pno);
	}

	@Override
	public int update(ProductVO pvo) {
		int isOk = sql.insert(NS+"modify", pvo);
		sql.commit();
		return isOk;
	}

	@Override
	public int delete(int pno) {
		int isOk = sql.insert(NS+"delete", pno);
		sql.commit();
		return isOk;
	}
}
