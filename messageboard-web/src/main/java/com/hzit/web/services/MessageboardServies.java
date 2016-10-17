package com.hzit.web.services;

import com.hzit.dao.entity.Messageboard;
import com.hzit.dao.vo.MessageboardVo;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14.
 */
public interface MessageboardServies {
    public void sendMessage(Messageboard messageboard);
    public List<MessageboardVo> findMessage(int receiveuserId, int pages);
    public int getpages(int receiveuserId);
}
