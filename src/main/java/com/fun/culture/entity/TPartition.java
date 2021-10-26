package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章分区
 * @TableName t_partition
 */
@TableName(value ="t_partition")
@Data
public class TPartition implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Date createdAt;

    /**
     * 
     */
    private Date updatedAt;

    /**
     * 
     */
    private Date deletedAt;

    /**
     * 分区类型ID
     */
    private Long partTypeId;

    /**
     * 分区名称
     */
    private String partTitle;

    /**
     * 分区介绍
     */
    private String partDesc;

    /**
     * 分区图标
     */
    private String coverUrl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}