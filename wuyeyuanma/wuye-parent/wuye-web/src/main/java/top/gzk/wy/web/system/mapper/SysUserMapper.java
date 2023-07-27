package top.gzk.wy.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.gzk.wy.web.system.entity.SysUser;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    List<String> getMenus(Integer userId);
}
