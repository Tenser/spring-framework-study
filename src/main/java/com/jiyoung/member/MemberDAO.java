package com.jiyoung.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.jiyoung.hello.Constant;


public class MemberDAO {
	
	private JdbcTemplate template = null;
	/*
	private String dbURL="jdbc:mysql://localhost:3306/jiyoung?serverTimezone=UTC";                             
    private String dbID="root";
    private String dbPassword="jiyoung";
    */
    public MemberDAO() {
    	/*
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	*/
    	
    	this.template = Constant.template;
    }
    
	public ArrayList<MemberDTO> userSelect(){
    	
    	String query = " SELECT * FROM USER ";
    	ArrayList<MemberDTO> dtos = (ArrayList<MemberDTO>)template.query(query, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
    	return dtos;
    	
    	/*
    	ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
    	
    	Connection conn = null;   
    	PreparedStatement pstmt = null; 
    	ResultSet rs = null; 
    	
    	try {
    		conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
	        pstmt = conn.prepareStatement(" SELECT * FROM USER ");
	        rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	String id = rs.getString(1);
	        	String password = rs.getString(2);
	        	String name = rs.getString(3);
	        	String phone = rs.getString(4);
	        	MemberDTO dto = new MemberDTO(id, password, name, phone);
	        	dtos.add(dto);
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(conn != null) conn.close();
        		if(pstmt != null) pstmt.close();
        		if(rs != null) rs.close();
    		}catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    	return dtos;
    	*/
    }
	
	public String getIdByName(String id) {
		return template.queryForObject("select name from user where id=? ", String.class, id);
	}
    
    public boolean idCheck(String id) {
    	
    	 if(template.queryForObject(" SELECT count(id) as cnt FROM USER WHERE id=?", Integer.class, id) == 1) 
    		 return true;
    	 return false;
    	/*
    	Connection conn = null;   
    	PreparedStatement pstmt = null; 
    	ResultSet rs = null; 
    	
    	try {
    		conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
	        pstmt = conn.prepareStatement(" SELECT id FROM USER WHERE id=?");
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	return true;
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(conn != null) conn.close();
        		if(pstmt != null) pstmt.close();
        		if(rs != null) rs.close();
    		}catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    	return false;
    	*/
    }
    
    public boolean pwCheck(String id, String password) {
    	
    	if(template.queryForObject(" SELECT count(id) as cnt FROM USER WHERE id=? AND password=? ", Integer.class, id, password) == 1) 
    		return true;
   	 	return false;
   	 	
   	 	/*
    	Connection conn = null;   
    	PreparedStatement pstmt = null; 
    	ResultSet rs = null; 
    	
    	try {
    		conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
	        pstmt = conn.prepareStatement(" SELECT id FROM USER WHERE id=? AND password=? ");
	        pstmt.setString(1, id);
	        pstmt.setString(2, password);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	return true;
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(conn != null) conn.close();
        		if(pstmt != null) pstmt.close();
        		if(rs != null) rs.close();
    		}catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    	return false;
    	*/
    }
    
    public void insert(MemberDTO dto) {
    	
    	template.update(" INSERT INTO USER(id, password, name, phone) VALUES(?, ?, ?, ?) ", dto.getId(), dto.getPassword(), dto.getName(), dto.getPhone());
    	/*
    	Connection conn = null;   
    	PreparedStatement pstmt = null;  
    	
    	try {
    		conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
	        pstmt = conn.prepareStatement(" INSERT INTO USER(id, password, name, phone) VALUES(?, ?, ?, ?) ");
	        pstmt.setString(1, dto.getId());
	        pstmt.setString(2, dto.getPassword());
	        pstmt.setString(3, dto.getName());
	        pstmt.setString(4, dto.getPhone());
	        pstmt.executeUpdate(); 
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(conn != null) conn.close();
        		if(pstmt != null) pstmt.close();
    		}catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    	*/
    }
    
    public void delete(String id) {
    	
    	template.update(" DELETE FROM USER WHERE id=? ", id);
    	/*
    	Connection conn = null;   
    	PreparedStatement pstmt = null;  
    	
    	try {
    		conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
	        pstmt = conn.prepareStatement(" DELETE FROM USER WHERE id=? ");
	        pstmt.setString(1, id);
	        pstmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(conn != null) conn.close();
        		if(pstmt != null) pstmt.close();
    		}catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    	*/
    }
}
