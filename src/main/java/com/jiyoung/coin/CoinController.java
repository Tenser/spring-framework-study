package com.jiyoung.coin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiyoung.patch.ShuttlePatchHomeCommand;

@Controller
@RequestMapping("/coin")
public class CoinController {
	
	CoinCommand service;
		
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		Switch.turn = false;
		return "coin/home";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String start(HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException {
		Switch.turn = true;
		service = new CoinBoxDealCommand();
		//System.out.println(123);
		return service.execute(request, model);
	}
	
	@RequestMapping(value = "/start2", method = RequestMethod.GET)
	public String start2(HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException {
		Switch.turn = true;
		service = new CoinShootingCommand();
		//System.out.println(123);
		return service.execute(request, model);
	}
	
	@RequestMapping(value = "/start3", method = RequestMethod.GET)
	public String start3(HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException {
		Switch.turn = true;
		service = new CoinOrderbookDealCommand();
		return service.execute(request, model);
	}
	
	@RequestMapping(value = "/start4", method = RequestMethod.GET)
	public String start4(HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException {
		Switch.turn = true;
		service = new CoinNoTailDealCommand();
		return service.execute(request, model);
	}
	
}