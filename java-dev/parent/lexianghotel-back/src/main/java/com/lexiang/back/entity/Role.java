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
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("b_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
   
    
    

    /**
     * 角色ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 角色名字
     */
    @TableField("role_name")
    private String roleName;
    
    /**
     * 角色名字
     */
    @TableField("creat_time")
    private String creatTime;


}
