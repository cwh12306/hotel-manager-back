package cn.sxt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sxt.pojo.Consumer;
import cn.sxt.service.ConsumerService;
import cn.sxt.service.RoomService;

@Controller
public class ConsumerController {
	@Resource
	private ConsumerService ConsumerServiceImpl;
	@Resource
	private RoomService RoomServiceImpl;

	/**
	 * 添加客户信息
	 * 
	 * @param response
	 * @param consumer
	 * @return
	 */
	@RequestMapping("/addConsumer")
	public String addConsumer(HttpServletResponse response, @ModelAttribute Consumer consumer) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		consumer.setPayment(consumer.getPrice() * consumer.getCdays());
		ConsumerServiceImpl.addConsumer(consumer);
		RoomServiceImpl.changeRoomStatus(consumer.getRno(),0);
		return "payment.jsp";
	}

	/**
	 * 获取指定电话的客户信息
	 * 
	 * @param phone
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getGuestInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getGuestInfo(@RequestParam String phone, HttpServletResponse response)
			throws JsonProcessingException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Consumer guestInfo = ConsumerServiceImpl.getGuestInfo(phone);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(guestInfo);
		System.out.println(guestInfo);
		return jsonStr;
	}

	/**
	 * 获取所有客户的信息
	 * 
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getAllGuestInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getAllGuestInfo(HttpServletResponse response) throws JsonProcessingException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Consumer> allGuestInfo = ConsumerServiceImpl.getAllGuestInfo();
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allGuestInfo);
		return jsonStr;
	}
	/**
	 * 删除指定的客户
	 * @param id
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/removeConsumer", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int removeConsumer(@RequestParam int id,@RequestParam int rno, HttpServletResponse response) throws JsonProcessingException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		int flag = ConsumerServiceImpl.removeConsumer(id);
		RoomServiceImpl.changeRoomStatus(rno, 1);
		return flag;
	}
}
