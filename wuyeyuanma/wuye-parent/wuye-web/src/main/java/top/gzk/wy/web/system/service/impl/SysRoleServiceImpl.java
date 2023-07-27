package top.gzk.wy.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.gzk.wy.web.system.entity.SysRole;
import top.gzk.wy.web.system.entity.SysRoleParam;
import top.gzk.wy.web.system.mapper.SysRoleMapper;
import top.gzk.wy.web.system.mapper.SysUserRoleMapper;
import top.gzk.wy.web.system.service.ISysRoleService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Override
    public IPage<SysRole> list(SysRoleParam sysRoleParam) {
        //构建分页对象
        IPage<SysRole> page = new Page<>(sysRoleParam.getCurrentPage(),sysRoleParam.getPageSize());
        //构建查询条件
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper();
        if(StringUtils.hasText(sysRoleParam.getRoleName())){
            queryWrapper.like(SysRole::getRoleName,sysRoleParam.getRoleName());
        }
        return this.baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<SysRole> checkRoles(Integer userId) {
        //查询所有角色信息
        List<SysRole> roles = this.baseMapper.selectList(null);
        //查询用户拥有的角色信息id
        List<Integer> sysUserRoles = userRoleMapper.selectRoleIds(userId);
        List<SysRole> result = roles.stream().map(role->{
            if(sysUserRoles.contains(role.getRoleId())){
                role.setChecked(true);
            }
            return role;
        }).collect(Collectors.toList());
        return result;
    }
}
