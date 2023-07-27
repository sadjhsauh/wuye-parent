package top.gzk.wy.web.system.entity;

import lombok.Data;
import top.gzk.wy.utils.BaseParam;

@Data
public class SysUserParam extends BaseParam {
    private String trueName;
    private String phone;
}
