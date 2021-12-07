package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.happyhouse.model.mapper.QnaMapper;
import com.ssafy.util.PageNavigation;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<QnaDto> selectQna(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return sqlSession.getMapper(QnaMapper.class).selectQna(boardParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(QnaMapper.class).getTotalCount(boardParameterDto);
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
	public QnaDto getQna(int no) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).getQna(no);
	}

	@Override
	public boolean writeQna(QnaDto qnaDto) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).writeQna(qnaDto) == 1;
	}

	@Override
	public boolean deleteQna(int no) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).deleteQna(no) == 1;
	}

	@Override
	public boolean addAnswer(AnswerDto answerDto) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).addAnswer(answerDto) == 1;
	}

	@Override
	public boolean deleteAnswer(int no) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).deleteAnswer(no) == 1;
	}

	@Override
	public List<AnswerDto> selectAnswer(int qno) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).selectAnswer(qno);
	}

}
