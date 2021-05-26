package com.wangwei.ratelimiter.rule;

import com.wangwei.ratelimiter.ApiLimit;
import lombok.Data;

import java.util.List;

/**
 * @Autor wangwei
 * @Data 2021/5/24 16:18
 */
@Data
public class AppRuleConfig {
    private List<ApiLimit> limits;
    private String appId;

    public AppRuleConfig() {
    }

    public AppRuleConfig(List<ApiLimit> limits, String appId) {
        this.limits = limits;
        this.appId = appId;
    }
}
