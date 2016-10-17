package com.hzit.web.services;

import com.hzit.dao.entity.Userinfo;
import com.hzit.dao.mapper.GongChang;
import com.hzit.dao.mapper.UserinfoMapper;

/**
 * Created by Administrator on 2016/9/14.
 */
public class UserServiesImpl implements UserServies{
    public UserinfoMapper userinfoMapper;
    public UserServiesImpl(){
        userinfoMapper= GongChang.getUserinfoMapper();
    }
    @Override
    public Userinfo login(String name, String pwd) {
        Userinfo u=userinfoMapper.find_userName_userPwd(name,pwd);
        return u;
    }
}
