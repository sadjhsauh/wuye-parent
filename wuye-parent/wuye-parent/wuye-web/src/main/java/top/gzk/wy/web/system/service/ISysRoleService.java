package top.gzk.wy.web.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.gzk.wy.web.system.entity.SysRole;
import top.gzk.wy.web.system.entity.SysRoleParam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface ISysRoleService extends IService<SysRole> {

    IPage<SysRole> list(SysRoleParam sysRoleParam);

    List<SysRole> checkRoles(Integer userId);
}
