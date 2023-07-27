package top.gzk.wy.web.house.entity;

import lombok.Data;
import top.gzk.wy.utils.BaseParam;
@Data
public class HouseBuildParam extends BaseParam {
    private String buildName;
    private Integer type;
}
