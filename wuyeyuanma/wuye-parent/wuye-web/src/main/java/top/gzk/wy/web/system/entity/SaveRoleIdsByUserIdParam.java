package top.gzk.wy.web.system.entity;

import lombok.Data;

import java.util.List;

@Data
public class SaveRoleIdsByUserIdParam {
    private Integer userId;
    private List<Integer> roleIds;
}
