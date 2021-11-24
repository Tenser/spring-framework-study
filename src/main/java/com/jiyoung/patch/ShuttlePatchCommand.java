package com.jiyoung.patch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ShuttlePatchCommand {
	
	public Object execute(HttpServletRequest request, Model model);

}
