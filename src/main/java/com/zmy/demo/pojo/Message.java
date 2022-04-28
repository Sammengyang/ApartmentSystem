package com.zmy.demo.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-27 19:47
 */

public class Message {
    /**
     *  100 成功
     *  200 失败
     */
    private Integer code;

    private String msg;
    // 返回的数据
    private Map<String,Object> extend = new HashMap<>();

    public static Message success(){
        Message result = new Message();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }
    public static Message fail(){
        Message result = new Message();
        result.setCode(200);
        result.setMsg("处理失败");
        return result;
    }

    public Message add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
