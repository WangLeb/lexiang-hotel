package com.lexiang.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Backuser;
import com.lexiang.back.entity.dto.BackUserDTO;
import com.lexiang.back.entity.vo.BackUserVO;
import com.lexiang.back.mapper.BackuserMapper;
import com.lexiang.back.service.BackuserService;
import com.lexiang.common.constants.BusConstant;


/**
 * <p>
 * 后台管理员表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
@Service
public class BackuserServiceImpl extends ServiceImpl<BackuserMapper, Backuser> implements BackuserService {
   
	@Autowired
	private BackuserMapper backuserMapper;
	@Override
	public PageInfo<BackUserVO> listBackUser(BackUserDTO backUserDTO) {

		PageHelper.startPage(backUserDTO.getPageIndex(),backUserDTO.getPageSize());
		List<BackUserVO> listUser = backuserMapper.listUser();
		PageInfo<BackUserVO> pageInfo = new PageInfo<BackUserVO>(listUser);
		return pageInfo;
	}
	@Override
	public void insertBackUser(Backuser backuser) {
		
		try {
			backuserMapper.insert(backuser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(BusConstant.INSERT_BACKUSER_FALSE.getDescription());
		}
	}
	
	

}
