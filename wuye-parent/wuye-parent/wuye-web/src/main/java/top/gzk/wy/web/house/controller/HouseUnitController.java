package top.gzk.wy.web.house.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.web.house.entity.HouseUnit;
import top.gzk.wy.web.house.entity.HouseUnitParam;
import top.gzk.wy.web.house.service.IHouseUnitService;
import top.gzk.wy.utils.Result;

import java.util.List;


@RestController
@RequestMapping("/api/unit")
public class HouseUnitController {
    @Autowired
    private IHouseUnitService houseUnitService;

    @ApiOperation("单元列表")
    @GetMapping("/list")
    public Result getUnitList(HouseUnitParam param){
        IPage<HouseUnit> page = houseUnitService.getList(param);
        return Result.success(page);
    }

    @ApiOperation("添加单元")
    @PostMapping
    public Result addUnit(@RequestBody HouseUnit houseUnit){
        boolean save = houseUnitService.save(houseUnit);
        if (save) {
            return Result.success();
        }
        return Result.error(500,"添加失败");
    }

    @ApiOperation("修改单元")
    @PutMapping
    public Result editUnit(@RequestBody HouseUnit houseUnit){
        boolean update = houseUnitService.updateById(houseUnit);
        if (update) {
            return Result.success();
        }
        return Result.error(500,"修改失败");
    }

    @ApiOperation("删除单元")
    @DeleteMapping("/{unitId}")
    public Result deleteUnit(@PathVariable("unitId") Integer unitId){
        boolean remove = houseUnitService.removeById(unitId);
        if(remove){
            return Result.success();
        }
        return Result.error(500,"删除失败");
    }

    @ApiOperation("根据楼栋id查询单元列表，添加房屋用")
    @GetMapping("/getUnitListByBuildId/{buildId}")
    public Result getUnitListByBuildId(@PathVariable("buildId") Integer buildId){
        //构造查询条件
        LambdaQueryWrapper<HouseUnit> query = new LambdaQueryWrapper<>();
        query.eq(HouseUnit::getBuildId,buildId);
        List<HouseUnit> list = houseUnitService.list(query);
        return Result.success(list);
    }

}
