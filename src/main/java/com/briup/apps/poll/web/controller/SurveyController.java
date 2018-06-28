package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="查询所有课调")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM() {
		try {
			List<SurveyVM> list=surveyService.findAllSurveyVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="保存或更新课调信息",notes="如果参数中有id，说明是一个更新操作，否则为保存")
	@PostMapping("saveOrUpdateSurvey")
	
	public MsgResponse saveOrUpdateSurvey(Survey survey){
		try {
			if(survey!=null && survey.getId()!=null){
				surveyService.update(survey);
			}else{
				surveyService.save(survey);
			}
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除课调相关信息",notes="输入一个课调id进行删除")
	@PostMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			surveyService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
	@ApiOperation(value="批量删除课调信息",notes="可一次输入多个id进行删除")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			surveyService.batchDelete(ids);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		

}


}
