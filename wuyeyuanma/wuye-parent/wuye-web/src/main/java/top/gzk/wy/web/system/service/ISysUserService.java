package top.gzk.wy.web.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.gzk.wy.web.system.entity.SysUser;
import top.gzk.wy.web.system.entity.SysUserParam;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ISysUserService extends IService<SysUser> {

    IPage<SysUser> list(SysUserParam sysUserParam);
}
