package top.gzk.wy.web.complaint.po;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 用户投诉
 */
@Data
@Document(collection = "user_complaint") //如果和数据库集合名可以省略，
public class UserComplaint {
    //对应数据库主键
    @Id
    private String id;// 主键
    @Field("user_id") //集合中的字段，如果一样可以省略
    private Integer userId;// 业主id
    private String title;
    private String content;
    private Integer status;
}
