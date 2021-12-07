package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.BaseaddressDto;
import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.HouseInfoAllDto;
import com.ssafy.happyhouse.model.HouseInfoDto;

public interface MapMapper {
	List<HouseInfoAllDto> getSido();
	List<HouseInfoAllDto> getGugun(String sido);
	List<HouseInfoAllDto> getdong(String gugun);
	List<HouseInfoAllDto> getApt(String dong);
	List<HouseInfoAllDto> getBookmark();
	void regitBookmark(BookmarkDto bookmarkDto);
}
