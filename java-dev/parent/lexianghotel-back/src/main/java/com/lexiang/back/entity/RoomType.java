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
 * @since 2019-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("b_room_type")
public class RoomType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间类型表ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 房间类型名称
     */
    @TableField("type_name")
    private String typeName;

    /**
     * 酒店ID
     */
    @TableField("hotel_id")
    private Integer hotelId;

    /**
     * 酒店类型图片
     */
    @TableField("image")
    private String image;

    /**
     * 酒店类型创建时间
     */
    @TableField("creat_time")
    private String creatTime;

    /**
     * 床型
     */
    @TableField("bed_type")
    private String bedType;

    /**
     * 可住人数
     */
    @TableField("allow_nums")
    private Integer allowNums;

    /**
     * 有无wifi
     */
    @TableField("is_wifi")
    private Integer isWifi;

    /**
     * 有无窗
     */
    @TableField("is_window")
    private Integer isWindow;


}
