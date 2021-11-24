package com.jiyoung.stock;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jiyoung.hello.Constant;

public class StockDao {
	
	private JdbcTemplate template = null;
	
	public StockDao() {
		this.template = Constant.template;
	}
	
	public ArrayList<StockDto> selectAll() {
		return (ArrayList<StockDto>) template.query(" select code, name, today_price, next_price from stock order by next_price/today_price desc ", new BeanPropertyRowMapper(StockDto.class));
	}
	
	public ArrayList<StockDto> search(String word) {
		return (ArrayList<StockDto>) template.query(" select code, name, today_price, next_price, accuracy from stock where name=? or code=?", new BeanPropertyRowMapper(StockDto.class), word, word);
	}
	
	public ArrayList<StockDto> selectRed() {
		return (ArrayList<StockDto>) template.query(" select code, name, today_price, next_price from stock where next_price > today_price ", new BeanPropertyRowMapper(StockDto.class));
	}
	
	public ArrayList<StockDto> selectBlue() {
		return (ArrayList<StockDto>) template.query(" select code, name, today_price, next_price from stock where next_price < today_price ", new BeanPropertyRowMapper(StockDto.class));
	}
	
	public void delete(String code) {
		template.update(" delete from stock where code=? ", code);
	}
	
	public ArrayList<TimeUpdateDto> selectUpdateTime() {
		return (ArrayList<TimeUpdateDto>) template.query(" select * from timeupdate ", new BeanPropertyRowMapper(TimeUpdateDto.class));
	}
	
	public ArrayList<StockDto> selectRecommended() {
		return (ArrayList<StockDto>) template.query(" select name, accuracy from stock where (accuracy=2 and next_price/today_price > 1.018) or (accuracy=1 and next_price/today_price > 1.032) ", new BeanPropertyRowMapper(StockDto.class));
	}
}
