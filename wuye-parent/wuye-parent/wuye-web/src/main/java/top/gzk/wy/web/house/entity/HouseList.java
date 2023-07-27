package top.gzk.wy.web.house.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@TableName("house_list")
@ApiModel(value = "HouseList对象", description = "房屋表")
public class HouseList implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("房屋主键")
    @TableId(value = "house_id", type = IdType.AUTO)
    private Integer houseId;

    @ApiModelProperty("单元外键")
    private Integer unitId;

    @ApiModelProperty("房屋编号")
    private String houseNum;

    @ApiModelProperty("房屋面积")
    private String houseArea;

    @ApiModelProperty("使用状态【0未使用，1使用】")
    private Integer status;

    @ApiModelProperty("假删【0删除1，未删除】")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("楼栋id")
    @TableField(exist = false)
    private Integer buildId;

    @ApiModelProperty("楼栋名称")
    @TableField(exist = false)
    private String buildName;

    @ApiModelProperty("单元名称")
    @TableField(exist = false)
    private String unitName;
}
