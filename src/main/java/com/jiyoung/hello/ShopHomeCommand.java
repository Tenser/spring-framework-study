package com.jiyoung.hello;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public class ShopHomeCommand implements ShopCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		GoodsDao gDao = new GoodsDao();
		ArrayList<GoodsDto> gDtos = gDao.selectAll();
		model.addAttribute("goods", gDtos);
		return "home";
	}

}
