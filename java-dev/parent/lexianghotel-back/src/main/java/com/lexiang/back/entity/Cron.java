package com.lexiang.back.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2019-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("b_cron")
public class Cron implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 定时表ID
     */
    @TableId("id")
    private Integer id;

    /**
     * 定时规则
     */
    @TableField("cron")
    private String cron;


}
