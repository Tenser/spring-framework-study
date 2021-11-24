package com.jiyoung.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class MemberDeleteCommand implements MemberCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		dao.delete(id);
	}

}
