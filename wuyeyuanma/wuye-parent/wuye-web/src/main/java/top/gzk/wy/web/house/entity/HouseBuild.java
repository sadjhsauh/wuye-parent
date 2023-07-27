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
@TableName("house_build")
@ApiModel(value = "HouseBuild对象", description = "楼栋表")
public class HouseBuild implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "build_id", type = IdType.AUTO)
    private Integer buildId;

    @ApiModelProperty("栋楼名称")
    private String buildName;

    @ApiModelProperty("栋楼类型【0：普通房】【1：电梯房】")
    private Integer type;

    @ApiModelProperty("序号【排序字段】")
    private Integer orderNum;

    @ApiModelProperty("假删【0：删除】【1：未删除】")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("创建日期")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新日期")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
