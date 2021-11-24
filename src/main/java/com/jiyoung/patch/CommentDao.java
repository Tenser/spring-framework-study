package com.jiyoung.patch;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jiyoung.hello.Constant;

public class CommentDao {
	
	private JdbcTemplate template = null;
	
	public CommentDao() {
		this.template = Constant.template;
	}
	
	public int insert(String id, String name, String contents, String group_name) {
		return template.update(" insert into comment(id, name, contents, post_date, group_name) values(?, ?, ?, ?, ?) ", id, name, contents, Timestamp.valueOf(LocalDateTime.now()), group_name);
	}
	
	public ArrayList<CommentDto> selectByGroup(String group_name){
		return (ArrayList<CommentDto>) template.query(" select  id, name, contents, post_date, num from comment where group_name=? ", new BeanPropertyRowMapper<CommentDto>(CommentDto.class), group_name);
	}
	
	public int delete(int num) {
		return template.update(" delete from comment where num=? ", num);
	}

}
