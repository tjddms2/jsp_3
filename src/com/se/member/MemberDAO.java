package com.se.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.se.util.DBConnector;



public class MemberDAO {
	// 삭제, 가입 , 탈퇴 , 수정 ,로그인, 포토
	
	
	//가입-Join
	public int join(MemberDTO memberDTO) throws Exception{
		Connection con= DBConnector.getConnect();	
		String sql="insert into member values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1,	memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getKind());
		st.setString(6, memberDTO.getClassMate());
		st.setString(7, memberDTO.getFname());
		st.setString(8, memberDTO.getOname());
		
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;	
	}
	//탈퇴
	
	//수정
	
	//로그인
	
}
