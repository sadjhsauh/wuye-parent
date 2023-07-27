package top.gzk.wy.web.repair.service;

import top.gzk.wy.web.repair.po.UserRepair;
import top.gzk.wy.web.repair.po.UserRepairParam;

import java.util.Map;

public interface UserRepairService {
    Map<String, Object> getList(UserRepairParam param);

    Map<String, Object> myList(UserRepairParam param);

    void addRepair(UserRepair userRepair);

    void updateRepair(UserRepair userRepair);

    void deleteRepair(String id);
}
