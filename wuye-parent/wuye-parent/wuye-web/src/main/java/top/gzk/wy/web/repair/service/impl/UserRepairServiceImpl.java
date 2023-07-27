package top.gzk.wy.web.repair.service.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.gzk.wy.web.repair.service.UserRepairService;
import top.gzk.wy.web.repair.dao.UserRepairDao;
import top.gzk.wy.web.repair.po.UserRepair;
import top.gzk.wy.web.repair.po.UserRepairParam;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserRepairServiceImpl implements UserRepairService {
    @Autowired
    private UserRepairDao userRepairDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, Object> getList(UserRepairParam param) {
        //构造查询条件
        Query query = new Query();
        String content = param.getContent();
        if(StringUtils.hasText(content)){
            query.addCriteria(Criteria.where("content").regex(content));
        }
        //计算skip
        int skip = (param.getCurrentPage()-1)*param.getPageSize();
        //获得当前页数据
        List<UserRepair> userRepairs = mongoTemplate.find(query.limit(param.getPageSize()).skip(skip), UserRepair.class);
        //获得总记录数
        long count = mongoTemplate.count(query, UserRepair.class);
        //封装响应结果
        Map<String,Object> map = new HashMap<>();
        map.put("list",userRepairs);
        map.put("total",count);
        return map;
    }

    @Override
    public Map<String, Object> myList(UserRepairParam param) {
        //构造查询条件
        Query query = new Query();
        String content = param.getContent();
        if(StringUtils.hasText(content)){
            query.addCriteria(Criteria.where("content").regex(content));
        }
        query.addCriteria(Criteria.where("userId").is(param.getUserId()));
        //计算skip
        int skip = (param.getCurrentPage()-1)*param.getPageSize();
        //获得当前页数据
        List<UserRepair> userRepairs = mongoTemplate.find(query.limit(param.getPageSize()).skip(skip), UserRepair.class);
        //获得总记录数
        long count = mongoTemplate.count(query, UserRepair.class);
        //封装响应结果
        Map<String,Object> map = new HashMap<>();
        map.put("list",userRepairs);
        map.put("total",count);
        return map;
    }

    @Override
    public void addRepair(UserRepair userRepair) {
        userRepairDao.insert(userRepair);
    }

    @Override
    public void updateRepair(UserRepair userRepair) {
        //构建查询条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(userRepair.getId())));
        //封装更新条件
        Update update = new Update();
        String content = userRepair.getContent();
        String address = userRepair.getAddress();
        LocalDateTime commitTime = userRepair.getCommitTime();
        String phone = userRepair.getPhone();
        Integer status = userRepair.getStatus();
        String videoId = userRepair.getVideoId();
        Integer userId = userRepair.getUserId();
        if(StringUtils.hasText(content)){
            update.set("content",content);
        }
        if(StringUtils.hasText(address)){
            update.set("address",address);
        }
        if(!Objects.isNull(commitTime)){
            update.set("commitTIme",commitTime);
        }
        if(StringUtils.hasText(phone)){
            update.set("phone",phone);
        }
        if(status!=null){
            update.set("status",status);
        }
        if(StringUtils.hasText(videoId)){
            update.set("videoId",videoId);
        }
        if(userId!=null){
            update.set("userId",userId);
        }
        //修改
        mongoTemplate.updateFirst(query,update,UserRepair.class);
    }

    @Override
    public void deleteRepair(String id) {
        userRepairDao.deleteById(id);
    }
}
