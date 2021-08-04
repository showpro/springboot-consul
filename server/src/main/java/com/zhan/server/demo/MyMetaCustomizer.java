package com.zhan.server.demo;

import com.zhan.server.registry.core.MetaCustomizer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @Description
 * @Author zhanzhan
 * @Date 2021/8/4 9:30
 */
@Component
public class MyMetaCustomizer implements MetaCustomizer {
    @Override
    public Map<String, String> customize() {
        // 自定义的元数据
        return Collections.singletonMap("cluster", "blue");
    }
}
