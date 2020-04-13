package com.myweb.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.ProductVO;
import com.myweb.persistence.ProductDAO;
import com.myweb.persistence.ProductDAOImp;
public class ProductServiceImp implements ProductService {
	private static Logger log = LoggerFactory.getLogger(ProductServiceImp.class);
	private ProductDAO pdao;
	
	public ProductServiceImp() {
		pdao = new ProductDAOImp();
	}
	
	@Override
	public int register(ProductVO pvo) {
		return pdao.insert(pvo);
	}
	
	@Override
	public List<ProductVO> getList() {
		return pdao.selectList();
	}

	@Override
	public ProductVO getDetail(int pno) {
		return pdao.selectOne(pno);
	}

	@Override
	public int modify(ProductVO pvo) {
		return pdao.update(pvo);
	}

	@Override
	public int delete(int pno) {
		return pdao.delete(pno);
	}
}