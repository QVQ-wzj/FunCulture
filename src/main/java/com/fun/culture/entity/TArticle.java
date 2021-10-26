package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
     * 分区ID
     */
    private Long partId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章封面
     */
    private String coverImgUrl;

    /**
     * 文章内容，富文本格式类似html
     */
    private String content;

    /**
     * 作者ID
     */
    private Long releaserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}