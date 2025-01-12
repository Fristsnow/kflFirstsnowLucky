package com.blog.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;


    public static <T> Result<T> returnData(int code, String msg, T data) {

        Result<T> result = new Result<>();

        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }

    public static <T> Result<T> success() {
        return returnData(200, "success", null);
    }

    public static <T> Result<T> success(T data) {
        return returnData(200, "success", data);
    }

    public static <T> Result<T> error401() {
        return returnData(401, "unauthorized”", null);
    }

    public static <T> Result<T> error(int code, String msg) {
        return returnData(code, msg, null);
    }

}
