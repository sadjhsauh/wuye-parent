package top.gzk.wy.web.fee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.gzk.wy.web.fee.entity.FeePower;
import top.gzk.wy.web.fee.entity.FeePowerParam;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IFeePowerService extends IService<FeePower> {

    IPage<FeePower> getList(FeePowerParam param);

    void saveFeePower(FeePower feePower);

    void updateFeePower(FeePower feePower);
}
