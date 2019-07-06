package com.lexiang.back.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("b_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 权限名字
     */
    @TableField("permiss_name")
    private String permissName;

    /**
     * 权限图标
     */
    @TableField("permiss_icon")
    private String permissIcon;

    /**
     * 权限路由地址
     */
    @TableField("permiss_url")
    private String permissUrl;

    /**
     * 权限的父id
     */
    @TableField("p_id")
    private String pId;

    /**
     * 是否为一级权限
     */
    @TableField("permiss_index")
    private String permissIndex;
    

    
}
