package cn.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sxt.mapper.RoomMapper;
import cn.sxt.pojo.Room;
import cn.sxt.pojo.Troom;
import cn.sxt.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService{
	@Resource
	private RoomMapper roomMapper;
	@Override
	public List<Room> getRoomInfo() {
		return roomMapper.selRoom();
	}
	@Override
	public List<Troom> getTroomInfo() {
		return roomMapper.selTroom();
	}
	@Override
	public int changeRoomStatus(int rno,int status) {
		return roomMapper.updRoomStatus(rno,status);
	}

}
