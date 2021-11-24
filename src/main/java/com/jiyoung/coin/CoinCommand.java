package com.jiyoung.coin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.ParseException;
import org.springframework.ui.Model;

public interface CoinCommand {
	
	public String execute(HttpServletRequest request, Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException;
}
