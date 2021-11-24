package com.jiyoung.patch;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ShuttlePatchInsertCommand implements ShuttlePatchCommand {
	
	@Override
	public Object execute(HttpServletRequest request, Model model) {
		ProfileDao dao = new ProfileDao();
		ProfileDto dto = new ProfileDto();
		dto.setName(request.getParameter("name"));
		dto.setSchool(request.getParameter("school"));
		dto.setPower(Integer.parseInt(request.getParameter("power")));
		dto.setPopularity(Integer.parseInt(request.getParameter("popularity")));
		dto.setImage_one(request.getParameter("image_one"));
		dto.setImage_two(request.getParameter("image_two"));
		dao.insert(dto);
		return null;
	}

}
