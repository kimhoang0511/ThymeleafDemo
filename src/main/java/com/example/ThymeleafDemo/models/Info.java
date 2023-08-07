package com.example.ThymeleafDemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TẠo ra class này chỉ để lưu giữ thông tin
 */
@Data
@AllArgsConstructor
public class Info {
    private String key;
    private String value;
}