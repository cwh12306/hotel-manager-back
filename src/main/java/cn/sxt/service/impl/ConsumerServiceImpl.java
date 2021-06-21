package cn.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sxt.mapper.ConsumerMapper;
import cn.sxt.pojo.Consumer;
import cn.sxt.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	@Resource
	private ConsumerMapper consumerMapper;
	@Override
	public int addConsumer(Consumer consumer) {
		return consumerMapper.insConsumer(consumer);
	}
	@Override
	public Consumer getGuestInfo(String phone) {
		return consumerMapper.selConsumer(phone);
	}
	@Override
	public List<Consumer> getAllGuestInfo() {
		return consumerMapper.selAllConsumer();
	}
	@Override
	public int removeConsumer(int id) {
		return consumerMapper.delConsumer(id);
	}

}
