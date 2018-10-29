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
		Connection con=DBConnector.getConnect();
		String sql="select * from notice where num=?";
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1,num);
		NoticeDTO dto=null;
		ResultSet rs= st.executeQuery();
		
		if(rs.next()) {
		dto= new NoticeDTO();
		dto.setNum(rs.getInt("num"));
		dto.setTitle(rs.getString("title"));
		dto.setContents(rs.getString("contents"));
		dto.setWriter(rs.getString("writer"));
		dto.setReg_date(rs.getDate("regdate"));
		dto.setHit(rs.getInt("hit"));
		
	}
		DBConnector.disConnect(rs, st, con);
		return dto;
		
	}
	
	//sequence 가져오기
	public int getNum() throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select notice_seq.nextval from dual";
		PreparedStatement st= con.prepareStatement(sql);
		ResultSet rs= st.executeQuery();
		rs.next();
		int num = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return num;
   }

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		Connection con =DBConnector.getConnect();
		String sql="insert into notice values(notice_seq.nextval,?,?,?,sysdate,0)";
		PreparedStatement st= con.prepareStatement(sql);
				
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setString(3, boardDTO.getWriter());
		int result=st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
		
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
