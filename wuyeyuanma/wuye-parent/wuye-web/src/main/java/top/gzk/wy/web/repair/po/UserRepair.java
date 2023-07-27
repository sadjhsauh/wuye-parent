package top.gzk.wy.web.repair.po;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "user_repair" )
public class UserRepair {
    @Id
    private String id;
    //报修人
    private Integer userId;
    //联系电话
    private String phone;
    //联系地址
    private String address;
    //维修内容
    private String content;
    //维修时间
    private LocalDateTime commitTime;
    //维修状态 【0 未维修】【1已维修】
    private Integer status;
    //报修视频id
    private String videoId;
}
