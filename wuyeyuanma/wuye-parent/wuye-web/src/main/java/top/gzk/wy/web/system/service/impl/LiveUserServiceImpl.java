package top.gzk.wy.web.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.gzk.wy.web.house.entity.HouseList;
import top.gzk.wy.web.house.mapper.HouseListMapper;
import top.gzk.wy.web.system.entity.*;
import top.gzk.wy.web.system.mapper.LiveHouseMapper;
import top.gzk.wy.web.system.mapper.LiveRoleMapper;
import top.gzk.wy.web.system.mapper.LiveUserMapper;
import top.gzk.wy.web.system.service.ILiveUserService;

@Service
public class LiveUserServiceImpl extends ServiceImpl<LiveUserMapper, LiveUser> implements ILiveUserService {
    @Autowired
    private LiveRoleMapper liveRoleMapper;
    @Autowired
    private LiveHouseMapper liveHouseMapper;
    @Autowired
    private HouseListMapper houseListMapper;
    @Override
    public IPage<LiveUser> getList(LiveUserParam param) {
        IPage<LiveUser> page = new Page<>(param.getCurrentPage(),param.getPageSize());
        return this.baseMapper.getList(page,param.getTrueName(),param.getPhone());
    }

    @Override
    public void saveLiveUser(LiveUser liveUser) {
        //保存业主信息
        this.baseMapper.insert(liveUser);
        //维护角色信息
        LiveRole liveRole = new LiveRole();
        liveRole.setRoleId(liveUser.getRoleId());
        liveRole.setUserId(liveUser.getUserId());
        liveRoleMapper.insert(liveRole);
    }

    @Override
    public void editLiveUser(LiveUser liveUser) {
        //1.更新业主表
        this.baseMapper.updateById(liveUser);
        //2.角色关联表的数据删除
        LambdaQueryWrapper<LiveRole> query = new LambdaQueryWrapper<>();
        query.eq(LiveRole::getUserId,liveUser.getUserId());
        liveRoleMapper.delete(query);
        //3.插入新的角色
        LiveRole liveRole = new LiveRole();
        liveRole.setRoleId(liveUser.getRoleId());
        liveRole.setUserId(liveUser.getUserId());
        liveRoleMapper.insert(liveRole);
    }

    @Override
    public LiveUser getUser(Integer userId) {
        return this.baseMapper.getUser(userId);
    }

    @Override
    @Transactional //分配房屋
    public void assignHouse(AssignHouseParam param) {
        //保存租户和房屋的关系表
        LiveHouse liveHouse = new LiveHouse();
        liveHouse.setHouseId(param.getHouseId());
        liveHouse.setUserId(param.getUserId());
        liveHouse.setUseStatus(1);
        liveHouseMapper.insert(liveHouse);

        //更改房屋的使用状态
        HouseList houseList = new HouseList();
        houseList.setHouseId(param.getHouseId());
        houseList.setStatus(1);
        houseListMapper.updateById(houseList);

    }

    @Override //退房
    public void returnHouse(AssignHouseParam param) {
        //更新租户和房屋关系表状态为解绑
        LiveHouse liveHouse = new LiveHouse();
        liveHouse.setUseStatus(0);
        QueryWrapper<LiveHouse> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(LiveHouse::getHouseId,param.getHouseId())
                .eq(LiveHouse::getUserId,param.getUserId())
                .eq(LiveHouse::getUseStatus,1);
        liveHouseMapper.update(liveHouse,queryWrapper);
        //更新房屋表的使用状态为未使用
        HouseList houseList = new HouseList();
        houseList.setStatus(0);
        QueryWrapper<HouseList> query = new QueryWrapper();
        query.lambda().eq(HouseList::getHouseId,param.getHouseId());
        houseListMapper.update(houseList,query);
    }
}
