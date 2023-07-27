package top.gzk.wy.web.fee.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.utils.Result;
import top.gzk.wy.web.fee.entity.FeePower;
import top.gzk.wy.web.fee.entity.FeePowerParam;
import top.gzk.wy.web.fee.service.IFeePowerService;
import top.gzk.wy.web.system.entity.LiveHouse;
import top.gzk.wy.web.system.service.ILiveHouseService;


@RestController
@RequestMapping("/api/feePower")
public class FeePowerController {
    @Autowired
    private IFeePowerService feePowerService;
    @Autowired
    private ILiveHouseService liveHouseService;

    @ApiOperation("电费列表")
    @GetMapping("/list")
    public Result getList(FeePowerParam param){
        IPage<FeePower> page = feePowerService.getList(param);
        return Result.success(page);
    }

    @ApiOperation("新增电费")
    @PostMapping
    public Result addFeePower(@RequestBody FeePower feePower){
        //根据房屋id查询正在使用该房间的用户
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId,feePower.getHouseId())
                .eq(LiveHouse::getUseStatus,1);
        LiveHouse liveHouse = liveHouseService.getOne(query);
        if(liveHouse==null){
            return Result.error(500,"该房间没有人使用，不能添加电费");
        }
        //把查询出来的用户id设置到电费实体里面
        feePower.setUserId(liveHouse.getUserId());
        feePowerService.saveFeePower(feePower);
        return Result.success();
    }

    @ApiOperation("编辑电费")
    @PutMapping
    public Result editFeePower(@RequestBody FeePower feePower){
        //根据房屋id查询正在使用该房间的用户
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId,feePower.getHouseId())
                .eq(LiveHouse::getUseStatus,1);
        LiveHouse liveHouse = liveHouseService.getOne(query);
        if(liveHouse==null){
            return Result.error(500,"该房间没有人使用，不能编辑电费");
        }
        //把查询出来的用户id设置到电费实体里面
        feePower.setUserId(liveHouse.getUserId());
        feePowerService.updateFeePower(feePower);
        return Result.success();
    }

    @ApiOperation("删除电费")
    @DeleteMapping("/{powerId}")
    public Result deleteFeePower(@PathVariable("powerId") Integer powerId){
        //如果已经缴费，就不能删除
        QueryWrapper<FeePower> query = new QueryWrapper<>();
        query.lambda().eq(FeePower::getPowerId,powerId)
                .eq(FeePower::getPayPowerStatus,"1");
        FeePower one = feePowerService.getOne(query);
        if(one!=null){
            return Result.error(500,"已缴费，不能删除");
        }
        //删除操作
        boolean remove = feePowerService.removeById(powerId);
        if(remove){
            return Result.success();
        }
        return Result.error(500,"删除失败");
    }

    @ApiOperation("缴费")
    @PostMapping("/payPower")
    public Result payPower(@RequestBody FeePower feePower){
        boolean b = feePowerService.updateById(feePower);
        if(b){
            return Result.success();
        }
        return Result.error(500,"缴费失败");
    }
}
