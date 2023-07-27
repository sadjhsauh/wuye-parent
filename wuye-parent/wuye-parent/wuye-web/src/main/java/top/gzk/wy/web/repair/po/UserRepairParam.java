package top.gzk.wy.web.repair.po;

import lombok.Data;
import top.gzk.wy.utils.BaseParam;
@Data
public class UserRepairParam extends BaseParam {
    //报修人
    private Integer userId;
    //维修内容
    private String content;
}
