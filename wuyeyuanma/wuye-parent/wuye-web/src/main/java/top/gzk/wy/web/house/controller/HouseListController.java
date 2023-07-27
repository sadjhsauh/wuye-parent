package top.gzk.wy.web.house.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.utils.Result;
import top.gzk.wy.web.house.entity.HouseList;
import top.gzk.wy.web.house.entity.HouseListParam;
import top.gzk.wy.web.house.service.IHouseListService;

import java.util.List;

@RestController
@RequestMapping("/api/house")
@Api(tags = "房屋管理控制类")
public class HouseListController {
    @Autowired
    private IHouseListService houseListService;

    @ApiOperation("房屋列表")
    @GetMapping("/list")
    public Result getList(HouseListParam param){
        System.out.println(param);
        IPage<HouseList> page = houseListService.getList(param);
        return Result.success(page);
    }

    @ApiOperation("添加房屋")
    @PostMapping
    public Result addHouse(@RequestBody HouseList houseList){
        boolean save = houseListService.save(houseList);
        if (save) {
            return Result.success();
        }
        return Result.error(500,"添加失败");
    }

    @ApiOperation("编辑房屋")
    @PutMapping
    public Result editHouse(@RequestBody HouseList houseList){
        boolean update = houseListService.updateById(houseList);
        if (update) {
            return Result.success();
        }
        return Result.error(500,"编辑失败");
    }

    @ApiOperation("删除房屋")
    @DeleteMapping("/{houseId}")
    public Result deleteHouse(@PathVariable("houseId") Integer houseId){
        boolean remove = houseListService.removeById(houseId);
        if (remove) {
            return Result.success();
        }
        return Result.error(500,"删除失败");
    }

    @ApiOperation("根据单元id获取房屋列表")
    @GetMapping("/getHouseByUnitId/{unitId}")
    public Result getHouseByUnitId(@PathVariable("unitId") Integer unitId){
        QueryWrapper<HouseList> query = new QueryWrapper<>();
        query.lambda().eq(HouseList::getUnitId,unitId);
        List<HouseList> list = houseListService.list(query);
        return Result.success(list);
    }
}
