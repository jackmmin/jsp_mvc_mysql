package com.myweb.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.MemberVO;
import com.myweb.service.MemberService;
import com.myweb.service.MemberServiceImp;

@WebServlet("/mCtrl")
public class MemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(MemberCtrl.class);

	public MemberCtrl() {
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.info(">>> MemberCtrl In !");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");

		MemberService msv = new MemberServiceImp();
		String sign = req.getParameter("sign"); // sign은 index.jsp에서 넘어온다

		if (sign.equals("register")) {
			String email = req.getParameter("i_email");
			String nickname = req.getParameter("i_nickname");
			String pwd = req.getParameter("i_pwd");

			MemberVO mvo = new MemberVO(email, nickname, pwd);
			int isOk = msv.register(mvo);

			if (isOk > 0) {
				log.info("회원가입 성공");
			} else {
				log.info("회원가입 실패");
			}

			RequestDispatcher rdp = req.getRequestDispatcher("index.jsp?pg=wc");
			rdp.forward(req, res);

		} else if (sign.equals("login")) {
			String email = req.getParameter("i_email");
			String pwd = req.getParameter("i_pwd");

			MemberVO mvo = msv.login(new MemberVO(email, pwd));
			
			if (mvo != null) {
				log.info("로그인 성공");
				HttpSession session = req.getSession(); // session을 열겠다.
				session.setAttribute("email", mvo.getEmail());
				session.setAttribute("nickname", mvo.getNickname());
				session.setAttribute("grade", mvo.getGrade());
				session.setMaxInactiveInterval(60 * 10);
				
				RequestDispatcher rdp = req.getRequestDispatcher("index.jsp?pg=ls");
				rdp.forward(req, res);
				
			} else {
				log.info("로그인 실패");
			}

		} else if(sign.equals("idCheck")) {
			String email = req.getParameter("email");
			log.info("mCtrl>>> " + email);
			int isExist = msv.idCheck(email);
			
			if(isExist > 0 ) {
				log.info(">>> 회원가입 불가");
			}else {
				log.info(">>> 회원가입 가능");
			}
			
			PrintWriter out = res.getWriter();
			out.print(isExist); // ajax
			
		}else if(sign.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			
			RequestDispatcher rdp = req.getRequestDispatcher("index.jsp?pg=bye");
			rdp.forward(req, res);
		}


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
