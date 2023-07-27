package top.gzk.wy.web.complaint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.gzk.wy.web.complaint.service.UserComplaintService;
import top.gzk.wy.web.complaint.dao.UserComplaintDao;
import top.gzk.wy.web.complaint.po.UserComplaint;
import top.gzk.wy.web.complaint.po.UserComplaintParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserComplaintServiceImpl implements UserComplaintService {
    @Autowired
    private UserComplaintDao userComplaintDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String,Object> list(UserComplaintParam param) {
        //封装查询条件
        Query query = new Query();
        if(StringUtils.hasText(param.getTitle())){
            query.addCriteria(Criteria.where("title").regex(param.getTitle()));
        }
        if(StringUtils.hasText(param.getContent())){
            query.addCriteria(Criteria.where("content").regex(param.getContent()));
        }
        //查询记录数
        long count = mongoTemplate.count(query, UserComplaint.class);
        //查询当前页数据
        int skip = (param.getCurrentPage()-1)*param.getPageSize();
        List<UserComplaint> userComplaints = mongoTemplate.find(query.skip(skip).limit(param.getPageSize()), UserComplaint.class);
        //封装响应结果
        Map<String,Object> map = new HashMap<>();
        map.put("list",userComplaints);
        map.put("total",count);
        return map;
    }

    @Override
    public Map<String,Object> myList(UserComplaintParam param) {
        //封装查询条件
        Query query = new Query();
        if(StringUtils.hasText(param.getTitle())){
            query.addCriteria(Criteria.where("title").regex(param.getTitle()));
        }
        if(StringUtils.hasText(param.getContent())){
            query.addCriteria(Criteria.where("content").regex(param.getContent()));
        }
        if(param.getUserId()!=null){
            query.addCriteria(Criteria.where("user_id").is(param.getUserId()));
        }
        //查询记录数
        long count = mongoTemplate.count(query, UserComplaint.class);
        //查询当前页数据
        int skip = (param.getCurrentPage()-1)*param.getPageSize();
        List<UserComplaint> userComplaints = mongoTemplate.find(query.skip(skip).limit(param.getPageSize()), UserComplaint.class);
        //封装响应结果
        Map<String,Object> map = new HashMap<>();
        map.put("list",userComplaints);
        map.put("total",count);
        return map;
    }

    @Override
    public void save(UserComplaint userComplaint) {
        userComplaintDao.save(userComplaint);
    }

    @Override
    public void update(UserComplaint userComplaint) {
        //封装查询条件
        Query query = Query.query(Criteria.where("_id").is(userComplaint.getId()));
        //封装要修改的数据
        Update update = new Update();
        if(StringUtils.hasText(userComplaint.getTitle())){
            update.set("title",userComplaint.getTitle());
        }
        if(StringUtils.hasText(userComplaint.getContent())){
            update.set("content",userComplaint.getContent());
        }
        if(userComplaint.getStatus()!=null){
            update.set("status",userComplaint.getStatus());
        }
        //参数1修改条件，参数2修改内容，参数3，修改实体
        mongoTemplate.updateFirst(query,update,UserComplaint.class);
    }

    @Override
    public void delete(String id) {
        userComplaintDao.deleteById(id);
    }

}
