package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 友情链接
 * @TableName t_link
 */
@TableName(value ="t_link")
@Data
public class TLink implements Serializable {
    /**
     * 
     */
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
     * 
     */
    private String linkName;

    /**
     * 
     */
    private String linkUrl;

    /**
     * 
     */
    private String linkDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}