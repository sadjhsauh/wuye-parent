package top.gzk.wy.utils;

import org.springframework.beans.BeanUtils;
import top.gzk.wy.web.system.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 生成树工具
 */
public class MakeMenuTree {
    public static List<SysMenu> makeTree(List<SysMenu> menuList, Integer pid) {
        List<SysMenu> list = new ArrayList<>();
        Optional.ofNullable(menuList).orElse(new ArrayList<>())
                .stream()
                .filter(item -> item != null && item.getParentId() == pid)
                .forEach(dom -> {
                    SysMenu menu = new SysMenu();
                    BeanUtils.copyProperties(dom, menu);
                    List<SysMenu> menus = makeTree(menuList, dom.getMenuId());
                    menu.setChildren(menus);
                    list.add(menu);
                });
        return list;
    }

}