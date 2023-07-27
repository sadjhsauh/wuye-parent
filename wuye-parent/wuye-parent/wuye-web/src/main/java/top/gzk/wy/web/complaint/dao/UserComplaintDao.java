package top.gzk.wy.web.complaint.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.gzk.wy.web.complaint.po.UserComplaint;

//只要编写接口继承MongoRepository，框架就会未我们生成有crud操作的实现类，并注入容器中
public interface UserComplaintDao extends MongoRepository<UserComplaint,String> {

}
