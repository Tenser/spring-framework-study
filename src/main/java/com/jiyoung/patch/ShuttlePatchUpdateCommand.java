package com.jiyoung.patch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ShuttlePatchUpdateCommand implements ShuttlePatchCommand {

	@Override
	public Object execute(HttpServletRequest request, Model model) {
		ProfileDao dao = new ProfileDao();
		dao.updatePower(request.getParameter("power1"), 7);
		dao.updatePower(request.getParameter("power2"), 6);
		dao.updatePower(request.getParameter("power3"), 5);
		dao.updatePower(request.getParameter("power4"), 4);
		dao.updatePower(request.getParameter("power5"), 3);
		dao.updatePower(request.getParameter("power6"), 2);
		dao.updatePower(request.getParameter("power7"), 1);
		dao.updatePopularity(request.getParameter("favorite"));
		return null;
	}

}
