package com.jiyoung.stock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import java.util.ArrayList;

public class StockRecommendedCommand implements StockCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		StockDao sDao = new StockDao();
		ArrayList<StockDto> sDtos = sDao.selectRecommended();
		model.addAttribute("list", sDtos);
		return "stock/recommend";
	}

	@Override
	public Object executeForAndroid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
