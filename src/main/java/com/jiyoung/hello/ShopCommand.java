package com.jiyoung.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ShopCommand {
	
	public String execute(HttpServletRequest request, Model model);
	
}