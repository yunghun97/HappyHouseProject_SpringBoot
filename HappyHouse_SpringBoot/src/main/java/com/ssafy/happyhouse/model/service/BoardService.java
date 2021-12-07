package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.util.PageNavigation;


public interface BoardService {

	 boolean writePost(BoardDto boardDto) throws Exception;
	 List<BoardDto> selectBoard(BoardParameterDto boardParameterDto) throws Exception;
	 PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception;
	
	 BoardDto getPost(int boardno) throws Exception;
	 void updateViews(int boardno) throws Exception;
	 boolean modifyPost(BoardDto boardDto) throws Exception;
	 boolean deleteBoard(int boardno) throws Exception;
	
	 List<CommentDto> selectComment(int boardno) throws Exception;
	 boolean addReply(CommentDto commentDto) throws Exception;
	 boolean deleteComment(int commentno) throws Exception;
	
}
