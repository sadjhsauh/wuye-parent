package top.gzk.wy.web.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 业主角色中间表
 * </p>
 *
 * @author 胖叔讲Java
 * @since 2023-07-21
 */
@Getter
@Setter
@TableName("live_role")
@ApiModel(value = "LiveRole对象", description = "业主角色中间表")
public class LiveRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    private Integer roleId;

    @ApiModelProperty("业主id")
    private Integer userId;

    @ApiModelProperty("假删【0删除】【1未删除】")
    private Integer deleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
