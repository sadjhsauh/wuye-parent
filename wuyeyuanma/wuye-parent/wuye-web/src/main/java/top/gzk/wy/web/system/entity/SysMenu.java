package top.gzk.wy.web.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "菜单表")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    @ApiModelProperty("父级菜单id;0顶级菜单")
    private Integer parentId;

    @ApiModelProperty("菜单名称")
    private String moduleLabel;

    @ApiModelProperty("权限码")
    private String menuCode;

    @ApiModelProperty("路由名称")
    private String name;

    @ApiModelProperty("路由地址")
    private String path;

    @ApiModelProperty("组件路由")
    private String url;

    @ApiModelProperty("类名;0目录，1菜单，2按钮")
    private Integer type;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("排序字段")
    private Integer orderNum;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("上级菜单名称")
    private String parentName;

    @ApiModelProperty("假删;0删除，1未删除")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("子菜单")
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<>();
}
