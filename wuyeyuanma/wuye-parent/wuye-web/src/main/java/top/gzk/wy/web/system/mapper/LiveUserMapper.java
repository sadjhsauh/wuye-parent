package top.gzk.wy.web.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import top.gzk.wy.web.system.entity.LiveUser;

import java.util.List;

public interface LiveUserMapper extends BaseMapper<LiveUser> {

    IPage<LiveUser> getList(IPage<LiveUser> page, @Param("trueName") String trueName, @Param("phone") String phone);

    LiveUser getUser(@Param("userId") Integer userId);

    List<String> getMenus(Integer userId);

}
