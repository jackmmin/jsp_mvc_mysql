package com.myweb.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.MemberVO;
import com.myweb.service.MemberService;
import com.myweb.service.MemberServiceImp;

@WebServlet("/mCtrl")
public class MemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(MemberCtrl.class);

	public MemberCtrl() {}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.info(">>> MemberCtrl In !");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		MemberService msv = new MemberServiceImp();
		String sign = req.getParameter("sign"); // sign은 index.jsp에서 넘어온다
		
		if(sign.equals("register")) {
			String email = req.getParameter("i_email");
			String nickname = req.getParameter("i_nickname");
			String pwd = req.getParameter("i_pwd");
			
			MemberVO mvo = new MemberVO(email, nickname, pwd);
			int isOk = msv.register(mvo);
			
			if(isOk > 0) {
				log.info("회원가입 성공");
			}else {
				log.info("회원가입 실패");
			}
			
			RequestDispatcher rdp = req.getRequestDispatcher("index.jsp?pg=wc");
			rdp.forward(req, res);
			
		}else if(sign.equals("login")) {
			
		}else if(sign.equals("idCheck")) {
			
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
