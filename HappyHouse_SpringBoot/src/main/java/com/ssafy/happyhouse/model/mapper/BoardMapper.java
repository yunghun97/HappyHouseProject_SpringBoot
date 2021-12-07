package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.CommentDto;

public interface BoardMapper {

	List<BoardDto> selectBoard(BoardParameterDto boardParameterDto) throws SQLException; // 조회
	BoardDto getPost(int boardno) throws SQLException; // 상세조회
	int writePost(BoardDto boardDto) throws SQLException; // 글쓰기
	int deleteBoard(int boardno) throws SQLException; // 게시글삭제
	List<CommentDto> selectComment(int boardno) throws SQLException;
	int addReply(CommentDto commentDto) throws SQLException; // 댓글추가
	int deleteComment(int commentno) throws SQLException; // 댓글삭제
	int modifyPost(BoardDto boardDto) throws SQLException; // 수정
	void updateViews(int boardno) throws SQLException; // 조회수
	int getTotalCount(BoardParameterDto boardParameterDto) throws SQLException;
	
	
}
