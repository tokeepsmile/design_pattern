package com.wangwei.ratelimiter;

import com.wangwei.ratelimiter.alg.RateLimiterAlg;
import com.wangwei.ratelimiter.rule.RatelimitRule;
import com.wangwei.ratelimiter.rule.RuleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Autor wangwei
 * @Data 2021/5/24 15:50
 */
public class RateLimiter {
    private static final Logger LOGGER = LoggerFactory.getLogger(RateLimiter.class);
    private ConcurrentHashMap<String, RateLimiterAlg> counts = new ConcurrentHashMap<>();
    private RatelimitRule rule;

    public RateLimiter() {
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml");
            if (Objects.nonNull(in)){
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (Objects.nonNull(in)){
                try {
                    in.close();
                } catch (IOException e) {
                    LOGGER.error("close file error:{}", e);
                }
            }
        }
        this.rule = new RatelimitRule(ruleConfig);
    }
}
