package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.dao.extend.AnswersVMMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService{
	@Autowired
	private AnswersMapper answersMapper;
	@Autowired
	private AnswersVMMapper answersVMMapper;
	

	@Override
	public void deleteById(long id) throws Exception {
		answersMapper.deleteByPrimaryKey(id);
		
	}


	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id:ids) {
			answersMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public List<AnswersVM> findAllAnswersVM() throws Exception {
		AnswersExample example = new AnswersExample();
		return answersVMMapper.selectAll();
	}


	@Override
	public List<Clazz> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveOrUpdate(Answers answers) throws Exception {
		if(answers.getId()!=null) {
			answersMapper.updateByPrimaryKey(answers);
		}else {
			answersMapper.insert(answers);
		}
		
	}


	@Override
	public List<Answers> findAnswersBySurveyId(long surveyId) throws Exception {
		AnswersExample example=new AnswersExample();
		example.createCriteria().andSurveyIdEqualTo(surveyId);
		
		return answersMapper.selectByExample(example);
	}




			

}
