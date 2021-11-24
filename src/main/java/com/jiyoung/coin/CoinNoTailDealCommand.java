package com.jiyoung.coin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;

public class CoinNoTailDealCommand implements CoinCommand {

	@Override
	public String execute(HttpServletRequest request, Model model)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		String market = request.getParameter("market");
		String minute = request.getParameter("minute");
		Double cellPoint = Double.parseDouble(request.getParameter("cell_point1"));
		Double cellPoint2 = Double.parseDouble(request.getParameter("cell_point2"));
		Double importance = Double.parseDouble(request.getParameter("importance"));
		Double sleepTime = Double.parseDouble(request.getParameter("sleep_time"));
		UpbitApi ua = new UpbitApi("5QyLfwrLxvDK70FOuMzjkxBDANBVLKCuTeyXwf5E", "UgvJjixIp14rYg2UwdnjSgVpivTCDBOAX1Tn12fb", "https://api.upbit.com", market);
		boolean sign = false;
		
		Double avgPrice = 0.0;
		Double tradePrice = 0.0;
		ArrayList<Double> list;
		
		while(Switch.turn) {
			list = ua.candleSelect2(minute);
			if(!sign) {
				if(Double.compare(list.get(0), 1.0) == 0) {
					avgPrice = list.get(1);
					Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
					int balance = (int) (Math.round(dBalance * importance));
					//ua.order("bid", null, Integer.toString(5010), "price");
					sign = true;
					
				}
				System.out.println(sign + " " + avgPrice);
			}else{
				tradePrice = list.get(1);
				if(tradePrice >= avgPrice * cellPoint || tradePrice < avgPrice * cellPoint2) {
					String balance = ua.getOrdersChance().get("ask_balance");
					//ua.order("ask", balance, null, "market");
					sign = false;
					
				}
				System.out.println(sign + " " + avgPrice + " " + tradePrice);
			}
			
			try {
				Thread.sleep(Math.round(sleepTime * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "coin/home";
	}

}
