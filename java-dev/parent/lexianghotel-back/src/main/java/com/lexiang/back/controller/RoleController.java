package com.lexiang.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.dto.roleDTO;
import com.lexiang.back.entity.vo.RoleVO;
import com.lexiang.back.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
	
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("list")
	public Message listRole(@RequestBody(required=false) roleDTO roleDTO) {
		PageInfo<RoleVO> listRole = roleService.listRole(roleDTO);
		return new Message().ok().addData("roleList", listRole);
	}

}

