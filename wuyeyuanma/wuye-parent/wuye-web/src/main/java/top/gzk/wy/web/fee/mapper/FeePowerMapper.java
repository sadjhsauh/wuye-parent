package top.gzk.wy.web.fee.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import top.gzk.wy.web.fee.entity.FeePower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface FeePowerMapper extends BaseMapper<FeePower> {

    IPage<FeePower> getList(IPage<FeePower> page, @Param("username") String username, @Param("houseNum") String houseNum);
}
