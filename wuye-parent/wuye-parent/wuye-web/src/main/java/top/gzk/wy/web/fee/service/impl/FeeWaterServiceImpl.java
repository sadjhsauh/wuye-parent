package top.gzk.wy.web.fee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.gzk.wy.web.fee.entity.FeeWater;
import top.gzk.wy.web.fee.entity.FeeWaterParam;
import top.gzk.wy.web.fee.mapper.FeeWaterMapper;
import top.gzk.wy.web.fee.service.IFeeWaterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class FeeWaterServiceImpl extends ServiceImpl<FeeWaterMapper, FeeWater> implements IFeeWaterService {

    @Override
    public IPage<FeeWater> getList(FeeWaterParam param) {
        IPage<FeeWater> page = new Page<>(param.getCurrentPage(),param.getPageSize());
        return this.baseMapper.getList(page,param.getUsername(),param.getHouseNum());
    }

    @Override
    public void saveFeeWater(FeeWater feeWater) {
        this.baseMapper.insert(feeWater);
    }

    @Override
    public void updateFeeWater(FeeWater feeWater) {
        this.baseMapper.updateById(feeWater);
    }
}
