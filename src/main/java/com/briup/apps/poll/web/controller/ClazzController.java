package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
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
	
	@ApiOperation(value="保存或更新班级信息",notes="如果参数中有id，说明是一个更新操作，否则为保存")
	@PostMapping("saveOrUpdateClazz")
	
	public MsgResponse saveOrUpdateClazz(Clazz clazz){
		try {
			if(clazz!=null && clazz.getId()!=null){
				clazzService.update(clazz);
			}else{
				clazzService.save(clazz);
			}
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除班级相关信息",notes="输入一个班级id进行删除")
	@PostMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			clazzService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
	@ApiOperation(value="批量删除班级信息",notes="可一次输入多个id进行删除")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try {
			clazzService.batchDelete(ids);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		

}}
