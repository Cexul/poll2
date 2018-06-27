package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.dao.extend.ClazzVMMapper;
import com.briup.apps.poll.dao.extend.GradeVMMapper;
import com.briup.apps.poll.service.IGradeService;
@Service
public class GradeServiceImpl implements IGradeService{
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private GradeVMMapper gradeVMMapper;

	@Override
	public List<Grade> findAll() throws Exception {
		//创建空模板
		GradeExample example=new GradeExample();
		//调用QBE查询，并且将查询结果返回
		return gradeMapper.selectByExampleWithBLOBs(example);
	}
	
	@Override
	public List<GradeVM> findAllGradeVM() throws Exception {
		
		return gradeVMMapper.selectAll();
	}

	
	@Override
	public void save(Grade grade) throws Exception {
		gradeMapper.insert(grade);
		
	}

	@Override
	public void update(Grade grade) throws Exception {
		gradeMapper. updateByPrimaryKey(grade);
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		gradeMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id:ids) {
			gradeMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public List<Grade> query(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}



}
