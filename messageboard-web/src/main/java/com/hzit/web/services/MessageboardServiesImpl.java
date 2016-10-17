package com.hzit.web.services;

import com.hzit.dao.entity.Messageboard;
import com.hzit.dao.mapper.GongChang;
import com.hzit.dao.mapper.MessageboardMapper;
import com.hzit.dao.vo.MessageboardVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/14.
 */
public class MessageboardServiesImpl implements MessageboardServies {
    private MessageboardMapper messageboardMapper;
    public MessageboardServiesImpl(){
        messageboardMapper= GongChang.getMessageboardMapper();
    }
    @Override
    public void sendMessage(Messageboard messageboard) {
        try {
            messageboardMapper.addMessageboard(messageboard);
            GongChang.commit();
        }catch (Exception e){
            e.printStackTrace();
            GongChang.rollback();
        }
    }

    @Override
    public List<MessageboardVo> findMessage(int receiveuserId,int pages) {
        Map map=new HashMap();
        map.put("receiveuserId",receiveuserId);
        int statrow=(pages-1)*3;
        return messageboardMapper.searchUserinfoByParams(map,statrow);
    }

    @Override
    public int getpages(int receiveuserId) {
        int num=messageboardMapper.getcount(receiveuserId);
        if (num%3==0){
            return num/3;
        }else{
            return num/3+1;
        }
    }
}
