package top.gzk.wy.web.system.mapper;

import top.gzk.wy.web.system.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    List<Integer> selectRoleIds(Integer userId);
}
