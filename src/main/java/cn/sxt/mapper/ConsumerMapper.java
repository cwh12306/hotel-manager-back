package cn.sxt.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import cn.sxt.pojo.Consumer;


public interface ConsumerMapper {
	@Insert("insert into consumer values (default,#{uid},#{uname},#{phone},#{sex},#{rno},#{cdays},#{payment})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	int insConsumer(Consumer consumer);
	@Select("select * from consumer where phone=#{phone}")
	Consumer selConsumer(String phone);
	@Select("select * from consumer")
	List<Consumer> selAllConsumer();
	@Delete("delete from consumer where id=#{id}")
	int delConsumer(int id);
}
