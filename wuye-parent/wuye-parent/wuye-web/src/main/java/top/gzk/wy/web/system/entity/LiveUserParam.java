package top.gzk.wy.web.system.entity;

import lombok.Data;
import top.gzk.wy.utils.BaseParam;
@Data
public class LiveUserParam extends BaseParam {
    //姓名
    private String trueName;
    //手机号
    private String phone;
}
