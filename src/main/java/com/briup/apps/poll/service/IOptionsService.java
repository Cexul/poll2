package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.extend.OptionsVM;

public interface IOptionsService {
	
	//List<Options> findAll() throws Exception;
	
	List<OptionsVM> findAllOptionsVM() throws Exception;
	
	void save(Options options)throws Exception;
	
	void update(Options options)throws Exception;
	
    void deleteById(long id) throws Exception;
	
	void batchDelete(long[] ids) throws Exception;

	List<Options> query(String keywords) throws Exception;


}
