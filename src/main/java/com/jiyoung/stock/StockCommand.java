package com.jiyoung.stock;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface StockCommand {
	public String execute(HttpServletRequest request, Model model);
	public Object executeForAndroid(HttpServletRequest request);
}
