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
@TableName("b_room")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间表id
     */
    @TableId(value="id",type=IdType.UUID)
    private String id;

    /**
     * 房间号
     */
    @TableField("room_code")
    private String roomCode;

    /**
     * 房间类型
     */
    @TableField("type_id")
    private String typeId;

    /**
     * 房间状态(0,未住，1，已入住，2，有其他原因无法入住客户 3.已经被人预订)
     */
    @TableField("state")
    private Integer state;

    /**
     * 添加人
     */
    @TableField("work_id")
    private String workId;

    /**
     * 添加时间
     */
    @TableField("creat_time")
    private String creatTime;


}
