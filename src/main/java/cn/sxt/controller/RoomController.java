package cn.sxt.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sxt.pojo.Room;
import cn.sxt.pojo.RoomInfo;
import cn.sxt.pojo.Troom;
import cn.sxt.service.RoomService;

@Controller
public class RoomController {
	@Resource
	private RoomService roomServiceImpl;
	/**
	 * 统计客房具体信息以及客房基本信息并封装成自定义对象
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/getRoomInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getRoomInfo(HttpServletResponse response)
			throws JsonProcessingException, UnsupportedEncodingException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 将四类客房统计信息放入到集合中
		List<RoomInfo> roomInfoList = new ArrayList<>();
		// 获取具体客房使用信息
		List<Room> roomList = roomServiceImpl.getRoomInfo();
		// 获取基本的客房信息
		List<Troom> troomList = roomServiceImpl.getTroomInfo();
		Troom troom1 = troomList.get(0);
		Troom troom2 = troomList.get(1);
		Troom troom3 = troomList.get(2);
		Troom troom4 = troomList.get(3);
		// 统计同一类的客房信息并汇总到RoomInfo
		RoomInfo roomInfo1 = new RoomInfo(troom1.getRname(), troom1.getPrice(), troom1.getImage(),
				new String(troom1.getDescription(), "GBK"),new ArrayList<Integer>());
		RoomInfo roomInfo2 = new RoomInfo(troom2.getRname(), troom2.getPrice(), troom2.getImage(),
				new String(troom2.getDescription(), "GBK"),new ArrayList<Integer>());
		RoomInfo roomInfo3 = new RoomInfo(troom3.getRname(), troom3.getPrice(), troom3.getImage(),
				new String(troom3.getDescription(), "GBK"),new ArrayList<Integer>());
		RoomInfo roomInfo4 = new RoomInfo(troom4.getRname(), troom4.getPrice(), troom4.getImage(),
				new String(troom4.getDescription(), "GBK"),new ArrayList<Integer>());
		for (Room room : roomList) {
			switch (room.getType()) {
			case (1):
				if (room.getStatus() == 1) {
					roomInfo1.addCount();
					roomInfo1.getRnos().add(room.getRno());
				}
				break;
			case (2):
				if (room.getStatus() == 1) {
					roomInfo2.addCount();
					roomInfo2.getRnos().add(room.getRno());
				}
				break;
			case (3):
				if (room.getStatus() == 1) {
					roomInfo3.addCount();
					roomInfo3.getRnos().add(room.getRno());
				}
				break;
			case (4):
				if (room.getStatus() == 1) {
					roomInfo4.addCount();
					roomInfo4.getRnos().add(room.getRno());
				}
				break;
			}
		}
		roomInfoList.add(roomInfo1);
		roomInfoList.add(roomInfo2);
		roomInfoList.add(roomInfo3);
		roomInfoList.add(roomInfo4);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(roomInfoList);
		return jsonStr;
	}
}
