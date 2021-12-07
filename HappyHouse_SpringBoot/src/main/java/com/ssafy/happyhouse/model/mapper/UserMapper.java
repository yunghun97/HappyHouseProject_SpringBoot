package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.UserDto;

public interface UserMapper {

	int join(UserDto userDto) throws SQLException;
	int updateUser(UserDto userDto) throws SQLException;
	int deleteUser(String userid) throws SQLException;
	UserDto login(UserDto userDto) throws SQLException;
	UserDto userInfo(String userid) throws SQLException;
	UserDto findId(UserDto userDto) throws SQLException;
	UserDto findPwd(UserDto userDto) throws SQLException;
	int checkId(String userid) throws SQLException;
	
	List<UserDto> selectUsers(UserDto userDto) throws SQLException;
}
