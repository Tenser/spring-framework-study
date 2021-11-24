package com.jiyoung.patch;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jiyoung.member.MemberDAO;

public class ShuttlePatchShowInfoCommand implements ShuttlePatchCommand {

	@Override
	public Object execute(HttpServletRequest request, Model model) {
		String id = (String) request.getSession().getAttribute("id");
		ProfileDao pDao = new ProfileDao();
		CommentDao cDao = new CommentDao();
		MemberDAO mDao = new MemberDAO();
		String name = request.getParameter("name");
		ProfileDto pDto = pDao.selectOne(name);
		int powerRank = pDao.getPowerRank(name);
		int popularityRank = pDao.getPopularityRank(name);
		ArrayList<CommentDto> cDtos = cDao.selectByGroup(name);
		String mName = null;
		if(id != null) mName = mDao.getIdByName(id);
		model.addAttribute("info", pDto);
		model.addAttribute("powerRank", powerRank);
		model.addAttribute("popularityRank", popularityRank);
		model.addAttribute("comments", cDtos);
		model.addAttribute("name", mName);
		return null;
	}

}
