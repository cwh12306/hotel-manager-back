package cn.sxt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sxt.pojo.Users;
import cn.sxt.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	/**
	 * 登录信息校验
	 * @param username
	 * @param password
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getUser", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getUser(@RequestParam String username,@RequestParam String password,HttpServletResponse response) throws JsonProcessingException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		Users user = usersServiceImpl.getUser(username,password);
		//使用Jackson来完成Java对象转换成JSON字符串的功能。
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		System.out.println(jsonStr);
		return jsonStr;
	}
}
