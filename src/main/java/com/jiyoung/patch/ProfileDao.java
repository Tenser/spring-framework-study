package com.jiyoung.patch;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jiyoung.hello.Constant;

public class ProfileDao {
	
	private JdbcTemplate template = null;
	
	public ProfileDao() {
		this.template = Constant.template;
	}
	
	public int insert(ProfileDto dto) {
		return template.update(" insert into profile(name, school, power, popularity, image_one, image_two) values(?, ?, ?, ?, ?, ?) ",
				dto.getName(), dto.getSchool(), dto.getPower(), dto.getPopularity(), dto.getImage_one(), dto.getImage_two());
	}
	
	public int updatePower(String name, int point) {
		return template.update(" update profile set power=power+? where name=? ", point, name);
	}
	
	public int updatePopularity(String name) {
		return template.update(" update profile set popularity=popularity+1 where name=? ", name);
	}
	
	public ArrayList<ProfileDto> selectAll(){
		return (ArrayList<ProfileDto>) template.query(" select name, school from profile ", new BeanPropertyRowMapper(ProfileDto.class));
	}
	
	public ArrayList<ProfileDto> selectByPower(){
		return (ArrayList<ProfileDto>) template.query(" select name, school, power, image_one from profile where power > 0 order by power desc ", 
				new BeanPropertyRowMapper(ProfileDto.class));
	}
	
	public ArrayList<ProfileDto> selectByPower2(){
		return (ArrayList<ProfileDto>) template.query(" select name, image_one from profile where power > 0 order by power desc limit 3", 
				new BeanPropertyRowMapper(ProfileDto.class));
	}
	
	public ArrayList<ProfileDto> selectByPopularity(){
		return (ArrayList<ProfileDto>) template.query(" select name, school, popularity, image_two from profile where popularity > 0 order by popularity desc ", 
				new BeanPropertyRowMapper(ProfileDto.class));
	}
	
	public ArrayList<ProfileDto> selectByPopularity2(){
		return (ArrayList<ProfileDto>) template.query(" select name, image_two from profile where popularity > 0 order by popularity desc limit 3", 
				new BeanPropertyRowMapper(ProfileDto.class));
	}
	
	public ProfileDto selectOne(String name) {
		return (ProfileDto) template.queryForObject(" select * from profile where name=? ", new BeanPropertyRowMapper(ProfileDto.class), name);
	}
	
	public int getPowerRank(String name) {
		return template.queryForObject(" select count(name)+1 from profile where power>(select power from profile where name=?) ", Integer.class, name);
	}
	
	public int getPopularityRank(String name) {
		return template.queryForObject(" select count(name)+1 from profile where popularity>(select popularity from profile where name=?) ", Integer.class, name);
	}

}
