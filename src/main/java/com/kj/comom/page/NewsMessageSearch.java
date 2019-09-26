package com.kj.comom.page;

import com.kj.model.SuppMessage;
import com.kj.model.SuppNews;

import java.io.Serializable;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/25 上午7:11
 * @description
 */
public class NewsMessageSearch extends SimplePage<SuppMessage> implements Serializable{


    private static final long serialVersionUID = -3668744837920889404L;

    private String subject ;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
