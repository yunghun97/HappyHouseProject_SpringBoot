package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.NoticeDto;

public interface NoticeMapper {

	List<NoticeDto> selectNotice(NoticeDto noticeDto) throws SQLException;
	NoticeDto getNotice(int no) throws SQLException;
	int registNotice(NoticeDto noticeDto) throws SQLException;
	int deleteNotice(int no) throws SQLException;
}
