package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="用户信息相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	/**
	 * @return
	 */
	
	@Autowired
	private IUserService userService;
	
	@ApiOperation(value="保存或更新用户信息",
			notes="如果参数中包含了id，说明这是一个更新操作，如果参数中没有包含id，说明这是一个保存操作。")
	@PostMapping("saveOrUpdateUser")
	public MsgResponse saveOrUpdate(User user){
		try{
			if(user!=null && user.getId()!=null){
			userService.update(user);
			}else{
				userService.save(user);
			}return MsgResponse.success("保存或更新成功",null);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="批量删除用户信息")
	@PostMapping("batchDelete")//涉及多个值用PostMapping
	public MsgResponse batchDelete(long[] ids){
		try{
			List<Long>idList=new ArrayList<>();
			for(long id:ids){
				idList.add(id);
			}
			userService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有用户信息")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
   
	@ApiOperation(value="删除用户信息")
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			 userService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			return MsgResponse.error("删除失败！");
		}
	}
}
