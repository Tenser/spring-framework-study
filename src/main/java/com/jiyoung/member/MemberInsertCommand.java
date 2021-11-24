package com.jiyoung.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class MemberInsertCommand implements MemberCommand{
	
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		MemberDAO dao = new MemberDAO();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberDTO dto = new MemberDTO(id,password,name,phone);
		dao.insert(dto);
	}
	
}
