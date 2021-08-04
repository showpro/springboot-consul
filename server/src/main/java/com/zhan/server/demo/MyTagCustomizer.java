package com.zhan.server.demo;

import com.zhan.server.registry.core.TagCustomizer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Description 业务代码
 * @Author zhanzhan
 * @Date 2021/8/4 9:20
 */
@Component
public class MyTagCustomizer implements TagCustomizer {
    @Override
    public List<String> customize() {
        //自定义一个tag,名称为blue
        return Collections.singletonList("blue");
    }
}
