package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章表
 * @TableName t_article
 */
@TableName(value ="t_article")
@Data
public class TArticle implements Serializable {
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
     * 分区ID
     */
    @ApiModelProperty("分区ID")
    private Long partId;

    /**
     * 文章标题
     */
    @ApiModelProperty("文章标题")
    private String title;

    /**
     * 文章封面
     */
    @ApiModelProperty("文章封面")
    private String coverImgUrl;

    /**
     * 文章内容，富文本格式类似html
     */
    @ApiModelProperty("文章内容，富文本格式类似html")
    private String content;

    /**
     * 作者ID
     */
    @ApiModelProperty("作者ID")
    private Long releaserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}