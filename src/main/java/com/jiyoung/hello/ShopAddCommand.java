package com.jiyoung.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ShopAddCommand implements ShopCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String discript = request.getParameter("discript");
		String kind = request.getParameter("kind");
		GoodsDao gDao = new GoodsDao();
		gDao.insert(name, price, discript, kind);
		return "redirect:add";
	}

}
