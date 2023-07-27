package top.gzk.wy.web.house.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import top.gzk.wy.web.house.entity.HouseList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface HouseListMapper extends BaseMapper<HouseList> {

    IPage<HouseList> getList(
            IPage<HouseList> page,
            @Param("buildName") String buildName,
            @Param("unitName") String unitName,
            @Param("houseNum") String houseNum,
            @Param("status") Integer status);
}
