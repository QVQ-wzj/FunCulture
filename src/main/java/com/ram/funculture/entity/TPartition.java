package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;

    @ApiModelProperty("逻辑删除")
    @TableLogic("deletedAt")
    private Long deletedAt;

    /**
     * 分区类型ID
     */
    @ApiModelProperty("分区类型ID")
    private Long partTypeId;

    /**
     * 分区名称
     */
    @ApiModelProperty("分区名称")
    private String partTile;

    /**
     * 分区介绍
     */
    @ApiModelProperty("分区介绍")
    private String partDec;

    /**
     * 分区图标
     */
    @ApiModelProperty("分区图标")
    private String coverUrl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}