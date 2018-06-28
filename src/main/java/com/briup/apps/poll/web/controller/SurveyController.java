package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@ApiOperation(value="课调",notes="调查问卷的信息课程信息包含的老师信息和班级信息")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM() {
		try {
			List<SurveyVM> list=surveyService.findAllSurveyVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}


}
