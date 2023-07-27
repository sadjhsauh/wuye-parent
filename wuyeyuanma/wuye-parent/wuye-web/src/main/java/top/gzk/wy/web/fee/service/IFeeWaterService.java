package top.gzk.wy.web.fee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.gzk.wy.web.fee.entity.FeeWater;
import top.gzk.wy.web.fee.entity.FeeWaterParam;


public interface IFeeWaterService extends IService<FeeWater> {

    IPage<FeeWater> getList(FeeWaterParam param);

    void saveFeeWater(FeeWater feeWater);

    void updateFeeWater(FeeWater feeWater);
}
