package top.gzk.wy.web.complaint.service;

import top.gzk.wy.web.complaint.po.UserComplaint;
import top.gzk.wy.web.complaint.po.UserComplaintParam;

import java.util.Map;

public interface UserComplaintService {
    Map<String,Object> list(UserComplaintParam param);

    Map<String,Object> myList(UserComplaintParam param);

    void save(UserComplaint userComplaint);

    void update(UserComplaint userComplaint);

    void delete(String id);

}
