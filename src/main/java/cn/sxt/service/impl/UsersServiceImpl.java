package cn.sxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sxt.mapper.UsersMapper;
import cn.sxt.pojo.Users;
import cn.sxt.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;
	@Override
	public Users getUser(String username,String password) {
		return usersMapper.selUser(username,password);
	}
	
}
