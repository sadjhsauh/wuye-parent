package top.gzk.wy.web.fee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import top.gzk.wy.web.fee.entity.FeeWater;


public interface FeeWaterMapper extends BaseMapper<FeeWater> {

    IPage<FeeWater> getList(
            IPage<FeeWater> page,
            @Param("username") String username,
            @Param("houseNum") String houseNum);
}
