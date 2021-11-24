package com.jiyoung.patch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jiyoung.member.MemberDAO;

public class ShuttelPatchAddCommentCommand implements ShuttlePatchCommand {

	@Override
	public Object execute(HttpServletRequest request, Model model) {
		CommentDao cDao = new CommentDao();
		String id = (String) request.getSession().getAttribute("id");
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String group_name = request.getParameter("group_name");
		cDao.insert(id, name, contents, group_name);
		return null;
	}

}
