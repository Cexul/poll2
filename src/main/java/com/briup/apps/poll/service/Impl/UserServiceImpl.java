package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() throws Exception {
		//创建空模板
		UserExample example = new UserExample();
		//调用QBE(QueryByExample)查询，并且将查询结果返回
		return userMapper.selectByExample(example);
	}

	@Override
	public List<User> query(String keywords) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andNameLike(keywords);
		return userMapper.selectByExample(example);
	}

	@Override
	public void save(User user) throws Exception {
		userMapper.insert(user);
		
	}

	@Override
	public void update(User user) throws Exception {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void deleteById(long id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id : ids){
			userMapper.deleteByPrimaryKey(id);
		}
	}

}
