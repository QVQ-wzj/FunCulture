package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 分区用户中间表，用户可订阅分区
 * @TableName t_part_user
 */
@TableName(value ="t_part_user")
@Data
public class TPartUser implements Serializable {
    /**
     * 
     */
    private Long partitionId;

    /**
     * 
     */
    @TableId
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}