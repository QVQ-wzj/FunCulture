package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章标签中间表，多对多
 * @TableName t_label_article
 */
@TableName(value ="t_label_article")
@Data
public class TLabelArticle implements Serializable {
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
     * 
     */
    private Long labelId;

    /**
     * 
     */
    private Long articleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}