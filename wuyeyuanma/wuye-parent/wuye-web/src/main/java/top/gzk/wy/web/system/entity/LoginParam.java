package top.gzk.wy.web.system.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginParam {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotNull(message = "身份类型不能为空")
    private Integer userType;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "验证码id不能为空")
    private String captchaId;
    @NotBlank(message = "验证码不能为空")
    private String captchaCode;
}
