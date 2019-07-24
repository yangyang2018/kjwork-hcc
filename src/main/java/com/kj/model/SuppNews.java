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
@TableName(value = "supp_news")
public class SuppNews extends BaseSuppDO implements Serializable {

    private static final long serialVersionUID = -3548441129693581817L;

    @TableField
    private String title;
    @TableField
    private String profile;
    @TableField
    private String content;
    @TableField()
    private Integer order;

    @TableField(value = "author_id")
    private Integer authorId;
    @TableField(value = "image_id")
    private Integer imageId;

    @TableField(exist = false)
    private SuppImage suppImage;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
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
}
