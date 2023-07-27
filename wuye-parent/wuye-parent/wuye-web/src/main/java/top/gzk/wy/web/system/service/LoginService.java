package top.gzk.wy.web.system.service;

import top.gzk.wy.web.system.entity.LoginParam;
import top.gzk.wy.utils.Result;

public interface LoginService {
    Result login(LoginParam loginParam);

    Result logout();
}
