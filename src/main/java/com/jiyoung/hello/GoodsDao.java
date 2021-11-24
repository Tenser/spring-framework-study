package com.jiyoung.hello;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class GoodsDao {
	
	private JdbcTemplate template = null;
	
	public GoodsDao() {
		this.template = Constant.template;
	}
	
	public ArrayList<GoodsDto> selectAll(){
		return (ArrayList<GoodsDto>) template.query(" select * from goods ", new BeanPropertyRowMapper(GoodsDto.class));
	}
	
	public ArrayList<GoodsDto> search(String word){
		return (ArrayList<GoodsDto>) template.query(" select * from goods where name REGEXP ? ", new BeanPropertyRowMapper(GoodsDto.class), word);
	}
	
	public void insert(String name, int price, String discript, String kind) {
		template.update(" insert into goods(name, price, kind, discript) values(?, ?, ?, ?) ", name, price, discript, kind);
	}
	
	
}
