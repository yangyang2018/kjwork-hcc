package com.kj.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.kj.constant.DictionaryEnum;

import java.io.Serializable;
import java.util.Dictionary;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午9:32
 * @description
 */
@TableName(value = "supp_company")
public class SuppCompany extends BaseSuppDO implements Serializable {
    private static final long serialVersionUID = -7106799704550021976L;

    @TableField
    private String name;
    @TableField
    private String profile;
    @TableField(value = "image_id")
    private Integer imageId;
    @TableField(exist = false)
    private SuppImage suppImage;

    @TableField(exist = false)
    private SuppDictionary simplesDic;//简讯
    @TableField(exist = false)
    private SuppDictionary addressDic;//地址
    @TableField(exist = false)
    private SuppDictionary phoneDic;//联系电话
    @TableField(exist = false)
    private SuppDictionary emailDic;//邮箱
    @TableField(exist = false)
    private SuppDictionary websiteDic;//网站




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public SuppImage getSuppImage() {
        return suppImage;
    }

    public void setSuppImage(SuppImage suppImage) {
        this.suppImage = suppImage;
    }

    public SuppDictionary getSimplesDic() {
        return simplesDic;
    }

    public void setSimplesDic(SuppDictionary simplesDic) {
        this.simplesDic = simplesDic;
    }

    public SuppDictionary getAddressDic() {
        return addressDic;
    }

    public void setAddressDic(SuppDictionary addressDic) {
        this.addressDic = addressDic;
    }

    public SuppDictionary getPhoneDic() {
        return phoneDic;
    }

    public void setPhoneDic(SuppDictionary phoneDic) {
        this.phoneDic = phoneDic;
    }

    public SuppDictionary getEmailDic() {
        return emailDic;
    }

    public void setEmailDic(SuppDictionary emailDic) {
        this.emailDic = emailDic;
    }

    public SuppDictionary getWebsiteDic() {
        return websiteDic;
    }

    public void setWebsiteDic(SuppDictionary websiteDic) {
        this.websiteDic = websiteDic;
    }
}

