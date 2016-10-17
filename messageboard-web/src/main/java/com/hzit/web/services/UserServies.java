package com.hzit.web.services;

import com.hzit.dao.entity.Userinfo;

/**
 * Created by Administrator on 2016/9/14.
 */
public interface UserServies {
    public Userinfo login(String name,String pwd);
}
