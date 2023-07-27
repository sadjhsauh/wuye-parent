package top.gzk.wy.web.system.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CheckMenuTreeVo {
    //权限菜单树
    private List<SysMenu> tree = new ArrayList<>();
    //原来分配的菜单id
    private List<Integer> checkMenuIds;
}
