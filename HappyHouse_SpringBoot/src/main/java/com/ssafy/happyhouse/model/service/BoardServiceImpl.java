package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;
import com.ssafy.happyhouse.model.mapper.MapMapper;
import com.ssafy.util.PageNavigation;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean writePost(BoardDto boardDto) throws Exception {
		if(boardDto.getTitle() == null || boardDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(BoardMapper.class).writePost(boardDto) == 1;
	}

	@Override
	public List<BoardDto> selectBoard(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return sqlSession.getMapper(BoardMapper.class).selectBoard(boardParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(BoardMapper.class).getTotalCount(boardParameterDto);
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / boardParameterDto.getSpp() + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = boardParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < boardParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public BoardDto getPost(int boardno) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).getPost(boardno);
	}

	@Override
	public void updateViews(int boardno) throws Exception {
		sqlSession.getMapper(BoardMapper.class).updateViews(boardno);
	}

	@Override
	public boolean modifyPost(BoardDto boardDto) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).modifyPost(boardDto) == 1;
	}

	@Override
	public boolean deleteBoard(int boardno) throws Exception {
		sqlSession.getMapper(BoardMapper.class).deleteComment(boardno);
		return sqlSession.getMapper(BoardMapper.class).deleteBoard(boardno) == 1;
	}

	@Override
	public List<CommentDto> selectComment(int boardno) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).selectComment(boardno);
	}

	@Override
	public boolean addReply(CommentDto commentDto) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).addReply(commentDto) == 1;
	}

	@Override
	public boolean deleteComment(int commentno) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).deleteComment(commentno) == 1;
	}

	


}
