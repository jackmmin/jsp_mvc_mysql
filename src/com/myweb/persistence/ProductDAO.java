package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.ProductVO;

public interface ProductDAO {
	int insert(ProductVO pvo);
	List<ProductVO> selectList();
	ProductVO selectOne(int pno);
	int update(ProductVO pvo);
	int delete(int pno);
	
}
