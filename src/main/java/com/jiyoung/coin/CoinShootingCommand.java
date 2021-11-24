package com.jiyoung.coin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;

public class CoinShootingCommand implements CoinCommand {

	@Override
	public String execute(HttpServletRequest request, Model model)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		boolean sign = false;
		boolean sign2 = false;
		boolean shooting = false;
		int i = 0;
		int count = 1;
		
		String market = request.getParameter("market");
		Double high = Double.parseDouble(request.getParameter("high"));
		Double importance = Double.parseDouble(request.getParameter("importance"));
		//Double upline = Double.parseDouble(request.getParameter("upline"));
		Double downline = high * 1.005;
		Double discard = high * 0.99;
		UpbitApi ua = new UpbitApi("5QyLfwrLxvDK70FOuMzjkxBDANBVLKCuTeyXwf5E", "UgvJjixIp14rYg2UwdnjSgVpivTCDBOAX1Tn12fb", "https://api.upbit.com", market);
		if(Double.parseDouble(ua.getOrdersChance().get("ask_balance")) > 0)
			sign = true;
		Double price = ua.candleSelect();
		if(price >= downline){
			return "coin/home";
		}
		//System.out.println(sign + " " + shooting + " " + high + " " + downline + " " + discard + " " + price);
		//HashMap<String, String> params = ua.getOrdersChance();
		while(Switch.turn) {
			price = ua.candleSelect();
			System.out.println(sign + " " + sign2 + " " + shooting + " " + high + " " + downline + " " + discard + " " + price + " " + i + " " + count);
			if(!sign) { 
				if(price >= downline) {
					Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
					int balance = (int) (Math.round(dBalance * importance));
					ua.order("bid", null, Integer.toString(balance), "price");
					sign = true;
					sign2 = true;
					i = 0;
					count = 1;
					//wait = true;
				}
			}
			else {
				if(i < 7500) {
					if(i == 1500 * count) {
						sign2 = true;
						count++;
					}
					if(count <= 5 && price > downline * (1 + 0.01 * count))
						sign2 = false;
					i++;
				}
				if(price > high) {
					high = price;
				}
				if(!shooting && price >= downline * 1.07) {
					shooting = true;
				}
				if(shooting){
					downline = high * 1.005;
					discard = high * 0.98;
				}
				if(price <= discard || (i == 1500 * count && sign2)) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					System.out.println(sign + " " + shooting + " " + high + " " + downline + " " + discard + " " + price);
					sign = false;
					//wait = false;
					downline = high * 1.005;
					discard = high * 0.99; 
					if(!shooting) {
						//high = downline;
						//downline = high * 1.01;
						//discard = high * 0.99; 
					}else {
						shooting = false;
					}
					
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "coin/home";
	}

}
