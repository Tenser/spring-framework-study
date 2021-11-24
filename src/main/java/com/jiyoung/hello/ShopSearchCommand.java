package com.jiyoung.hello;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.springframework.ui.Model;

public class ShopSearchCommand implements ShopCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		String word = request.getParameter("word");
		GoodsDao gDao = new GoodsDao();
		ArrayList<GoodsDto> gDtos = gDao.search(word);
		model.addAttribute("goods", gDtos);
		return "result";
	}

}
