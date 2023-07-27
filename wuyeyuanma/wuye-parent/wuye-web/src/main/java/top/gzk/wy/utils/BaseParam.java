package top.gzk.wy.utils;

import lombok.Data;

/**
 * 请求参数统一封装
 */
@Data
public class BaseParam {
    private Integer currentPage = 1;//当前页
    private Integer pageSize = 5;//每页参数展示大小
}
