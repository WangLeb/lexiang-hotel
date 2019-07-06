package com.lexiang.back.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lexiang.back.entity.Permission;
import com.lexiang.back.entity.dto.BackUserDTO;
import com.lexiang.back.service.PermissionService;
import com.lexiang.common.constants.Message;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Message listBackUser(@RequestBody BackUserDTO backUserDTO){
		log.info("能够获取前台的参数");
		QueryWrapper<Permission> queryWrapper = new QueryWrapper<Permission>();
		//获得菜单权限列表
		List<Permission> list = permissionService.list(queryWrapper);
		//存放前端所需要格式的 菜单列表
		ArrayList<Object> permissionList = new ArrayList<>();
		//将菜单列表遍历
		for(Permission permission:list) {
			//当菜单为一级菜单时
			if(permission.getPId().equals("0")) {
				//获得一级菜单ID
				String parentId = permission.getId();
				//定义一级菜单详情
				HashMap<String, Object> permissionOne = new HashMap<>();
				//一级菜单标题
				permissionOne.put("title", permission.getPermissName());
				//一级菜单值
				permissionOne.put("value", permission.getId());
				//一级菜单的键
				permissionOne.put("key", permission.getId());
				//定义一级菜单的孩子菜单列表
				ArrayList<Object> permissionClildList = new ArrayList<>();
				//将菜单列表遍历，找出PID为一级菜单ID的菜单权限
				for(Permission permissionClild:list) {
					//当菜单ID等同以及菜单ID
					if(permissionClild.getPId().equals(parentId)) {
						//定义孩子菜单详情
						HashMap<Object, Object> permissionClildOne = new HashMap<>();
						permissionClildOne.put("title", permissionClild.getPermissName());
						permissionClildOne.put("value", permissionClild.getId());
						permissionClildOne.put("key", permissionClild.getId());
						//将孩子菜单添加到上面顶一个孩子菜单列表
						permissionClildList.add(permissionClildOne);
					}
				}
				//将孩子菜单列表添加到一级菜单详情
				permissionOne.put("children",permissionClildList);
				//添加到一级菜单
				permissionList.add(permissionOne);
			}
			
		}
		return new Message().ok().addData("permissionList",permissionList);
		
	}

}

