package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题问卷相关接口")
@RestController
@RequestMapping("/questionnairequestion")
public class QuestionnaireQuestionController {
	@Autowired
	private IQuestionnaireQuestionService questionnairequestionService;
	
	@ApiOperation(value="查询问卷问题信息",notes="问卷的信息和问题的信息")
	@GetMapping("findAllQuestionnaireQuestionVM")
	public MsgResponse findAllQuestionnaireQuestionVM() {
		try {
			List<QuestionnaireQuestionVM> list=questionnairequestionService.findAllQuestionnaireQuestion();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="查询问卷问题信息")
	@GetMapping("findAllQuestionnaireQuestion")
	public MsgResponse findAllQuestionnaireQuestion() {
		try {
			List<QuestionnaireQuestion> list=questionnairequestionService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
