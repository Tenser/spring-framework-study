package com.jiyoung.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;


public class MemberLoginCommand implements MemberCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MemberDAO dao = new MemberDAO();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//String msg = null;
		if (dao.idCheck(id)) {
			if(dao.pwCheck(id, password)) {
				session.setAttribute("id", id);
				//msg = "login!";
			}else {
				//msg = "wrong password";
			}
		}else {
			//msg = "wrong id";
		}
		//model.addAttribute("msg", msg);
	}

}
