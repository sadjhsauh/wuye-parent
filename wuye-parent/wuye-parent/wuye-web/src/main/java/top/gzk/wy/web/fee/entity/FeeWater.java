package top.gzk.wy.web.fee.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@TableName("fee_water")
@ApiModel(value = "FeeWater对象", description = "水费表")
public class FeeWater implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "water_id", type = IdType.AUTO)
    private Integer waterId;

    @ApiModelProperty("房屋id")
    private Integer houseId;

    @ApiModelProperty("业主id")
    private Integer userId;

    @ApiModelProperty("缴费年月")
    private String payWaterMonth;

    @ApiModelProperty("缴费金额")
    private BigDecimal payWaterMoney;

    @ApiModelProperty("表显")
    private String waterrNum;

    @ApiModelProperty("0:未缴费  1：已缴费")
    private String payWaterStatus;

    @ApiModelProperty("缴费时间")
    private LocalDateTime payWaterTime;

    @ApiModelProperty("假删【0：删除】【1：未删除】")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("创建日期")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新日期")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    //排除字段
    @ApiModelProperty("用户名")
    @TableField(exist = false)
    private String username;

    @ApiModelProperty("手机号")
    @TableField(exist = false)
    private String phone;

    @ApiModelProperty("楼栋id")
    @TableField(exist = false)
    private Integer buildId;

    @ApiModelProperty("楼栋名称")
    @TableField(exist = false)
    private String buildName;

    @ApiModelProperty("单元id")
    @TableField(exist = false)
    private Integer unitId;

    @ApiModelProperty("单元名称")
    @TableField(exist = false)
    private String unitName;

    @ApiModelProperty("房屋编号")
    @TableField(exist = false)
    private String houseNum;


}
