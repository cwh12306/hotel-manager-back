package cn.sxt.service;

import cn.sxt.pojo.Users;

public interface UsersService {
	Users getUser(String username,String password);
}
