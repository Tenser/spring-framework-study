package com.jiyoung.stock;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class StockRedAndBlueCommand implements StockCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		StockDao sDao = new StockDao();
		ArrayList<StockDto> sRedDtos = sDao.selectRed();
		ArrayList<StockDto> sBlueDtos = sDao.selectBlue();
		model.addAttribute("reds", sRedDtos);
		model.addAttribute("blues", sBlueDtos);
		return "stock/divide";
	}
	
	public Object executeForAndroid(HttpServletRequest request) { return new Object(); }

}
