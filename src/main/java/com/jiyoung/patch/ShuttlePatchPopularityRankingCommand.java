package com.jiyoung.patch;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ShuttlePatchPopularityRankingCommand implements ShuttlePatchCommand {

	@Override
	public Object execute(HttpServletRequest request, Model model) {
		ProfileDao dao = new ProfileDao();
		ArrayList<ProfileDto> dtos = dao.selectByPopularity();
		model.addAttribute("list", dtos);
		return null;
	}

}
