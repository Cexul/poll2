package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="选项相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
	@Autowired
	private IOptionsService optionsService;
	
	@ApiOperation(value="保存或更新选项信息",notes="如果参数中包含了id,说明这是一个更新操作。如果操作中没有包含id,说明这是一个保存操作。")
	@PostMapping("saveOrUpdateOptions")
	public MsgResponse saveOrUpdateOptions(Options options){
		try{
			if(options!=null && options.getId()!=null){
				optionsService.update(options);
			}else{
				optionsService.save(options);
			}
			return MsgResponse.success("保存或更新成功", null);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("通过ID删除选项信息")
	@GetMapping("deleteByIdOptions")
	public MsgResponse deleteByIdOptions(@RequestParam long id){
		try {
			optionsService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("查询所有选项信息")
	@GetMapping("findAllOptions")
	public MsgResponse findAllOptions(){
		try {
			List<Options> list = optionsService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
