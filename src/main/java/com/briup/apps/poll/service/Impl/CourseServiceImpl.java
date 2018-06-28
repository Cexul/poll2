package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Course> findAll() throws Exception {
		//创建空模板
		CourseExample example = new CourseExample();
		//调用QBE查询，并且将查询结果返回
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<Course> query(String keywords) throws Exception {
		CourseExample example = new CourseExample();
		example.createCriteria().andNameLike(keywords);
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void save(Course course) throws Exception {
		courseMapper.insert(course);
		
	}

	@Override
	public void update(Course course) throws Exception {
		courseMapper.updateByPrimaryKey(course);
	}

	@Override
	public void deleteById(long id) throws Exception {
		courseMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id : ids){
			courseMapper.deleteByPrimaryKey(id);
		}
	}

}
















