package com.jiyoung.patch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ShuttlePatchDeleteCommentCommand implements ShuttlePatchCommand {

	@Override
	public Object execute(HttpServletRequest request, Model model) {
		CommentDao dao = new CommentDao();
		int num = Integer.parseInt(request.getParameter("num"));
		dao.delete(num);
		return null;
	}

}
