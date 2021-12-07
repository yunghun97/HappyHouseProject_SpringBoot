package com.ssafy.happyhouse.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.happyhouse.model.service.BoardService;


@RestController
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private BoardService boardService;
	
	/** 게시글 작성 **/
	@PostMapping
	public ResponseEntity<String> writePost(@RequestBody BoardDto boardDto) throws Exception {
		if(boardService.writePost(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	/** 게시글 목록 조회  **/
	@GetMapping
	public ResponseEntity<List<BoardDto>> selectBoard(BoardParameterDto boardParameterDto) throws Exception {
		return new ResponseEntity<List<BoardDto>>(boardService.selectBoard(boardParameterDto),HttpStatus.OK);
	}
	
	/** 게시글 상세 정보 **/
	@GetMapping("/{boardno}")
	public ResponseEntity<BoardDto> getPost(@PathVariable("boardno") int boardno) throws Exception {
		boardService.updateViews(boardno);
		return new ResponseEntity<BoardDto>(boardService.getPost(boardno), HttpStatus.OK);
	}
	
	/** 게시글 수정 **/
	@PutMapping
	public ResponseEntity<String> modifyPost(@RequestBody BoardDto boardDto) throws Exception {
		if(boardService.modifyPost(boardDto) ) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	/** 게시글 삭제 **/
	@DeleteMapping("/{boardno}")
	public ResponseEntity<String> deleteBoard(@PathVariable("boardno") int boardno) throws Exception {
		if(boardService.deleteBoard(boardno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	/** 댓글 작성 **/
	@PostMapping("/comment")
	public ResponseEntity<String> addReply(@RequestBody CommentDto commentDto) throws Exception {
		if(boardService.addReply(commentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	/** 댓글 목록 조회  **/
	@GetMapping("/comment/{boardno}")
	public ResponseEntity<List<CommentDto>> selectComment(@PathVariable("boardno") int boardno) throws Exception {
		return new ResponseEntity<List<CommentDto>>(boardService.selectComment(boardno),HttpStatus.OK);
	}
	
	/** 댓글 삭제 **/
	@DeleteMapping("/comment/{commentno}")
	public ResponseEntity<String> deleteComment(@PathVariable("commentno") int commentno) throws Exception {
		if(boardService.deleteComment(commentno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
