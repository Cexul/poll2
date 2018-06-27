package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级接口")
@RestController
@RequestMapping("/clazz ")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	
	@ApiOperation(value="查询班级信息",notes="每个班级信息中所属年级和班主任")
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM(){
		try {
			List<ClazzVM> list=clazzService.findAllClazzVM();
			return MsgResponse.success("success", list	);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过关键字查询班级")
	@GetMapping("queryClazz")
	public MsgResponse queryClazz(String keywords){
		try {
			List<Clazz> list=clazzService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {		
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	@ApiOperation(value="插入班级")
	@PostMapping("saveClazz")
	public MsgResponse saveClazz(Clazz clazz){
		try {
			clazzService.save(clazz);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	@ApiOperation(value="修改班级信息")	
	@PostMapping("updateClazz")
	public MsgResponse updateClazz(Clazz clazz){
		try {
			clazzService.update(clazz);
			return MsgResponse.success("success", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}

	
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			
			/*List<Long> idList = new ArrayList<>();
			for(long id:ids){
				idList.add(id);
			}*/
			clazzService.batchDelete(ids);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		

}}
