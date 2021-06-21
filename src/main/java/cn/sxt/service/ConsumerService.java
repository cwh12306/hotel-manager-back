package cn.sxt.service;

import java.util.List;

import cn.sxt.pojo.Consumer;

public interface ConsumerService {
	int addConsumer(Consumer consumer);
	Consumer getGuestInfo(String phone);
	List<Consumer> getAllGuestInfo();
	int removeConsumer(int id);
}
