package cn.sxt.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sxt.pojo.Users;

public interface UsersMapper {
	@Select("select * from users where username=#{username} and password=#{password}")
	//当参数超过多个时，需要@Param来指定参数后才会被mybatis识别
	Users selUser(@Param("username")String username,@Param("password")String password);
}
