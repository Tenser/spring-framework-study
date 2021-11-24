package com.jiyoung.coin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;

public class CoinBoxDealCommand2 implements CoinCommand {

	@Override
	public String execute(HttpServletRequest request, Model model)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		String market = request.getParameter("market");
		Double upline = Double.parseDouble(request.getParameter("upline"));
		String downline1 = request.getParameter("downline1");
		String downline2 = request.getParameter("downline2");
		Double discard = Double.parseDouble(request.getParameter("discard"));
		UpbitApi ua = new UpbitApi("5QyLfwrLxvDK70FOuMzjkxBDANBVLKCuTeyXwf5E", "UgvJjixIp14rYg2UwdnjSgVpivTCDBOAX1Tn12fb", "https://api.upbit.com", market);
		Double price;
	
		Double balance = Double.parseDouble(ua.getOrdersChance().get("ask_balance"));
		Double volume1 = balance * 0.49 / Double.parseDouble(downline1);
		Double volume2 = balance * 0.49 / Double.parseDouble(downline2);
		//String uuid1 = ua.order("bid", Double.toString(volume1), downline1, "limit");
		//String uuid2 = ua.order("bid", Double.toString(volume2), downline2, "limit");
		System.out.println(upline);
		//HashMap<String, String> params = ua.getOrdersChance();
		while(Switch.turn) {
			price = ua.candleSelect();
			System.out.println(price);
			if(price >= upline) {
				String aBalance = ua.getOrdersChance().get("ask_balance");
				if (Double.parseDouble(aBalance) > 0) {
					ua.order("ask", aBalance, null, "market");
					
				}
			}else if(price < discard) {
				String aBalance = ua.getOrdersChance().get("ask_balance");
				if (Double.parseDouble(aBalance) > 0) {
					ua.order("ask", aBalance, null, "market");
				}
				break;
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "coin/home";
	}

}
