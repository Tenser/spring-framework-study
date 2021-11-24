package com.jiyoung.stock;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiyoung.patch.ShuttlePatchHomeCommand;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	StockCommand service = null;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		service = new StockHomeCommand();
		return service.execute(request, model);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		service = new StockSearchCommand();
		return service.execute(request, model);
	}
	
	@RequestMapping(value = "/divide", method = RequestMethod.GET)
	public String divide(HttpServletRequest request, Model model) {
		//request.setCharacterEncoding("UTF-8");
		service = new StockRedAndBlueCommand();
		return service.execute(request, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/android/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> searchFromAndroid(HttpServletRequest request) {
		//request.setCharacterEncoding("UTF-8");
		service = new StockSearchCommand();
		return (Map<String, String>) service.executeForAndroid(request);
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		service = new StockDeleteCommand();
		return service.execute(request, model);
	}
	
	@RequestMapping(value = "/recommend", method = RequestMethod.GET)
	public String getRecommend(HttpServletRequest request, Model model) {
		service = new StockRecommendedCommand();
		return service.execute(request, model);
	}
	
	@RequestMapping(value = "/android/test", method = RequestMethod.GET)
	public int test(HttpServletRequest request) {
		return 6;
	}
	
	
}
