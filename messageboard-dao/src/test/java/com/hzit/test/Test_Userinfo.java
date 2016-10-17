package com.hzit.test;

import com.hzit.dao.entity.Messageboard;
import com.hzit.dao.entity.Userinfo;
import com.hzit.dao.mapper.MessageboardMapper;
import com.hzit.dao.mapper.UserinfoMapper;
import com.hzit.dao.vo.MessageboardVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/14.
 */
public class Test_Userinfo {
    UserinfoMapper userinfoMapper;
    MessageboardMapper messageboardMapper;
    SqlSession session;
    @Before
    public void init(){
        try {
            //有一个配置文件，需要利用输入流读取到这配置文件
            Reader reader= Resources.getResourceAsReader("conf.xml");
            //有这个输入流，通过这个输入流创建session工厂
            SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
            session=sessionFactory.openSession();
            //通过session获取到UserinfoMapper接口的实现类对象
            userinfoMapper=session.getMapper(UserinfoMapper.class);
            messageboardMapper=session.getMapper(MessageboardMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void one(){
        Userinfo u=userinfoMapper.find_userName_userPwd("xiaobai","123");
        System.out.println(u);
    }
    @Test
    public void two(){
        Messageboard m=new Messageboard();
        m.setBoardId(UUID.randomUUID().toString());
        m.setSenduserId(1);
        m.setReceiveuserId(2);
        m.setMessageContext("");
        messageboardMapper.addMessageboard(m);
        session.commit();
    }
    @Test
    public void three(){
        messageboardMapper.deleteMessageboard("0e439db8-4ea0-4b5c-a58a-c5af495c28eb");
        session.commit();
    }
    @Test
    public void four(){
        Map map=new HashMap();
        //map.put("boardId","3");
        List<MessageboardVo> list=messageboardMapper.searchUserinfoByParams(map,1);
        for (MessageboardVo m:list){
            System.out.println(m.getSendusername());
        }
    }
    @Test
    public void five(){
        int num=messageboardMapper.getcount(1);
        System.out.println(num);
    }
}
