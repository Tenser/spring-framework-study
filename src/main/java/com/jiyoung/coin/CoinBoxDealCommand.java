package com.jiyoung.coin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.ParseException;
import org.springframework.ui.Model;

public class CoinBoxDealCommand implements CoinCommand {
	
	public String execute(HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException {
		
		boolean sign1 = false;
		boolean sign2 = false;
		int pos;
		String market = request.getParameter("market");
		Double upline = Double.parseDouble(request.getParameter("upline"));
		Double downline1 = Double.parseDouble(request.getParameter("downline1"));
		Double downline2 = Double.parseDouble(request.getParameter("downline2"));
		Double discard = Double.parseDouble(request.getParameter("discard"));
		if(request.getParameterValues("sign1") != null)
			sign1 = true;
		if(request.getParameterValues("sign2") != null)
			sign2 = true;
		UpbitApi ua = new UpbitApi("5QyLfwrLxvDK70FOuMzjkxBDANBVLKCuTeyXwf5E", "UgvJjixIp14rYg2UwdnjSgVpivTCDBOAX1Tn12fb", "https://api.upbit.com", market);
		//if(Double.parseDouble(ua.getOrdersChance().get("ask_balance")) > 0)
			//sign = true;
		Double price = ua.candleSelect();
		if(price >= upline) {
			pos = 2;
		}else if(price > downline1){
			pos = 1;
		}else if(price > downline2){
			pos = 0;
		}else {
			pos = -1;
		}
		//HashMap<String, String> params = ua.getOrdersChance();
		while(Switch.turn) {
			price = ua.candleSelect();
			System.out.println(sign1 + " " + sign2 + " " + pos + " " + price);
			if(!sign1 && !sign2) {
				if(pos == -1) {
					if(price > downline1) {
						Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
						int balance = (int) (Math.round(dBalance * 0.49));
						ua.order("bid", null, Integer.toString(balance), "price");
						sign1 = true;
						pos = 1;
				}else if(price > downline2) {
						Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
						int balance = (int) (Math.round(dBalance * 0.49));
						ua.order("bid", null, Integer.toString(balance), "price");
						sign2 = true;
						pos = 0;
					}
					
				}else if(pos == 0){
					if(price <= discard) {
						pos = -1;
					}else if(price <= downline2) {
						Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
						int balance = (int) (Math.round(dBalance * 0.49));
						ua.order("bid", null, Integer.toString(balance), "price");
						sign2 = true;
						pos = -1;
					}
				}else {
					if(price <= downline2) {
						Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
						int balance = (int) (Math.round(dBalance * 0.49));
						ua.order("bid", null, Integer.toString(balance), "price");
						sign1 = true;
						sign2 = true;
						pos = -1;
					}else if(price <= downline1) {
						Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
						int balance = (int) (Math.round(dBalance * 0.49));
						ua.order("bid", null, Integer.toString(balance), "price");
						sign1 = true;
						pos = 0;
					}
				}
			}else if(!sign1 && sign2) {
				//if(pos == 0) {
				if(price >= upline) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					sign2 = false;
					pos = 2;
				}else if(price > downline1) {
						Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
						int balance = (int) (Math.round(dBalance * 0.98));
						ua.order("bid", null, Integer.toString(balance), "price");
						sign1 = true;
						pos = 1;
				}
				if(price <= discard) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					sign2 = false;
					pos = -1;
				}
					
				//}
			}else if(sign1 && !sign2) {
				//if(pos == 0){
				if(price <= discard) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					sign1 = false;
					pos = -1;
				}else if(price <= downline2) {
						Double dBalance = Double.parseDouble(ua.getOrdersChance().get("bid_balance"));
						int balance = (int) (Math.round(dBalance * 0.98));
						ua.order("bid", null, Integer.toString(balance), "price");
						sign2 = true;
						pos = -1;
				}
				//}
				if(price >= upline) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					sign1 = false;
					pos = 2;
				}
				
			}else {
				if(price >= upline) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					sign1 = false;
					sign2 = false;
					pos = 2;
				}
				else if(price <= discard) {
					String balance = ua.getOrdersChance().get("ask_balance");
					ua.order("ask", balance, null, "market");
					sign1 = false;
					sign2 = false;
					pos = -1;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "coin/home";
	}

}
