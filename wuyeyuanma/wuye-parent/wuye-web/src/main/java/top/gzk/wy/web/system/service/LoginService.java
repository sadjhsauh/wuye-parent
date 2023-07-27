package top.gzk.wy.web.system.service;

import top.gzk.wy.utils.Result;
import top.gzk.wy.web.system.entity.LoginParam;

public interface LoginService {
    Result login(LoginParam loginParam);

    Result logout();
}
