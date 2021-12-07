package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeDto> selectNotice(NoticeDto noticeDto) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).selectNotice(noticeDto);
	}

	@Override
	public NoticeDto getNotice(int no) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).getNotice(no);
	}

	@Override
	public boolean registNotice(NoticeDto noticeDto) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).registNotice(noticeDto) == 1;
	}

	@Override
	public boolean deleteNotice(int no) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).deleteNotice(no) == 1;
	}

}
