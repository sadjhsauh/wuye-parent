package top.gzk.wy.web.complaint.po;

import lombok.Data;
import top.gzk.wy.utils.BaseParam;

@Data
public class UserComplaintParam extends BaseParam {
    //投诉人
    private Integer userId;
    //标题
    private String title;
    //内容
    private String content;
}
