package com.hzit.dao.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2016/9/14.
 */
public class GongChang {
    private static SqlSession session;
    private static SqlSessionFactory sessionFactory=null;
    static {
        try {
            //有一个配置文件，需要利用输入流读取到这配置文件
            Reader reader = Resources.getResourceAsReader("conf.xml");
            //有这个输入流，通过这个输入流创建session工厂
            sessionFactory=new SqlSessionFactoryBuilder().build(reader);
            session=sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static UserinfoMapper getUserinfoMapper(){
        return session.getMapper(UserinfoMapper.class);
    }
    public static MessageboardMapper getMessageboardMapper(){
        return session.getMapper(MessageboardMapper.class);
    }
    public static void closesession(){
        session.close();
    }
    public static  void commit(){
        session.commit();
    }
    public static void rollback(){
        session.rollback();
    }
}
