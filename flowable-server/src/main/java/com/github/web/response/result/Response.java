package com.github.web.response.result;

/**
 * @date 2020/6/19
 */
public class Response {

    private final static String SUCCESS = "success";

    private final static String FAIL = "fail";

    public static <T> ResponseResult<T> makeOKRsp() {
        return new ResponseResult<T>().setCode(ResultCodeEnum.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> makeOKRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCodeEnum.SUCCESS).setMsg(message);
    }

    public static <T> ResponseResult<T> makeOKRsp(T data) {
        return new ResponseResult<T>().setCode(ResultCodeEnum.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> ResponseResult<T> makeErrRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCodeEnum.INTERNAL_SERVER_ERROR).setMsg(message);
    }

    public static <T> ResponseResult<T> makeRsp(ResultCodeEnum resultCodeEnum, String msg) {
        return new ResponseResult<T>().setCode(resultCodeEnum.getCode()).setMsg(msg);
    }

    public static <T> ResponseResult<T> makeRsp(ResultCodeEnum resultCodeEnum, String msg, T data) {
        return new ResponseResult<T>().setCode(resultCodeEnum.getCode()).setMsg(msg).setData(data);
    }

}
