package com.jiyoung.member;

import java.util.ArrayList;

import org.springframework.ui.Model;

public class MemberListCommand implements MemberCommand{
	
	public void execute(Model model) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> dtos = dao.userSelect();
		model.addAttribute("list", dtos);
	}
	
}
