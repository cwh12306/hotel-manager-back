package cn.sxt.service;

import java.util.List;

import cn.sxt.pojo.Room;
import cn.sxt.pojo.Troom;

public interface RoomService {
	List<Room> getRoomInfo();
	List<Troom> getTroomInfo();
	int changeRoomStatus(int rno,int status);
}
