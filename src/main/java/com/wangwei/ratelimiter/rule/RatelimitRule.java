package com.wangwei.ratelimiter.rule;

/**
 * @Autor wangwei
 * @Data 2021/5/24 15:56
 */
public class RatelimitRule {
    private RuleConfig ruleConfig;

    public RatelimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }
}
