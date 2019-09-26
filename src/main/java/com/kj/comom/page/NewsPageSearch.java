package com.kj.comom.page;

import com.kj.model.SuppNews;

import java.io.Serializable;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/25 上午7:11
 * @description
 */
public class NewsPageSearch extends SimplePage<SuppNews> implements Serializable{


    private static final long serialVersionUID = -3668744837920889404L;

    private String title ;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
