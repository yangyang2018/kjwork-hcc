package com.kj.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午9:32
 * @description
 */
@TableName(value = "supp_services")
public class SuppServices extends BaseSuppDO implements Serializable {

    private static final long serialVersionUID = -2719563097913946756L;
    @TableField
    private String title;
    @TableField
    private String content;
    @TableField()
    private Integer order;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
