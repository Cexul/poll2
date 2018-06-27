package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="调查问卷相关接口")
@RestController
@RequestMapping("/Questionnaire")
public class QuestionnaireController {

	@Autowired
	private IQuestionnaireService QuestionnairerService;
	
	
	@ApiOperation(value="保存或更新调查问卷",
			notes="如果参数中包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
	@PostMapping("saveOrUpdateQuestionnaire")
	public MsgResponse saveOrUpdateQuestionnaire(Questionnaire Questionnaire){
		try {
			if(Questionnaire!=null && Questionnaire.getId()!=null){
				QuestionnairerService.update(Questionnaire);
			} else {
				QuestionnairerService.save(Questionnaire);
			}
			
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			List<Long> idList = new ArrayList<>();
			for(long id : ids){
				idList.add(id);
			}
			QuestionnairerService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = QuestionnairerService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}