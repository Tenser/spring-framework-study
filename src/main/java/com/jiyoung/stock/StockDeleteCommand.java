package com.jiyoung.stock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class StockDeleteCommand implements StockCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		String code = request.getParameter("code");
		StockDao sDao = new StockDao();
		sDao.delete(code);
		return "redirect:/stock";
	}

	@Override
	public Object executeForAndroid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
