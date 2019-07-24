package com.kj.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午9:32
 * @description
 */
@TableName(value = "supp_dictionary")
public class SuppDictionary extends BaseSuppDO implements Serializable {

    private static final long serialVersionUID = -2558541237723161330L;
    @TableField(value = "dic_no")
    private String dicNo;
    @TableField(value = "group_no")
    private String groupNo;
    @TableField
    private String name;
    @TableField
    private String remark;
    @TableField
    private Integer version;
    @TableField(value = "model_flag")
    private Integer modelFlag;


    public String getDicNo() {
        return dicNo;
    }

    public void setDicNo(String dicNo) {
        this.dicNo = dicNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getModelFlag() {
        return modelFlag;
    }

    public void setModelFlag(Integer modelFlag) {
        this.modelFlag = modelFlag;
    }


}
