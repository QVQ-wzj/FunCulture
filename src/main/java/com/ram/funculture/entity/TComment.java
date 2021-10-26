package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 * @TableName t_comment
 */
@TableName(value ="t_comment")
@Data
public class TComment implements Serializable {
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
     * 父级评论，回复评论时需要
     */
    @ApiModelProperty("父级评论，回复评论时需要")
    private Long pid;


    /**
     * 文章ID
     */
    @ApiModelProperty("文章ID")
    private Long articleId;

    /**
     * 发布者ID
     */
    @ApiModelProperty("发布者ID")
    private Long releaserId;

    /**
     * 评论内容
     */
    @ApiModelProperty("评论内容")
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}