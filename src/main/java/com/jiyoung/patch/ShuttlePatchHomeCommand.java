package com.jiyoung.patch;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jiyoung.member.MemberDAO;

public class ShuttlePatchHomeCommand implements ShuttlePatchCommand {

	@Override
	public Object execute(HttpServletRequest request, Model model) {
		MemberDAO mDao = new MemberDAO();
		ProfileDao pDao = new ProfileDao();
		String id = (String) request.getSession().getAttribute("id");
		String name = null;
		if(id == null) name = "ºñÈ¸¿ø";
		else name = mDao.getIdByName(id);
		ArrayList<ProfileDto> powerDtos = pDao.selectByPower2();
		ArrayList<ProfileDto> popularityDtos = pDao.selectByPopularity2();
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("list1", powerDtos);
		model.addAttribute("list2", popularityDtos);
		return null;
	}

}
