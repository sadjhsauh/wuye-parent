package top.gzk.wy.web.fee.entity;

import lombok.Data;
import top.gzk.wy.utils.BaseParam;

@Data
public class FeePowerParam extends BaseParam {
    private String username;
    private String houseNum;
}
