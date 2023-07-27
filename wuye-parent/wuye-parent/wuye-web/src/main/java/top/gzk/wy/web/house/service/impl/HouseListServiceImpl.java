package top.gzk.wy.web.house.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.gzk.wy.web.house.entity.HouseListParam;
import top.gzk.wy.web.house.entity.HouseList;
import top.gzk.wy.web.house.mapper.HouseListMapper;
import top.gzk.wy.web.house.service.IHouseListService;


@Service
public class HouseListServiceImpl extends ServiceImpl<HouseListMapper, HouseList> implements IHouseListService {

    @Override
    public IPage<HouseList> getList(HouseListParam param) {
        //构造分页对象
        IPage<HouseList> page = new Page<>(param.getCurrentPage(),param.getPageSize());

        return this.baseMapper.getList(page,param.getBuildName(),param.getUnitName(),param.getHouseNum(),param.getStatus());
    }
}
