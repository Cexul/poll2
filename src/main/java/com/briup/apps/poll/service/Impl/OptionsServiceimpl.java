package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.extend.OptionsVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.extend.OptionsVMMapper;
import com.briup.apps.poll.service.IOptionsService;

@Service
public class OptionsServiceimpl implements IOptionsService{
	@Autowired
	private OptionsMapper optionsMapper;
	@Autowired
	private OptionsVMMapper optionsVMMapper;

	@Override
	public List<Options> findAll() throws Exception {
		OptionsExample example = new OptionsExample();
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<OptionsVM> findAllOptionsVM() throws Exception {
		
		return optionsVMMapper.selectAll();
	}
	
	

}
