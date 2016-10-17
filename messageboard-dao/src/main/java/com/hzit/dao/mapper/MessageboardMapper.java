package com.hzit.dao.mapper;

import com.hzit.dao.entity.Messageboard;
import com.hzit.dao.vo.MessageboardVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/14.
 */
public interface MessageboardMapper {
    public int addMessageboard(Messageboard messageboard);
    public int deleteMessageboard(@Param("messageid") String messageid);
    public List<MessageboardVo> searchUserinfoByParams(@Param("map") Map map,@Param("statrow")Integer statrow);
    public int getcount(@Param("receiveuserId") Integer receiveuserId);
}
