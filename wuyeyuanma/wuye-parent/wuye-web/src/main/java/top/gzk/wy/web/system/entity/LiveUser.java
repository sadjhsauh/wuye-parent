package top.gzk.wy.web.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@TableName("live_user")
@ApiModel(value = "LiveUser对象", description = "业主表")
public class LiveUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("姓名")
    private String trueName;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("性别 0：女 1：男")
    private Integer sex;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("账号是否可用；0不可用，1可用")
    private boolean enabled = true;

    @ApiModelProperty("账户是否锁定;0锁定，1未锁定")
    private boolean accountNonLocked  = true;

    @ApiModelProperty("账号是否过期;0过期，1未过期")
    private boolean accountNonExpired  = true;

    @ApiModelProperty("密码是否过期;0过期，1未过期")
    private boolean credentialsNonExpired  = true;

    @ApiModelProperty("假删字段；0删除，1未删除")
    @TableLogic
    private boolean deleted;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private LocalDateTime updateTime;

    @ApiModelProperty("角色id")
    @TableField(exist = false)
    private Integer roleId;

    @ApiModelProperty("楼栋名称")
    @TableField(exist = false)
    private String buildName;

    @ApiModelProperty("单元名称")
    @TableField(exist = false)
    private String unitName;

    @ApiModelProperty("房屋编号")
    @TableField(exist = false)
    private String houseNum;

    @ApiModelProperty("房屋面积")
    @TableField(exist = false)
    private String houseArea;

    @ApiModelProperty("房屋id")
    @TableField(exist = false)
    private Integer houseId;

    @ApiModelProperty("房屋使用状态0退房，1使用中")
    @TableField(exist = false)
    private Integer useStatus;

    @ApiModelProperty("菜单权限")
    @TableField(exist = false)
    private String[] menus;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result = new ArrayList<>();
        for(String menu: this.menus){
            result.add(new SimpleGrantedAuthority(menu));
        }
        return result;
    }
}
