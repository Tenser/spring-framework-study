package com.jiyoung.stock;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class StockSearchCommand implements StockCommand {

	@Override
	public String execute(HttpServletRequest request, Model model) {
		StockDao sDao = new StockDao();
		String word = request.getParameter("word");
		ArrayList<StockDto> sDtos = sDao.search(word);
		model.addAttribute("list", sDtos);
		return "stock/result";
	}
	
	public Object executeForAndroid(HttpServletRequest request) {
		StockDao sDao = new StockDao();
		String word = request.getParameter("word");
		ArrayList<StockDto> sDtos = sDao.search(word);
		ArrayList<TimeUpdateDto> tDtos = sDao.selectUpdateTime();
		Timestamp date = tDtos.get(0).getCurrenttime();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(Calendar.HOUR, -9);
		Timestamp correctDate = new Timestamp(cal.getTime().getTime());
		Map<String, String> result = new HashMap<String, String>();
		if(sDtos.size() == 1) {
			result.put("code", sDtos.get(0).getCode());
			result.put("name", sDtos.get(0).getName());
			result.put("today", Integer.toString(sDtos.get(0).getToday_price()));
			result.put("next", Integer.toString(sDtos.get(0).getNext_price()));
			result.put("date", correctDate.toString());
			result.put("accuracy", Integer.toString(sDtos.get(0).getAccuracy()));
		}
		return result;
	}

}
