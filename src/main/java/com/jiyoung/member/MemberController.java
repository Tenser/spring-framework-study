package com.jiyoung.member;

import java.io.UnsupportedEncodingException;
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

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private MemberCommand command = null;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		String id = (String) request.getSession().getAttribute("id");
		if(id != null) {
			return "redirect:/";
		}
		return "member/login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm(HttpServletRequest request, Model model) {
		String id = (String) request.getSession().getAttribute("id");
		if(id != null) {
			return "redirect:/";
		}
		String res = request.getParameter("res");
		if(res == null) model.addAttribute("res", "이거먼저->");
		else model.addAttribute("res", res);
		return "member/signup";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if(id == null || !id.equals("admin")) {
			return "redirect:login";
		}
		command = new MemberListCommand();
		command.execute(model);
		
		return "member/show";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
	
		command = new MemberInsertCommand();
		command.execute(model);
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/idCheckForm", method = RequestMethod.GET)
	public String idCheckForm() {
		
		return "member/idCheck";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		
		MemberCommand command = new MemberIdCheckCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		boolean result = (Boolean) map.get("result");
		if(result) {
			model.addAttribute("msg", "아이디가 이미 있습니다.");
			return "member/idCheck";
		}else {
			model.addAttribute("msg", "사용가능");
			model.addAttribute("res", request.getParameter("id"));
		}
		return "member/idCheck";
	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
	
		command = new MemberLoginCommand();
		command.execute(model);
		if(request.getSession().getAttribute("id") == null) {
			return "redirect:login";
		}
		return "redirect:/patch";
	}
	
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		session.setAttribute("id", null);
		return "redirect:login";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new MemberDeleteCommand();
		command.execute(model);
		
		return "redirect:show";
	}
	
	
}
