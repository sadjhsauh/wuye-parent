package top.gzk.wy.web.fee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.gzk.wy.web.fee.entity.FeePower;
import top.gzk.wy.web.fee.entity.FeePowerParam;
import top.gzk.wy.web.fee.mapper.FeePowerMapper;
import top.gzk.wy.web.fee.service.IFeePowerService;


@Service
public class FeePowerServiceImpl extends ServiceImpl<FeePowerMapper, FeePower> implements IFeePowerService {

    @Override
    public IPage<FeePower> getList(FeePowerParam param) {
        IPage<FeePower> page = new Page<>(param.getCurrentPage(),param.getPageSize());
        return this.baseMapper.getList(page,param.getUsername(),param.getHouseNum());
    }

    @Override
    public void saveFeePower(FeePower feePower) {
        this.baseMapper.insert(feePower);
    }

    @Override
    public void updateFeePower(FeePower feePower) {
        this.baseMapper.updateById(feePower);
    }
}
