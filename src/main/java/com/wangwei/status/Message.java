package com.wangwei.status;

import lombok.Data;

/**
 * @Autor wangwei
 * @Data 2021/5/24 18:04
 */
@Data
public class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }
}
