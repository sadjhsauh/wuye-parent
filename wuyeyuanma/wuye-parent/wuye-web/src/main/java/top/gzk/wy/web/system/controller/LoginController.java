package top.gzk.wy.web.system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.UUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.utils.RedisConstant;
import top.gzk.wy.utils.Result;
import top.gzk.wy.web.system.entity.LiveUser;
import top.gzk.wy.web.system.entity.LoginParam;
import top.gzk.wy.web.system.entity.SysUser;
import top.gzk.wy.web.system.service.LoginService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/api/")
@Api(tags = "登录处理类")
public class LoginController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private LoginService loginService;

    @PostMapping("/captcha")
    @ApiOperation("获取验证码")
    public Result<Map<String, String>> captcha(){
        //获取验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200,40,4,11);
        //获取验证码内容
        String captchaCode = lineCaptcha.getCode();
        //获取验证码图片压缩内容
        String imageBase64 = lineCaptcha.getImageBase64();
        //随机验证码id,用于存入redis中的key，方便后期查找
        String captchaId = UUID.randomUUID().toString(true);
        //将验证码存入redis中
        redisTemplate.opsForValue().set(
                RedisConstant.CAPTCHA_PRE+captchaId,
                captchaCode,
                RedisConstant.CAPTCHA_EXPIRE_TIME,
                TimeUnit.SECONDS);
        //将验证码图片和id响应给客户端
        Map<String,String> map = new HashMap<>();
        map.put("captchaId",captchaId);
        map.put("imageBase64",imageBase64);
        return Result.success(map);
    }


    @PostMapping("/login")
    @ApiOperation("登录处理")
    public Result login(
            @RequestBody
            @Valid
            @ApiParam(value = "登录需要参数",required = true)
            LoginParam loginParam){
        return loginService.login(loginParam);
    }

    @GetMapping("/hello")
    public Result hello(){
        return Result.success("hello");
    }

    @PostMapping("/logout")
    @ApiOperation("安全退出")
    public Result logout(){
        return loginService.logout();
    }

    @GetMapping("/getInfo")
    @ApiOperation("查看个人信息")
    public Result getInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof SysUser){
            SysUser sysUser = (SysUser)principal;
            return Result.success(sysUser);
        }else{
            LiveUser liveUser = (LiveUser)principal;
            return Result.success(liveUser);
        }
    }
}