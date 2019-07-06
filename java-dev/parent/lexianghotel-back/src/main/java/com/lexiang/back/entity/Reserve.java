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
 * @since 2019-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("b_reserve")
public class Reserve implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预订表ID
     */
    @TableId(value="id",type=IdType.UUID)
    private String id;

    /**
     * 预订人姓名
     */
    @TableField("reserve_name")
    private String reserveName;

    /**
     * 预订人手机号码
     */
    @TableField("reserve_phone")
    private String reservePhone;

    /**
     * 入住时间
     */
    @TableField("in_time")
    private String inTime;

    /**
     * 离店时间
     */
    @TableField("out_time")
    private String outTime;

    @TableField("type_id")
    private String typeId;

    @TableField("room_id")
    private String roomId;
    
    @TableField("num")
    private Integer num;

}
