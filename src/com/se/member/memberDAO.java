package com.se.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.se.util.DBConnector;



public class memberDAO {
	
	
	
	//insert
	public int insert(memberDTO dto) throws Exception{
		Connection con= DBConnector.getConnect();	
		String sql="insert into member values(?,?,?,?,?,?)";
		
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1,	dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setString(4, dto.getEmail());
		st.setString(5, dto.getKind());
		st.setString(6, dto.getClassMate());
		
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
		
		
	}
	
	//selectOne
	public memberDTO selectOne(memberDTO dto) throws Exception{
		Connection con= DBConnector.getConnect();
		String sql="select * from member where id=? and pw=?";
		
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		
		ResultSet rs=st.executeQuery();
		memberDTO mdto= null;
		if(rs.next()) { 					/*������ �д´ٸ�*/
			mdto = new memberDTO();
			mdto.setId(rs.getString("id"));
			mdto.setName(rs.getString("name"));
			mdto.setEmail(rs.getString("email"));
			mdto.setKind(rs.getString("kind"));
			mdto.setClassMate(rs.getString("classMate"));
		}
		DBConnector.disConnect(rs, st, con);
		return mdto;
		
	}	
	
	
	//selectList
	
	public List<memberDTO> selectList(int startRow, int lastRow, String kind, String search) throws Exception{
		Connection con= DBConnector.getConnect();
		String sql="select * from "
				+"(select rownum R, M.* from "
				+"(select * from member where "+kind+" like ? order by classMate desc) M) "
				+"where R between ? and ?";
				PreparedStatement st= con.prepareStatement(sql);
				st.setString(1,"%"+search+"%");
				st.setInt(2, startRow);
				st.setInt(3, lastRow);
				ResultSet rs= st.executeQuery();
				List<memberDTO> ar = new ArrayList<>();
				
				memberDTO dto= null;
				while(rs.next()) {
					dto= new memberDTO();
					dto.setId(rs.getString("id"));
					dto.setId(rs.getString("name"));
					dto.setKind(rs.getString("kind"));
					ar.add(dto);
					
				}
				DBConnector.disConnect(rs, st, con);
				return ar;
	}
	
	//getCount
	
	public int getCount(String kind, String search) throws Exception {
		Connection con=DBConnector.getConnect();
		String sql="select count(id) from member"
				+ " where "+kind+" like ?";
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		
		ResultSet rs= st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		return result;
	}
//update
	public int update(memberDTO dto)throws Exception{
		Connection con= DBConnector.getConnect();
		String sql="update member set pw=?, name=?, email=? where id=?";
		
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, dto.getPw());
		st.setString(2, dto.getName());
		st.setString(3, dto.getEmail());
		st.setString(4, dto.getId());
		int result= st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
		
		
	}
	//delete
	public int delete(String id) throws Exception{
		Connection con= DBConnector.getConnect();
		String sql="delete member where id=?";
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setString(1, id);
		
		int result= st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
		
	}
	
}
