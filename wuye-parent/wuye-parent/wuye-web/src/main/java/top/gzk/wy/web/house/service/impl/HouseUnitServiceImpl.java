package top.gzk.wy.web.house.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.gzk.wy.web.house.entity.HouseUnit;
import top.gzk.wy.web.house.entity.HouseUnitParam;
import top.gzk.wy.web.house.mapper.HouseUnitMapper;
import top.gzk.wy.web.house.service.IHouseUnitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class HouseUnitServiceImpl extends ServiceImpl<HouseUnitMapper, HouseUnit> implements IHouseUnitService {

    @Override
    public IPage<HouseUnit> getList(HouseUnitParam param) {
        //构造分页对象
        IPage<HouseUnit> page = new Page<>(param.getCurrentPage(),param.getPageSize());
        return this.baseMapper.getList(page,param.getBuildName(),param.getUnitName());
    }
}
