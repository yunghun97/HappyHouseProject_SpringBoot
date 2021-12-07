package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean join(UserDto userDto) throws Exception {
		if(userDto.getUserid() == null || userDto.getName() == null || userDto.getPassword() == null || userDto.getEmail() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(UserMapper.class).join(userDto) == 1;
	}

	@Override
	public boolean updateUser(UserDto userDto) throws Exception {
		return sqlSession.getMapper(UserMapper.class).updateUser(userDto) == 1;
		
	}

	@Override
	public boolean deleteUser(String userid) throws Exception {
		System.out.println(userid);
		if(userid == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(UserMapper.class).deleteUser(userid) == 1;
		
	}

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		if(userDto.getUserid() == null || userDto.getPassword() == null) return null;
		return sqlSession.getMapper(UserMapper.class).login(userDto);
	}

	@Override
	public UserDto userInfo(String userid) throws Exception {
		return sqlSession.getMapper(UserMapper.class).userInfo(userid);
	}

	@Override
	public UserDto findId(UserDto userDto) throws Exception {
		return sqlSession.getMapper(UserMapper.class).findId(userDto);
	}

	@Override
	public UserDto findPwd(UserDto userDto) throws Exception {
		return sqlSession.getMapper(UserMapper.class).findPwd(userDto);
	}

	@Override
	public List<UserDto> selectUsers(UserDto userDto) throws Exception {
		return sqlSession.getMapper(UserMapper.class).selectUsers(userDto);
	}
	
	

}
