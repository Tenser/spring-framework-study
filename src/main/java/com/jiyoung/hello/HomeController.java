package com.jiyoung.hello;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiyoung.patch.ShuttlePatchHomeCommand;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	public ShopCommand command = null;
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		command = new ShopHomeCommand();
		return command.execute(request, model);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addGoodsView() {
		return "add";
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String addGoods(HttpServletRequest request, Model model) {
		command = new ShopAddCommand();
		return command.execute(request, model);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String resultView(HttpServletRequest request, Model model) {
		command = new ShopSearchCommand();
		return command.execute(request, model);
	}
	
}
