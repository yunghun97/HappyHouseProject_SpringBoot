package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.NoticeDto;

public interface NoticeService {

	List<NoticeDto> selectNotice(NoticeDto noticeDto) throws Exception;
	NoticeDto getNotice(int no) throws Exception;
	boolean registNotice(NoticeDto noticeDto) throws Exception;
	boolean deleteNotice(int no) throws Exception;
}
