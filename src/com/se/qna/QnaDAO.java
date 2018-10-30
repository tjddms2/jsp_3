package com.se.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.se.board.BoardDAO;
import com.se.board.BoardDTO;
import com.se.board.BoardReply;
import com.se.board.BoardReplyDTO;
import com.se.notice.NoticeDTO;
import com.se.page.RowNumber;
import com.se.page.Search;
import com.se.util.DBConnector;

public class QnaDAO implements BoardDAO, BoardReply {
	
	
	@Override
	public int reply(BoardReplyDTO boardReplyDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
		
	@Override
	public int replyupdate(BoardReplyDTO boardReplyDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception {
		Connection con= DBConnector.getConnect();
		String sql="select * from "
				+ "(select rownum R, N.* from "
				+ "(select num, title, writer, reg_date, hit from qna "
				+ "where "+rowNumber.getSearch().getKind()+" like ? "
				+ "order by num desc) N) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+rowNumber.getSearch().getSearch()+"%");
		st.setInt(2, rowNumber.getStartRow());
		st.setInt(3, rowNumber.getLastRow());
		
		ResultSet rs= st.executeQuery();
		List<BoardDTO> ar= new ArrayList<>();
		
		QnaDTO qnaDTO =null;
		while(rs.next()) {
			qnaDTO= new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setDepth(rs.getInt("depth"));
			ar.add(qnaDTO);
			
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
		
		
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		Connection con=DBConnector.getConnect();
		String sql="select * from qna where num=?";
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1,num);
		BoardDTO boardDTO=null;
		ResultSet rs= st.executeQuery();
		
		if(rs.next()) {
			boardDTO= new NoticeDTO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setReg_date(rs.getDate("regdate"));
			boardDTO.setHit(rs.getInt("hit"));
		
	}
		DBConnector.disConnect(rs, st, con);
		return boardDTO;
		
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
	//@Override 
	public int getCount(Search search) throws Exception {
		Connection con= DBConnector.getConnect();
		String sql="select count(num) from board"+" where "+search.getKind()+" like ?";
		
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, "%"+search.getSearch()+"%");
		
		ResultSet rs=st.executeQuery();
		rs.next();
		
		int result= rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
		
	}

}
