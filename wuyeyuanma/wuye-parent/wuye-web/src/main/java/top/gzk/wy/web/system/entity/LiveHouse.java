package top.gzk.wy.web.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName("live_house")
@ApiModel(value = "LiveHouse对象", description = "业主房屋关联表")
public class LiveHouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "live_house_id", type = IdType.AUTO)
    private Integer liveHouseId;

    @ApiModelProperty("业主id")
    private Integer userId;

    @ApiModelProperty("房屋id")
    private Integer houseId;

    @ApiModelProperty("使用状态【0退房】【1使用中】")
    private Integer useStatus;

    @ApiModelProperty("假删【0删除】【1未删除】")
    private Integer deleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
