package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireVMController {
		@Autowired
		private IQuestionnaireService questionnaireService;
		
		
		@ApiOperation(value="保存或修改问卷信息")
		@PostMapping("saveOrUpdateQuestionnaire")
		public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
			try {
				questionnaireService.saveOrUpdate(questionnaire, questionIds);
				return MsgResponse.success("保存或更新成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
				return MsgResponse.error(e.getMessage());
			}
		}
		
	
		@ApiOperation(value="查询所有问卷")
		@GetMapping("findAllQuestionnaire")
		public MsgResponse findAllQuestionnaire(){
			try {
				List<Questionnaire> list = questionnaireService.findAll();
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				return MsgResponse.error(e.getMessage());
			}
		}
		
		@ApiOperation(value="通过问卷id查找问卷")
		@GetMapping("findQuestionnaireVMById")
		public MsgResponse findQuestionnaireVMById(long id){
			try {
				QuestionnaireVM qvm = questionnaireService.findById(id);
				return MsgResponse.success("success", qvm);
			} catch (Exception e) {
				return MsgResponse.error(e.getMessage());
			}
		}
		
		@ApiOperation(value="通过问卷id删除问卷",notes="级联删除问卷和问题的关系")
		@GetMapping("deleteQuestionnaireById")
		public MsgResponse deleteQuestionnaireById(long id){
			try {
				questionnaireService.deleteById(id);
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				return MsgResponse.error(e.getMessage());
			}
		}
}











