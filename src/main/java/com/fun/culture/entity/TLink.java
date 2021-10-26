package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    /**
     * 
     */
    private Date updatedAt;

    /**
     * 
     */
    private Date createdAt;

    /**
     * 
     */
    private Date deletedAt;

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