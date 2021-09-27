package com.test;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangwei
 * @date 2021-06-09 16:18
 * @since 1.0
 */
public class NullCheckDemo {
    public static void main(String[] args) {
        long count = Stream.of(3, 5L, 6, null)
                .filter(Objects::isNull)
                .count();
        System.out.println(count);
        List<String> collect = Stream.of("wangewi", "xiaoming")
                .filter(s -> !StringUtils.hasLength(s))
                .collect(Collectors.toList());
        if (collect.size() > 0) {
            return;
        }
    }
}
