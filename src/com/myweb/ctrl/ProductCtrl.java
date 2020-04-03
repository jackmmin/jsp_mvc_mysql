package com.myweb.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.ProductVO;
import com.myweb.service.ProductService;
import com.myweb.service.ProductServiceImp;

@WebServlet("/pCtrl")
public class ProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(ProductCtrl.class);
       
    public ProductCtrl() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info(">>> ProductCtrl In!");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ProductService psv = new ProductServiceImp();
		
		String sign = request.getParameter("sign");
		
		if(sign.equals("list")) {
			List<ProductVO> pList = psv.getList();
			
			if(pList != null) {
				request.setAttribute("list", pList);
				RequestDispatcher rdp = request.getRequestDispatcher("/product/list.jsp");
				rdp.forward(request, response);
			}else {
				log.info("상품 리스트 출력 실패");
			}
			
		}else if(sign.equals("upload")) {
			String pname = request.getParameter("i_pname");
			String category = request.getParameter("i_category");
			String pwriter = request.getParameter("i_pwriter");
			String content = request.getParameter("i_content");
			String imgfile = request.getParameter("i_imgfile");
			
			/*ProductVO pvo = new ProductVO(category, pname, content, pwriter, imgfile);
			psv.register(pvo);*/
			int isOk = psv.register(new ProductVO(category, pname, content, pwriter, imgfile));
			
			if(isOk > 0) {
				log.info("상품등록 성공");
				RequestDispatcher rdp = request.getRequestDispatcher("pCtrl?sign=list");
				rdp.forward(request, response);
			}else {
				log.info("상품등록 실패");
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
