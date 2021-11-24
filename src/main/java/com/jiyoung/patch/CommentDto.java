package com.jiyoung.patch;

import java.sql.Timestamp;

public class CommentDto {
	
	private int num;
	private String id;
	private String name;
	private String contents;
	private Timestamp post_date;
	private String group_name;
	
	public CommentDto() {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getPost_date() {
		return post_date;
	}

	public void setPost_date(Timestamp post_date) {
		this.post_date = post_date;
	}
	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
	

}
