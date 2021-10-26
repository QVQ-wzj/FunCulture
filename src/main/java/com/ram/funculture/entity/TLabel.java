package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章标签
 * @TableName t_label
 */
@TableName(value ="t_label")
@Data
public class TLabel implements Serializable {
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
     * 标签名称
     */
    @ApiModelProperty("标签名称")
    private String labelName;

    /**
     * 标签类型
     */
    @ApiModelProperty("标签类型")
    private String labelType;

    /**
     * 标签指向链接，点击标签调整过去
     */
    @ApiModelProperty("标签指向链接，点击标签调整过去")
    private Long labelRouter;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}