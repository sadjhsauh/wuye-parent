package top.gzk.wy.web.repair.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.gzk.wy.web.repair.po.UserRepair;

public interface UserRepairDao extends MongoRepository<UserRepair,String> {
}
