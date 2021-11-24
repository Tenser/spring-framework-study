package com.jiyoung.patch;

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

@Controller
@RequestMapping("/patch")
public class ShuttlePatchController {
	
	ShuttlePatchCommand command = null;
	int hit = 0;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		command = new ShuttlePatchHomeCommand();
		command.execute(request, model);
		System.out.println(++hit);
		return "patch/home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2() {
		return "redirect:/patch";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertForm() {
		return "patch/insert";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		command = new ShuttlePatchInsertCommand();
		command.execute(request, model);
		return "redirect:insert";
	}
	
	@RequestMapping(value = "/vote", method = RequestMethod.GET)
	public String voteForm(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		//request.setCharacterEncoding("utf-8");
		command = new ShuttlePatchSelectAllCommand();
		command.execute(request, model);
		return "patch/vote";
	}
	
	@RequestMapping(value = "/vote.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		command = new ShuttlePatchUpdateCommand();
		command.execute(request, model);
		return "redirect:thanks";
	}
	
	@RequestMapping(value = "/thanks", method = RequestMethod.GET)
	public String voteFinish() {
		return "patch/voteFinish";
	}
	
	@RequestMapping(value = "/powerRanking", method = RequestMethod.GET)
	public String powerRanking(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		command = new ShuttlePatchPowerRankingCommand();
		command.execute(request, model);
		return "patch/powerRanking";
	}
	
	@RequestMapping(value = "/popularity", method = RequestMethod.GET)
	public String popularityRanking(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		command = new ShuttlePatchPopularityRankingCommand();
		command.execute(request, model);
		return "patch/popularityRanking";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		command = new ShuttlePatchShowInfoCommand();
		command.execute(request, model);
		return "patch/info";
	}
	
	@RequestMapping(value = "/addComment.do", method = RequestMethod.POST)
	public String addComment(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		command = new ShuttelPatchAddCommentCommand();
		command.execute(request, model);
		String name = request.getParameter("group_name");
		name = URLEncoder.encode(name, "UTF-8");
		return "redirect:info?name="+name;
	}
	
	@RequestMapping(value = "/deleteComment.do", method = RequestMethod.GET)
	public String deleteComment(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		command = new ShuttlePatchDeleteCommentCommand();
		command.execute(request, model);
		String name = request.getParameter("group_name");
		name = URLEncoder.encode(name, "UTF-8");
		return "redirect:info?name="+name;
	}
	
	
	
	
}
