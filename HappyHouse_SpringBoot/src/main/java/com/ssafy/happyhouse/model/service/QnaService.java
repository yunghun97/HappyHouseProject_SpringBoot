package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.util.PageNavigation;

public interface QnaService {

	List<QnaDto> selectQna(BoardParameterDto boardParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception;
	QnaDto getQna(int no) throws Exception;
	boolean writeQna(QnaDto qnaDto) throws Exception;
	boolean deleteQna(int no) throws Exception;
	List<AnswerDto> selectAnswer(int qno) throws Exception;
	boolean addAnswer(AnswerDto answerDto) throws Exception;
	boolean deleteAnswer(int no)throws Exception;
}
