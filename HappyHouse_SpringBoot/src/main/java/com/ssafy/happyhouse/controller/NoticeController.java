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

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping
	public ResponseEntity<List<NoticeDto>> selectNotice(NoticeDto noticeDto) throws Exception {
		return new ResponseEntity<List<NoticeDto>>(noticeService.selectNotice(noticeDto), HttpStatus.OK);
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<NoticeDto> getNotice(@PathVariable("no") int no) throws Exception{
		return new ResponseEntity<NoticeDto>(noticeService.getNotice(no), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> registNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		if(noticeService.registNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{/no}")
	public ResponseEntity<String> deleteNotice(@PathVariable("no") int no) throws Exception {
		if(noticeService.deleteNotice(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
}
