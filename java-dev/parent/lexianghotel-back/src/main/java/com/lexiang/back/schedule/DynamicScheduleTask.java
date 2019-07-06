/*package com.lexiang.back.schedule;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lexiang.back.entity.Cron;
import com.lexiang.back.entity.dto.checkInDTO;
import com.lexiang.back.entity.vo.CheckInVO;
import com.lexiang.back.mapper.CronMapper;
import com.lexiang.back.mapper.RoomMapper;
import com.lexiang.back.service.CheckInService;

@Component
@EnableScheduling
@Configuration
public class DynamicScheduleTask implements SchedulingConfigurer {
	
	@Autowired
	private CronMapper cronMapper;
	
	@Autowired
	private RoomMapper roomMapper;
	

	@Autowired
	private CheckInService checkInService ;
	
	void aaa() {

		checkInDTO checkInDTO = new checkInDTO();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String curentTime = df.format(new Date());
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		checkInDTO.setExprinTime(curentTime);
		PageInfo<CheckInVO> listCheckIn = checkInService.listCheckIn(checkInDTO);
		List<CheckInVO> list = listCheckIn.getList();
		for(CheckInVO CheckInVO:list) {
			String outTime = CheckInVO.getOutTime();	
		}
		System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
	}
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		 Cron selectOne = cronMapper.selectOne(new QueryWrapper<>());
		 String cron = selectOne.getCron();
		// TODO Auto-generated method stub
		 taskRegistrar.addTriggerTask(
	                //1.添加任务内容(Runnable)
	                () -> aaa(),
	                //2.设置执行周期(Trigger)
	                triggerContext -> {
	                    //2.1 从数据库获取执行周期
	                   
	                    //2.2 合法性校验.
	                    if (StringUtils.isEmpty(cron)) {
	                        // Omitted Code ..
	                    }
	                    //2.3 返回执行周期(Date)
	                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
	                }
	        );
	    }
	}
	


*/