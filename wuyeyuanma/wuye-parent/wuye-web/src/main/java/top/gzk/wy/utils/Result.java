package top.gzk.wy.utils;



import lombok.Data;

/**
 * 统一响应结果封装
 */
@Data
public class Result<T> {
    //状态码
    private Integer code;
    //响应消息
    private String msg;
    //响应数据
    private T data;
    //响应成功
    private static final int OK_CODE = 200;
    //响应成功消息
    private static final String OK_MSG = "SUCCESS";
    //响应失败
    private static final int SERVER_ERROR = 500;
    private static final String SERVER_ERROR_MSG = "服务器异常";
    //未认证
    private static final int UNAUTHORIZED = 401;
    private static final String UNAUTHORIZED_MSG = "未认证";
    //权限不足
    private static final int PERMISSION_DENIED = 403;
    private static final String PERMISSION_DENIED_MSG = "权限不足";

    public Result(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data= data;
    }
    public Result(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    //响应成功
    public Result(){
        this(OK_CODE,OK_MSG);
    }
    public static Result success(){
        return new Result();
    }
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(OK_CODE,OK_MSG,data);
        return result;
    }
    public static Result error(Integer code,String msg){
        return new Result(code,msg);
    }
    public static Result error(){
        return new Result(SERVER_ERROR,SERVER_ERROR_MSG);
    }
    public static Result unauthorized(){
        return new Result(UNAUTHORIZED,UNAUTHORIZED_MSG);
    }
    public static Result permissionDenied(){
        return new Result(PERMISSION_DENIED,PERMISSION_DENIED_MSG);
    }
}