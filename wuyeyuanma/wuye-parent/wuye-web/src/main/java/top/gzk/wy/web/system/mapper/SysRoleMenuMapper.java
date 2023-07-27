package top.gzk.wy.web.system.mapper;

import top.gzk.wy.web.system.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    List<Integer> selectMenuIdsByRoleId(Integer roleId);
}
