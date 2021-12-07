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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.happyhouse.model.service.QnaService;

@RestController
@RequestMapping("/qna")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnaService qnaService;
	
	/** QnA 목록 조회 **/
	@GetMapping
	public ResponseEntity<List<QnaDto>> selectQna(BoardParameterDto boardParameterDto) throws Exception{
		return new ResponseEntity<List<QnaDto>>(qnaService.selectQna(boardParameterDto), HttpStatus.OK);
	}
	
	/** QnA 등록 **/
	@PostMapping
	public ResponseEntity<String> writeQna(@RequestBody QnaDto qnaDto) throws Exception {
		if(qnaService.writeQna(qnaDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	/** QnA 상세 정보 조회 **/
	@GetMapping("/{no}")
	public ResponseEntity<QnaDto> getQna(@PathVariable("no") int no) throws Exception {
		return new ResponseEntity<QnaDto>(qnaService.getQna(no), HttpStatus.OK);
	}
	
	/** QnA 삭제 **/
	@DeleteMapping("/{no}")
	public ResponseEntity<String> deleteQna(@PathVariable("no") int no) throws Exception {
		if(qnaService.deleteQna(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	/** QnA 답변 조회 **/
	@GetMapping("/answer/{qno}")
	public ResponseEntity<List<AnswerDto>> selectAnswer(@PathVariable("qno") int qno) throws Exception{
		return new ResponseEntity<List<AnswerDto>>(qnaService.selectAnswer(qno), HttpStatus.OK);
	}
	
	/** QnA 답변 작성 **/
	@PostMapping("/answer")
	public ResponseEntity<String> addAnswer(@RequestBody AnswerDto answerDto) throws Exception {
		if(qnaService.addAnswer(answerDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	/** QnA 답변 삭제**/
	@DeleteMapping("/answer/{no}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("no") int no) throws Exception {
		if(qnaService.deleteAnswer(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
