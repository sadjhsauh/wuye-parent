package top.gzk.wy.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.gzk.wy.web.system.entity.SysUser;
import top.gzk.wy.web.system.entity.SysUserParam;
import top.gzk.wy.web.system.mapper.SysUserMapper;
import top.gzk.wy.web.system.service.ISysUserService;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public IPage<SysUser> list(SysUserParam sysUserParam) {
        //构建分页对象
        IPage<SysUser> page = new Page(sysUserParam.getCurrentPage(),sysUserParam.getPageSize());
        //构建查询条件
        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<>();
        String trueName = sysUserParam.getTrueName();
        String phone = sysUserParam.getPhone();
        if(StringUtils.hasText(trueName)){
            query.like(SysUser::getTrueName,trueName);
        }
        if(StringUtils.hasText(phone)){
            query.like(SysUser::getPhone,phone);
        }
        return this.baseMapper.selectPage(page,query);
    }
}
