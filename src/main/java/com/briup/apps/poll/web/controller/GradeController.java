package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="年级接口")
@RestController
@RequestMapping("/grade ")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	
	@ApiOperation(value="查询年级信息",notes="每个年级信息中所属学校")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGradeVM(){
		try {
			List<GradeVM> list=gradeService.findAllGradeVM();		
			return MsgResponse.success("success", list	);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());		
		}
	}
	
	@ApiOperation(value="保存或更新年级信息",notes="如果参数中有id，说明是一个更新操作，否则为保存")
	@PostMapping("saveOrUpdateGrade")
	
	public MsgResponse saveOrUpdateGrade(Grade grade){
		try {
			if(grade!=null && grade.getId()!=null){
				gradeService.update(grade);
			}else{
				gradeService.save(grade);
			}
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="年级信息删除",notes="输入一个年级id进行删除")
	@PostMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			gradeService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

	@ApiOperation(value="批量删除年级信息",notes="输入多个年级id进行删除")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			
			List<Long> idList = new ArrayList<>();
			for(long id:ids){
				idList.add(id);
			}
			gradeService.batchDelete(idList);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	
	

	
	
}
