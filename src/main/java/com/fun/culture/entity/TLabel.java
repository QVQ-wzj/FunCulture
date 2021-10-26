package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
     * 标签名称
     */
    private String labelName;

    /**
     * 标签类型
     */
    private String labelType;

    /**
     * 标签指向链接，点击标签调整过去
     */
    private Long labelRouter;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}