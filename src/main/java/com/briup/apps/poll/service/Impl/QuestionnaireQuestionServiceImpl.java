package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireQuestionVMMapper;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;

@Service
public class QuestionnaireQuestionServiceImpl implements IQuestionnaireQuestionService{
	@Autowired
	private QuestionnaireQuestionMapper questionnairequestionMapper;

	@Autowired
	private QuestionnaireQuestionVMMapper questionnairequestionVMMapper;
	@Override
	public List<QuestionnaireQuestion> findAll() throws Exception {
		QuestionnaireQuestionExample example=new QuestionnaireQuestionExample();
		return questionnairequestionMapper.selectByExample(example);
	}

	@Override
	public List<QuestionnaireQuestionVM> findAllQuestionnaireQuestion() throws Exception {
		
		return questionnairequestionVMMapper.selectAll();
	}
	

}
