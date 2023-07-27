package top.gzk.wy.web.house.entity;

import lombok.Data;
import top.gzk.wy.utils.BaseParam;

@Data
public class HouseListParam extends BaseParam {
    //楼栋名称
    private String buildName;
    //使用状态
    private Integer status;
    //单元名称
    private String unitName;
    //房屋编号
    private String houseNum;
}
