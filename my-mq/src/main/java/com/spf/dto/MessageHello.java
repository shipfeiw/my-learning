package com.spf.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * created by shipengfei
 * on 2018/12/24, 10:50
 * motto: Saying and doing is two different things.
 */
public class MessageHello implements Serializable {

    private static final long serializableUID = 5L;

    private long id;
    private String msg;
    private Date sendTime;

    public MessageHello() {
    }

    public MessageHello(long id, String msg, Date sendTime) {
        this.id = id;
        this.msg = msg;
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "MessageHello{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
