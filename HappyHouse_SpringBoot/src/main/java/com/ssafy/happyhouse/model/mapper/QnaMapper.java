package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.QnaDto;

public interface QnaMapper {

	List<QnaDto> selectQna(BoardParameterDto boardParameterDto) throws SQLException; // 조회
	QnaDto getQna(int no) throws SQLException;	// 정보 조회
	int writeQna(QnaDto qnaDto) throws SQLException;	// 등록
	int deleteQna(int no) throws SQLException;	// 삭제
	int getTotalCount(BoardParameterDto boardParameterDto) throws SQLException;
	List<AnswerDto> selectAnswer(int qno) throws SQLException;
	int addAnswer(AnswerDto answerDto) throws SQLException;
	int deleteAnswer(int no) throws SQLException;
	
}
