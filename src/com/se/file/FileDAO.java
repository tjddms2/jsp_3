package com.se.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.se.util.DBConnector;

public class FileDAO {

	public selectList(FilDTO fDTO) throws Exception{
		List<FilDTO> ar = new ArrayList<>();
		Connection con= DBConnector.getConnect();
		String sql= "select * from upload where num=? and kind=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, fDTO.getNum());
		st.setString(2, fDTO.getKind());
		
		ResultSet rs= st.executeQuery();
		while(rs.next()) {
			fDTO = new FilDTO();
			fDTO.setfNum(rs.getInt("fNum"));
			
		}
		
	}
}
