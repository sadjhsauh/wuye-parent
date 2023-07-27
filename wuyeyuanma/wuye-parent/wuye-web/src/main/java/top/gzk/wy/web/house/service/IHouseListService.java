package top.gzk.wy.web.house.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.gzk.wy.web.house.entity.HouseList;
import top.gzk.wy.web.house.entity.HouseListParam;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IHouseListService extends IService<HouseList> {

    IPage<HouseList> getList(HouseListParam param);
}
