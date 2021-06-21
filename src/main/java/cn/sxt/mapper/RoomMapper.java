package cn.sxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sxt.pojo.Room;
import cn.sxt.pojo.Troom;

public interface RoomMapper {
	@Select("select * from room")
	List<Room> selRoom();
	@Select("select * from troom")
	List<Troom> selTroom();
	@Update("update room set status=#{status} where rno=#{rno}")
	int updRoomStatus(@Param("rno")int rno,@Param("status")int status);
}
