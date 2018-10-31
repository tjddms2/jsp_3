package com.se.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.se.util.DBConnector;

public class FileDAO {

	public List<FilDTO> selectList(FilDTO filDTO) throws Exception{
		List<FilDTO> ar = new ArrayList<>();
		Connection con= DBConnector.getConnect();
		String sql= "select * from upload where num=? and kind=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, filDTO.getNum());
		st.setString(2, filDTO.getKind());
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
			filDTO = new FilDTO();
			filDTO.setfNum(rs.getInt("fNum"));
			filDTO.setfName(rs.getString("fName"));
			filDTO.setoName(rs.getString("oName"));
			filDTO.setNum(rs.getInt("num"));
			filDTO.setKind(rs.getString("kind"));
			ar.add(filDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	public int insert(FilDTO filDTO)throws Exception{
		Connection con =DBConnector.getConnect();
		
		String sql= "insert into upload values(file_seq.nextval,?,?,?,?)";
		PreparedStatement st =con.prepareStatement(sql);
		
		st.setString(1, filDTO.getfName());
		st.setString(2, filDTO.getoName());
		st.setInt(3, filDTO.getNum());
		st.setString(4, filDTO.getKind());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	public int deleteAll(int num) throws Exception{
		Connection con =DBConnector.getConnect();
		String sql="delete upload where num=?"; //해당글번호 삭제
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		return result;
	}
}
