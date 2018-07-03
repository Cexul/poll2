package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="答卷答案相关接口")
@RestController
@RequestMapping("/answers ")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;
	
	@ApiOperation(value="提交答卷，每个学生提交一份")
	@PostMapping("sumitAnswer")
	public MsgResponse sumitAnswer(Answers answers) {
		try {
			answersService.saveOrUpdate(answers);
			return MsgResponse.success("提交成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	
	}
	
	@ApiOperation(value="查询答案信息")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM(){
		try {
			List<AnswersVM> list=answersService.findAllAnswersVM();
			return MsgResponse.success("success", list	);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	@ApiOperation(value="删除答案相关信息",notes="输入一个答案id进行删除")
	@PostMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			answersService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
	@ApiOperation(value="批量删除答案信息",notes="可一次输入多个id进行删除")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			answersService.batchDelete(ids);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		

}

}
