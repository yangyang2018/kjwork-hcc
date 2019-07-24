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
@TableName(value = "supp_image")
public class SuppImage extends BaseSuppDO implements Serializable {

    private static final long serialVersionUID = 7478362491239920840L;

    @TableField
    private String name;
    @TableField
    private String code;
    @TableField
    private String path;
    @TableField
    private Integer type;
    @TableField()
    private Integer order;
    @TableField
    private Integer version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
