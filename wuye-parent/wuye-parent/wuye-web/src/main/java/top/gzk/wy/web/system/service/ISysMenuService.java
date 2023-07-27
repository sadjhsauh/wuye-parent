package top.gzk.wy.web.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.gzk.wy.web.system.entity.CheckMenuTreeVo;
import top.gzk.wy.web.system.entity.SaveMenuIdsByRoleIdParam;
import top.gzk.wy.web.system.entity.SysMenu;

import java.util.List;



public interface ISysMenuService extends IService<SysMenu> {

    List getList();

    List<SysMenu> getParentList();

    CheckMenuTreeVo getAssignTree(Integer roleId);

    void saveMenuIdsByRoleId(SaveMenuIdsByRoleIdParam param);
}
