package top.gzk.wy.web.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.gzk.wy.web.system.entity.AssignHouseParam;
import top.gzk.wy.web.system.entity.LiveUser;
import top.gzk.wy.web.system.entity.LiveUserParam;


public interface ILiveUserService extends IService<LiveUser> {

    IPage<LiveUser> getList(LiveUserParam param);

    void saveLiveUser(LiveUser liveUser);

    void editLiveUser(LiveUser liveUser);

    LiveUser getUser(Integer userId);

    void assignHouse(AssignHouseParam param);

    void returnHouse(AssignHouseParam param);
}
