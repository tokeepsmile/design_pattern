package com.wangwei.ratelimiter.rule;

import lombok.Data;

import java.util.List;

/**
 * @Autor wangwei
 * @Data 2021/5/24 16:00
 */
@Data
public class RuleConfig {
    private List<AppRuleConfig> configs;
}
