package com.zhan.server.registry.core;

import java.util.Map;

/**
 * @Description 自定义元数据
 * @Author zhanzhan
 * @Date 2021/8/4 8:30
 */
public interface MetaCustomizer {

    Map<String, String> customize();
}
