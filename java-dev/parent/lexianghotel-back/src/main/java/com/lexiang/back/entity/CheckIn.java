package com.lexiang.back.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("b_check_in")
public class CheckIn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登记表ID
     */
    @TableId(value="id",type=IdType.UUID)
    private String id;

    /**
     * 登记身份证号码
     */
    @TableField("card_id")
    private String cardId;

   
    /**
     * 入住人姓名
     */
    @TableField("check_name")
    private String checkName;

    /**
     * 入住人数
     */
    @TableField("nums")
    private Integer nums;

    /**
     * 登记操作人ID
     */
    @TableField("work_id")
    private Integer workId;

    /**
     * 房间号
     */
    @TableField("room_id")
    private String roomId;

    /**
     * 房间号
     */
    @TableField("phone")
    private String phone;
    
    /**
     * 登记时间
     */
    @TableField("creat_time")
    private String creatTime;
    
    /**
     * 登记时间
     */
    @TableField("out_time")
    private String outTime;

}
