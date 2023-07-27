package top.gzk.wy.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.gzk.wy.utils.MakeMenuTree;
import top.gzk.wy.web.system.entity.CheckMenuTreeVo;
import top.gzk.wy.web.system.entity.SaveMenuIdsByRoleIdParam;
import top.gzk.wy.web.system.entity.SysMenu;
import top.gzk.wy.web.system.entity.SysRoleMenu;
import top.gzk.wy.web.system.mapper.SysMenuMapper;
import top.gzk.wy.web.system.mapper.SysRoleMenuMapper;
import top.gzk.wy.web.system.service.ISysMenuService;

import java.util.List;
import java.util.Objects;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Autowired
    private SysRoleMenuMapper roleMenuMapper;
    @Override
    public List getList() {
        //构造查询条件
        LambdaQueryWrapper<SysMenu> query = new LambdaQueryWrapper<>();
        query.orderByAsc(SysMenu::getOrderNum);
        List<SysMenu> menus = this.baseMapper.selectList(query);

        //封装成数形数据
        List<SysMenu> result = MakeMenuTree.makeTree(menus,0);

        return result;
    }

    @Override
    public List<SysMenu> getParentList() {
        //只查询目录和菜单既只查询0和1的数据
        Integer[] types = {0,1};
        //构造查询条件
        LambdaQueryWrapper<SysMenu> query = new LambdaQueryWrapper<>();
        query.in(SysMenu::getType,types).orderByAsc(SysMenu::getOrderNum);
        List<SysMenu> menus = this.baseMapper.selectList(query);

        //构造顶级菜单
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuId(0);
        sysMenu.setParentId(-1);
        sysMenu.setModuleLabel("顶级菜单");
        menus.add(sysMenu);

        //构造树形菜单
        List<SysMenu> result = MakeMenuTree.makeTree(menus,-1);
        return result;
    }

    @Override
    public CheckMenuTreeVo getAssignTree(Integer roleId) {
        //查询树形菜单数据
        List<SysMenu> tree = this.getList();
        //查询角色原来拥有的菜单id
        List<Integer> menuIds = roleMenuMapper.selectMenuIdsByRoleId(roleId);
        //封装数据
        CheckMenuTreeVo checkMenuTreeVo = new CheckMenuTreeVo();
        checkMenuTreeVo.setTree(tree);
        checkMenuTreeVo.setCheckMenuIds(menuIds);
        return checkMenuTreeVo;
    }

    @Override
    public void saveMenuIdsByRoleId(SaveMenuIdsByRoleIdParam param) {
        //删除角色最初拥有的菜单关联数据
        LambdaQueryWrapper<SysRoleMenu> query = new LambdaQueryWrapper<>();
        query.eq(SysRoleMenu::getRoleId,param.getRoleId());
        roleMenuMapper.delete(query);
        //关联新的菜单id
        List<Integer> menuIds = param.getMenuIds();
        if(!Objects.isNull(menuIds)&& menuIds.size()>0){
            for(Integer menuId : menuIds){
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setRoleId(param.getRoleId());
                sysRoleMenu.setMenuId(menuId);
                roleMenuMapper.insert(sysRoleMenu);
            }
        }
    }
}
