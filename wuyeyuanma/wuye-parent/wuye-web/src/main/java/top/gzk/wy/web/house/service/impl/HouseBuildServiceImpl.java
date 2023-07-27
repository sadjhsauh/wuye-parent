package top.gzk.wy.web.house.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.gzk.wy.web.house.entity.HouseBuild;
import top.gzk.wy.web.house.entity.HouseBuildParam;
import top.gzk.wy.web.house.mapper.HouseBuildMapper;
import top.gzk.wy.web.house.service.IHouseBuildService;

import java.util.Objects;


@Service
public class HouseBuildServiceImpl extends ServiceImpl<HouseBuildMapper, HouseBuild> implements IHouseBuildService {

    @Override
    public IPage<HouseBuild> getList(HouseBuildParam param) {
        String buildName = param.getBuildName();
        Integer type = param.getType();
        //构建分页对象
        IPage<HouseBuild> page = new Page<>(param.getCurrentPage(),param.getPageSize());
        //构建查询条件
        LambdaQueryWrapper<HouseBuild> query = new LambdaQueryWrapper();
        if(StringUtils.hasText(buildName)){
            query.like(HouseBuild::getBuildName,buildName);
        }
        if(!Objects.isNull(type)){
            query.eq(HouseBuild::getType,type);
        }
        return this.baseMapper.selectPage(page,query);
    }
}
