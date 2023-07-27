package top.gzk.wy.web.house.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.gzk.wy.web.house.entity.HouseUnit;
import top.gzk.wy.web.house.entity.HouseUnitParam;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IHouseUnitService extends IService<HouseUnit> {

    IPage<HouseUnit> getList(HouseUnitParam param);
}
