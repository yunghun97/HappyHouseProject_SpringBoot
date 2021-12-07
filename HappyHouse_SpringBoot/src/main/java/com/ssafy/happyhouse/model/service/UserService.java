package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.UserDto;

public interface UserService {

	boolean join(UserDto userDto) throws Exception;
	boolean updateUser(UserDto userDto) throws Exception;
	boolean deleteUser(String userid) throws Exception;
	UserDto login(UserDto userDto) throws Exception;
	UserDto userInfo(String userid) throws Exception;
	
	UserDto findId(UserDto userDto) throws Exception;
	UserDto findPwd(UserDto userDto) throws Exception;
	
	List<UserDto> selectUsers(UserDto userDto) throws Exception;
}
