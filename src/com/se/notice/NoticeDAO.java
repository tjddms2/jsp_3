package com.se.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.se.board.BoardDAO;
import com.se.board.BoardDTO;

import com.se.page.RowNumber;
import com.se.util.DBConnector;

public class NoticeDAO implements BoardDAO {

	
	@Override
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception {
		//select list
				
					Connection con= DBConnector.getConnect();
					String sql="select * from "
							+ "(select rownum R, N.* from "
							+ "(select num, title, writer, reg_date, hit from notice "
							+ "where "+rowNumber.getSearch().getKind()+" like ? "
							+ "order by num desc) N) "
							+ "where R between ? and ?";
					PreparedStatement st = con.prepareStatement(sql);
					
					st.setString(1, "%"+rowNumber.getSearch().getSearch()+"%");
					st.setInt(2, rowNumber.getStartRow());
					st.setInt(3, rowNumber.getLastRow());
					
					ResultSet rs= st.executeQuery();
					List<BoardDTO> ar= new ArrayList<>();
					NoticeDTO dto =null;
					
					while(rs.next()) {
						dto= new NoticeDTO();
						dto.setNum(rs.getInt("num"));
						dto.setTitle(rs.getString("title"));
						dto.setWriter(rs.getString("writer"));
						dto.setReg_date(rs.getDate("reg_date"));
						dto.setHit(rs.getInt("hit"));
						ar.add(dto);
						
					}
					DBConnector.disConnect(rs, st, con);
					return ar;
				
		
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(String kind, String search) throws Exception {
		Connection con= DBConnector.getConnect();
		String sql="select count(num) from notice"+" where "+kind+" like ?";
		
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs=st.executeQuery();
		rs.next();
		
		int result= rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}

	
	
	
	
	
	
}
