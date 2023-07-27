package top.gzk.wy.web.complaint.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import top.gzk.wy.utils.JwtUtils;
import top.gzk.wy.utils.Result;
import top.gzk.wy.web.system.entity.LiveUser;
import top.gzk.wy.web.system.entity.SysUser;
import top.gzk.wy.web.complaint.po.UserComplaint;
import top.gzk.wy.web.complaint.po.UserComplaintParam;
import top.gzk.wy.web.complaint.service.UserComplaintService;

import java.util.Map;

@Api(tags = "业主投诉控制类")
@RestController
@RequestMapping("/api/complaint")
public class UserComplaintController {
    @Autowired
    private UserComplaintService userComplaintService;
    @Autowired
    private JwtUtils jwtUtils;
    @ApiOperation("投诉列表")
    @GetMapping("/list")
    public Result getList(UserComplaintParam param){
        Map<String,Object> map = userComplaintService.list(param);
        return Result.success(map);
    }

    @ApiOperation("我的投诉")
    @GetMapping("/myList")
    public Result myList(UserComplaintParam param){

        param.setUserId(getUserId());
        //查询我的投诉列表
        Map<String,Object> map = userComplaintService.myList(param);
        return Result.success(map);
    }

    @ApiOperation("新增投诉")
    @PostMapping()
    public Result addComplaint(@RequestBody UserComplaint userComplaint){

        userComplaint.setUserId(getUserId());
        userComplaint.setStatus(0);
        userComplaint.setId(null);
        userComplaintService.save(userComplaint);
        return Result.success();
    }

    @ApiOperation("编辑投诉")
    @PutMapping()
    public Result updateComplaint(@RequestBody UserComplaint userComplaint){
        userComplaintService.update(userComplaint);
        return Result.success();
    }

    @ApiOperation("删除投诉")
    @DeleteMapping("/{id}")
    public Result deleteComplaint(@PathVariable("id") String id){
        userComplaintService.delete(id);
        return Result.success();
    }

    private Integer getUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof SysUser){
            SysUser sysUser = (SysUser)principal;
            return sysUser.getUserId();
        }else {
            LiveUser liveUser = (LiveUser)principal;
            return liveUser.getUserId();
        }
    }
    
}
