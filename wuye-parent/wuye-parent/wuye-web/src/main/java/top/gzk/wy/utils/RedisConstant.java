package top.gzk.wy.utils;


public interface RedisConstant {
    //验证码存入redis前缀
    public static final String CAPTCHA_PRE = "wy:login:captcha:";
    //验证码过期时间
    public static final Long CAPTCHA_EXPIRE_TIME = 300L;

    //登录的业主信息存入redis的前缀
    public static final String LOGIN_LIVE_USER_PRE = "wy:login:live:user:";
    //登录的业主缓存过期时间
    public static final Long LOGIN_LIVE_USER_EXPIRE_TIME = 30L;

    //登录的物主信息存入redis的前缀
    public static final String LOGIN_SYSTEM_USER_PRE = "wy:login:system:user:";
    //登录的物主缓存过期时间
    public static final Long LOGIN_SYSTEM_USER_EXPIRE_TIME = 30L;

}