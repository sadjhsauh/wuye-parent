package top.gzk.wy.web.house.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import top.gzk.wy.web.house.entity.HouseUnit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface HouseUnitMapper extends BaseMapper<HouseUnit> {

    IPage<HouseUnit> getList(IPage<HouseUnit> page, @Param("buildName") String buildName, @Param("unitName") String unitName);
}
