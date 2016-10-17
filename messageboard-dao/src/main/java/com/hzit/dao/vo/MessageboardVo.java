package com.hzit.dao.vo;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/14.
 */
public class MessageboardVo {
    private String boardId;
    private Integer senduserId;
    private Integer receiveuserId;
    private String sendusername;
    private String messageContext;
    private Date careatTime;
    private Integer isdelete;

    public String getSendusername() {
        return sendusername;
    }

    public void setSendusername(String sendusername) {
        this.sendusername = sendusername;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public Integer getSenduserId() {
        return senduserId;
    }

    public void setSenduserId(Integer senduserId) {
        this.senduserId = senduserId;
    }

    public Integer getReceiveuserId() {
        return receiveuserId;
    }

    public void setReceiveuserId(Integer receiveuserId) {
        this.receiveuserId = receiveuserId;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public Date getCareatTime() {
        return careatTime;
    }

    public void setCareatTime(Date careatTime) {
        this.careatTime = careatTime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}
