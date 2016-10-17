package com.hzit.test;

import com.hzit.dao.entity.Messageboard;
import com.hzit.dao.mapper.MessageboardMapper;
import com.hzit.web.services.MessageboardServiesImpl;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2016/9/14.
 */
public class Test_Message {
    MessageboardServiesImpl msl=new MessageboardServiesImpl();
    @Test
    public void testadd(){
        Messageboard mb=new Messageboard();
        mb.setBoardId(UUID.randomUUID().toString());
        mb.setSenduserId(1);
        mb.setReceiveuserId(2);
        mb.setMessageContext("司马缸砸光");
        msl.sendMessage(mb);
    }
    @Test
    public void testfind(){

    }
}