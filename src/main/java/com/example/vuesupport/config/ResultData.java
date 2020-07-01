package com.example.vuesupport.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/1/29
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ResultData<T> implements Serializable {
    String msg;
    int code;
    T data;

    public ResultData() {
    }

    public ResultData(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static ResultData fail(String msg){
        return new ResultData(msg,-1,null);
    }

    public static <T> ResultData<T> success(T data){
        return new ResultData(null,1,data);
    }
}
