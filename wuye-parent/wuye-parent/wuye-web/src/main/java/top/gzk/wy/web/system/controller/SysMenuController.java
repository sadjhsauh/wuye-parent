package top.gzk.wy.web.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.web.system.entity.SysMenu;
import top.gzk.wy.web.system.service.ISysMenuService;
import top.gzk.wy.utils.Result;

import java.util.List;


@RestController
@RequestMapping("/api/menu")
@Api(tags = "菜单模块")
public class SysMenuController {
    @Autowired
    private ISysMenuService menuService;

    @ApiOperation("菜单数据列表")
    @GetMapping("/list")
    public Result list(){
        List<SysMenu> list = menuService.getList();
        return Result.success(list);
    }

    @ApiOperation("获取父级菜单数据列表")
    @GetMapping("/parent")
    public Result getParent(){
        List<SysMenu> parentList = menuService.getParentList();
        return Result.success(parentList);
    }

    @ApiOperation("新增菜单")
    @PostMapping
    public Result addMenu(@RequestBody SysMenu menu){
        boolean save = menuService.save(menu);
        if(save){
            return Result.success();
        }
        return Result.error(500,"新增失败");
    }

    @ApiOperation("修改菜单")
    @PutMapping
    public Result editMenu(@RequestBody SysMenu menu){
        boolean update = menuService.updateById(menu);
        if(update){
            return Result.success();
        }
        return Result.error(500,"修改失败");
    }

    @ApiOperation("删除菜单")
    @DeleteMapping("/{menuId}")
    public Result deleteMenu(@PathVariable("menuId") Integer menuId){
        boolean delete = menuService.removeById(menuId);
        if(delete){
            return Result.success();
        }
        return Result.error(500,"删除失败");
    }
}
