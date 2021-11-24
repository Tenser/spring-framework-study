package com.jiyoung.patch;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ShuttlePatchPowerRankingCommand implements ShuttlePatchCommand {

	@Override
	public Object execute(HttpServletRequest request, Model model) {
		ProfileDao dao = new ProfileDao();
		ArrayList<ProfileDto> dtos = dao.selectByPower();
		model.addAttribute("list", dtos);
		return null;
	}

}
