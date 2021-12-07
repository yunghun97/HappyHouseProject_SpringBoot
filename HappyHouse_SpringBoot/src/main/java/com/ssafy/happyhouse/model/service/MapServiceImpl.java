package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.BaseaddressDto;
import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.HouseInfoAllDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.mapper.MapMapper;
@Service
public class MapServiceImpl implements MapService{

	@Autowired
	private MapMapper mapMapper;

	@Override
	public List<HouseInfoAllDto> getSido() throws Exception {
		return mapMapper.getSido();
	}

	@Override
	public List<HouseInfoAllDto> getGugun(String sido) throws Exception {
		return mapMapper.getGugun(sido);
	}

	@Override
	public List<HouseInfoAllDto> getdong(String gugun) throws Exception {
		// TODO Auto-generated method stub
		return mapMapper.getdong(gugun);
	}

	@Override
	public List<HouseInfoAllDto> getApt(String dong) throws Exception {
		// TODO Auto-generated method stub
		return mapMapper.getApt(dong);
	}

	@Override
	public List<HouseInfoAllDto> getBookmark() throws Exception {		
		return mapMapper.getBookmark();
	}

	@Override
	public void regitBookMark(BookmarkDto bookmarkDto) throws Exception {
		mapMapper.regitBookmark(bookmarkDto);
		return;	
	}
}
