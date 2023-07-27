package top.gzk.wy.web.system.service;

import top.gzk.wy.web.system.entity.SaveRoleIdsByUserIdParam;
import top.gzk.wy.web.system.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ISysUserRoleService extends IService<SysUserRole> {

    boolean saveRoleIdsByUserId(SaveRoleIdsByUserIdParam param);
}
