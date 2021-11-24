package com.jiyoung.coin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;

public class CoinOrderbookDealCommand implements CoinCommand {

	@Override
	public String execute(HttpServletRequest request, Model model)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		boolean sign = false;
		boolean goHigh = false;
		
		String market = request.getParameter("market");
		int bookSize = Integer.parseInt(request.getParameter("book_size"));
		Double bidhigh = Double.parseDouble(request.getParameter("bid_high"));
		Double bidrangeUp = Double.parseDouble(request.getParameter("bid_range_up"));
		Double bidrangeDown = Double.parseDouble(request.getParameter("bid_range_down"));
		Double askStandard = Double.parseDouble(request.getParameter("ask_standard"));
		Double importance = Double.parseDouble(request.getParameter("importance"));
		Double sleepTime = Double.parseDouble(request.getParameter("sleep_time"));
		
		UpbitApi ua = new UpbitApi("5QyLfwrLxvDK70FOuMzjkxBDANBVLKCuTeyXwf5E", "UgvJjixIp14rYg2UwdnjSgVpivTCDBOAX1Tn12fb", "https://api.upbit.com", market);
		
		while(Switch.turn) {
			HashMap<String, Double> sums = ua.orderbookSelect(bookSize);
			Double divided = sums.get("ask_sum")/sums.get("bid_sum");
			
			System.out.println(sign + " " + divided);
			if(!sign) {
				if(divided >= bidhigh) {
					int balance = (int) (Math.round(Double.parseDouble(ua.getOrdersChance().get("bid_balance")) * importance));
					ua.order("bid", null, Integer.toString(balance), "price");
					sign = true;
				}
			}else {
				if(divided <= askStandard) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					sign = false;
				}
			}
			
			try {
				Thread.sleep(Math.round(sleepTime*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "coin/home";
	}

}
