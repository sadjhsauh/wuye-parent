package top.gzk.wy.web.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.web.fee.entity.FeePower;
import top.gzk.wy.web.fee.entity.FeeWater;
import top.gzk.wy.web.fee.service.IFeePowerService;
import top.gzk.wy.web.fee.service.IFeeWaterService;
import top.gzk.wy.web.system.entity.AssignHouseParam;
import top.gzk.wy.web.system.entity.LiveHouse;
import top.gzk.wy.web.system.entity.LiveUser;
import top.gzk.wy.web.system.entity.LiveUserParam;
import top.gzk.wy.web.system.service.ILiveHouseService;
import top.gzk.wy.web.system.service.ILiveUserService;
import top.gzk.wy.utils.Result;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/liveUser")
@Api(tags = "业主控制类")
public class LiveUserController {
    @Autowired
    private ILiveUserService liveUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IFeePowerService feePowerService;
    @Autowired
    private IFeeWaterService feeWaterService;
    @Autowired
    private ILiveHouseService liveHouseService;

    @ApiOperation("业主列表")
    @GetMapping("/list")
    public Result getList(LiveUserParam param){
        IPage<LiveUser> page =  liveUserService.getList(param);
        return Result.success(page);
    }

    @ApiOperation("新增业主")
    @PostMapping
    public Result addLiveUser(@RequestBody LiveUser liveUser){
        //查看用户名是否存在
        LambdaQueryWrapper<LiveUser> query = new LambdaQueryWrapper<>();
        query.eq(LiveUser::getUsername,liveUser.getUsername());
        LiveUser one = liveUserService.getOne(query);
        if(!Objects.isNull(one)){
            return Result.error(500,"用户名已经存在");
        }
        //用户名加密
        liveUser.setPassword(passwordEncoder.encode(liveUser.getPassword()));
        //新增用户名
        liveUserService.saveLiveUser(liveUser);
        return Result.success();
    }

    @ApiOperation("编辑业主")
    @PutMapping
    public Result editLiveUser(@RequestBody LiveUser liveUser){
        //查看用户名是否存在
        LambdaQueryWrapper<LiveUser> query = new LambdaQueryWrapper<>();
        query.eq(LiveUser::getUsername,liveUser.getUsername());
        LiveUser one = liveUserService.getOne(query);
        if(one!=null && one.getUserId()!=liveUser.getUserId()){
            return Result.error(500,"用户名已存在");
        }
        //编辑用户
        liveUserService.editLiveUser(liveUser);
        return Result.success();
    }

    @ApiOperation("查看业主回显信息")
    @GetMapping("/getUserById/{userId}")
    public Result getUserById(@PathVariable("userId") Integer userId){
        LiveUser user = liveUserService.getUser(userId);
        return Result.success(user);
    }

    @ApiOperation("分配房屋保存")
    @PostMapping("/assignHouse")
    public Result assignHouse(@RequestBody AssignHouseParam param){
        liveUserService.assignHouse(param);
        return Result.success();
    }

    @ApiOperation("退房")
    @PostMapping("/returnHouse")
    public Result returnHouse(@RequestBody AssignHouseParam param){
        //1.查询电费、水费是否交清
        QueryWrapper<FeePower> queryPower = new QueryWrapper<>();
        queryPower.lambda().eq(FeePower::getHouseId,param.getHouseId())
                .eq(FeePower::getUserId,param.getUserId())
                .eq(FeePower::getPayPowerStatus,"0");
        List<FeePower> powerList = feePowerService.list(queryPower);
        if(powerList!=null && powerList.size()>0){
            return Result.error(500,"请缴完电费之后在退房");
        }
        QueryWrapper<FeeWater> queryWater = new QueryWrapper<>();
        queryWater.lambda().eq(FeeWater::getHouseId,param.getHouseId())
                .eq(FeeWater::getUserId,param.getUserId())
                .eq(FeeWater::getPayWaterStatus,"0");
        List<FeeWater> waterList = feeWaterService.list(queryWater);
        if(waterList!=null && waterList.size()>0){
            return Result.error(500,"请缴完水费之后在退房");
        }
        //2.退房
        liveUserService.returnHouse(param);
        return Result.success();

    }

    @ApiOperation("删除业主")
    @DeleteMapping(value = {"/{userId}/{houseId}","/{userId}"})
    public Result deleteUser(@PathVariable("userId") Integer userId,
                             @PathVariable(value = "houseId",required = false) Integer houseId){
        if(houseId!=null){
            //1.查询用户是否退房
            QueryWrapper<LiveHouse> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(LiveHouse::getUserId,userId)
                    .eq(LiveHouse::getHouseId,houseId)
                    .eq(LiveHouse::getUseStatus,1);
            List<LiveHouse> list = liveHouseService.list(queryWrapper);
            if(list!=null && list.size()>0){
                return Result.error(500,"请退房后在删除业主");
            }
        }

        //2.删除业主
        boolean remove = liveUserService.removeById(userId);
        if(remove){
            return Result.success();
        }
        return Result.error(500,"删除失败");
    }



    
}
