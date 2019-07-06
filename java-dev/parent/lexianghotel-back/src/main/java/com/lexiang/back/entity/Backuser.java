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
 * 后台管理员表
 * </p>
 *
 * @author jobob
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("b_backuser")
public class Backuser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    

    /**
     * ID
     */
    @TableId(value="id",type=IdType.UUID)
    private String id;

    /**
     * 用户姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("user_pws")
    private String userPws;

    /**
     * 用户头像
     */
    @TableField("user_image")
    private String userImage;

    /**
     * 用戶状态
     */
    @TableField("state")
    private Integer state;

    /**
     * 创建人员工工号
     */
    @TableField("creat_by")
    private String creatBy;

    /**
     * 员工工号
     */
    @TableField("work_id")
    private String workId;

    /**
     * 创建时间
     */
    @TableField("creat_time")
    private String creatTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private String updateTime;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;


}
