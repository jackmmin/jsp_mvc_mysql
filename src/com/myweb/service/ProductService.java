package com.myweb.service;

import java.util.List;

import com.myweb.domain.ProductVO;

public interface ProductService {
	int register(ProductVO pvo);
	List<ProductVO> getList();
	ProductVO getDetail(int pno);
	int modify(ProductVO pvo);
	int delete(int pno);
}
