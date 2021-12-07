package com.ssafy.happyhouse.model.service;

import java.util.List;
import com.ssafy.happyhouse.model.BaseaddressDto;
import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.HouseInfoAllDto;
import com.ssafy.happyhouse.model.HouseInfoDto;

public interface MapService {
	List<HouseInfoAllDto> getSido() throws Exception;
	List<HouseInfoAllDto> getGugun(String sido) throws Exception;
	List<HouseInfoAllDto> getdong(String gugun) throws Exception;
	List<HouseInfoAllDto> getApt(String dong) throws Exception;
	List<HouseInfoAllDto> getBookmark() throws Exception;
	void regitBookMark(BookmarkDto bookmarkDto) throws Exception;
}
