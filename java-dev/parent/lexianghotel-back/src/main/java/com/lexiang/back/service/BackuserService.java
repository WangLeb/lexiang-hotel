package com.lexiang.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Backuser;
import com.lexiang.back.entity.dto.BackUserDTO;
import com.lexiang.back.entity.vo.BackUserVO;

/**
 * <p>
 * 后台管理员表 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
public interface BackuserService extends IService<Backuser> {
	
	PageInfo<BackUserVO> listBackUser(BackUserDTO backUserDTO);
	
	void insertBackUser(Backuser backuser);

}
