package top.gzk.wy.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.gzk.wy.utils.Result;

/**
 * 全局异常统一处理
 */
@RestControllerAdvice("top.gzk.wy")
@Slf4j
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e){
        log.error("系统异常"+e.getMessage());
        return Result.error(500,e.getMessage());
    }
}
