package top.gzk.wy.web.house.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.gzk.wy.web.house.entity.HouseBuild;
import com.baomidou.mybatisplus.extension.service.IService;
import top.gzk.wy.web.house.entity.HouseBuildParam;


public interface IHouseBuildService extends IService<HouseBuild> {

    IPage<HouseBuild> getList(HouseBuildParam param);
}
