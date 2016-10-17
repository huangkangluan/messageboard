package com.hzit.dao.mapper;

import com.hzit.dao.entity.Userinfo;
import org.apache.ibatis.annotations.Param;


/**
 * Created by Administrator on 2016/9/14.
 */
public interface UserinfoMapper {
    public Userinfo findByid(String userid);
    public Userinfo find_userName_userPwd(@Param("name") String name,@Param("pwd") String pwd);
}
