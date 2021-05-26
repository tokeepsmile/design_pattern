package com.wangwei.ratelimiter;

import lombok.Data;

/**
 * @Autor wangwei
 * @Data 2021/5/24 16:12
 */
@Data
public class ApiLimit {
    private static final Integer DEFAULT_TIME_UNIT = 1;
    private Integer limit;
    private String api;
    private Integer unit = DEFAULT_TIME_UNIT;

    public ApiLimit(Integer limit, String api, Integer unit) {
        this.limit = limit;
        this.api = api;
        this.unit = unit;
    }

    public ApiLimit(Integer limit, String api) {
        this(limit, api, DEFAULT_TIME_UNIT);
    }
}
