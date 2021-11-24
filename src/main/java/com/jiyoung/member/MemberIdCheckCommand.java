package com.jiyoung.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class MemberIdCheckCommand implements MemberCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		MemberDAO dao = new MemberDAO();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		boolean result = dao.idCheck(id);
		model.addAttribute("result", result);

	}

}
