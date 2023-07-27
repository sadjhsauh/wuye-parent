package top.gzk.wy.web.system.entity;

import lombok.Data;

import java.util.List;

@Data
public class SaveMenuIdsByRoleIdParam {
    private Integer roleId;
    private List<Integer> menuIds;
}
