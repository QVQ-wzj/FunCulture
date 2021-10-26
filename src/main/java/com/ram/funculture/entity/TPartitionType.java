package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 分区类型
 * @TableName t_partition_type
 */
@TableName(value ="t_partition_type")
@Data
public class TPartitionType implements Serializable {
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
     * 分区类型
     */
    @ApiModelProperty("分区类型")
    private String partType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}