package top.gzk.wy.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.gzk.wy.utils.SystemConstant;
import top.gzk.wy.web.system.entity.LiveUser;
import top.gzk.wy.web.system.entity.SysMenu;
import top.gzk.wy.web.system.entity.SysUser;
import top.gzk.wy.web.system.mapper.LiveUserMapper;
import top.gzk.wy.web.system.mapper.SysMenuMapper;
import top.gzk.wy.web.system.mapper.SysUserMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LiveUserMapper liveUserMapper;
    @Autowired
    private SysMenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //接收到到username是 test:1形式 1代表物主身份，0代表业主身份获取用户身份
        Integer userType = Integer.parseInt(username.substring(username.indexOf(":")+1));
        //获取用户名
        username = username.substring(0,username.indexOf(":"));
        //物主身份查询
        if(userType==SystemConstant.USER_TYPE_WUZHU){
            QueryWrapper<SysUser> query = new QueryWrapper();
            query.lambda().eq(SysUser::getUsername,username);
            SysUser user = sysUserMapper.selectOne(query);
            if(Objects.isNull(user)){
                throw new RuntimeException("用户名错误");
            }
            //查询物主权限
            Integer isAdmin = user.getIsAdmin();
            List<String> menus;
            if(isAdmin==1){
                //查询所有菜单
                List<SysMenu> menuList = menuMapper.selectList(null);
                menus = menuList.stream()
                        .map(item -> item.getMenuCode())
                        .collect(Collectors.toList());
            }else {
                menus = sysUserMapper.getMenus(user.getUserId());
            }
            user.setMenus(menus.toArray(new String[menus.size()]));
            return user;
        }else if(userType== SystemConstant.USER_TYPE_YEZHU){
            QueryWrapper<LiveUser> query = new QueryWrapper();
            query.lambda().eq(LiveUser::getUsername,username);
            LiveUser user = liveUserMapper.selectOne(query);
            if(Objects.isNull(user)){
                throw new RuntimeException("用户名错误");
            }
            //查询业主权限
            List<String> menus = liveUserMapper.getMenus(user.getUserId());
            user.setMenus(menus.toArray(new String[menus.size()]));
            return user;
        } else {
            return null;
        }
    }
}
