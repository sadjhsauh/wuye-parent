package top.gzk.wy.web.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.utils.Result;
import top.gzk.wy.web.system.entity.SaveRoleIdsByUserIdParam;
import top.gzk.wy.web.system.entity.SysRole;
import top.gzk.wy.web.system.entity.SysUser;
import top.gzk.wy.web.system.entity.SysUserParam;
import top.gzk.wy.web.system.service.ISysRoleService;
import top.gzk.wy.web.system.service.ISysUserRoleService;
import top.gzk.wy.web.system.service.ISysUserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(tags = "用户管理")
public class SysUserController {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysUserRoleService userRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation("新增用户")
    @PostMapping
    public Result addUser(@RequestBody SysUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean save = userService.save(user);
        if(save){
            return Result.success();
        }
        return Result.error(500,"新增失败");
    }

    @ApiOperation("编辑用户")
    @PutMapping
    public Result editUser(@RequestBody SysUser user){
        boolean update = userService.updateById(user);
        if(update){
            return Result.success();
        }
        return Result.error(500,"修改失败");
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{userId}")
    public Result deleteUser(@PathVariable("userId") Integer userId){
        boolean remove = userService.removeById(userId);
        if(remove){
            return Result.success();
        }
        return Result.error(500,"删除失败");
    }

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public Result list(SysUserParam sysUserParam){
        IPage<SysUser> page = userService.list(sysUserParam);
        return Result.success(page);
    }

    @ApiOperation("查询所有角色并选中用户拥有的角色")
    @GetMapping("checkRoles/{userId}")
    public Result checkRoles(@PathVariable Integer userId){
        List<SysRole> list = roleService.checkRoles(userId);
        return Result.success(list);
    }

    @ApiOperation("保存用户拥有的角色信息")
    @PutMapping("/saveRoleIdsByUserId")
    public Result saveRoleIdsByUserId(@RequestBody SaveRoleIdsByUserIdParam param){
        boolean save = userRoleService.saveRoleIdsByUserId(param);
        if(save){
            return Result.success();
        }
        return Result.error(500,"保存角色信息失败");
    }
}
