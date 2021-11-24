package com.jiyoung.stock;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public class StockHomeCommand implements StockCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		StockDao sDao = new StockDao();
		ArrayList<StockDto> sDtos = sDao.selectAll();
		model.addAttribute("list", sDtos);
		return "stock/home";
	}
	
	public Object executeForAndroid(HttpServletRequest request) { return new Object(); }
}
