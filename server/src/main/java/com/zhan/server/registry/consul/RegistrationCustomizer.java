package com.zhan.server.registry.consul;

import com.zhan.server.registry.core.MetaCustomizer;
import com.zhan.server.registry.core.TagCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistrationCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Description 自定义Consul注册中心
 * @Author zhanzhan
 * @Date 2021/8/4 8:36
 */
@Component
public class RegistrationCustomizer implements ConsulRegistrationCustomizer {

    /**
     * 加了@Autowired注解了，就是说要放到Spring容器中去，这里跟一般的业务实现不一样。
     * <p>
     * 业务实现注入容器我们一般只需要在类上加入@Component、@Controller、@Service等注解就可以了，但是在框架层，扫描包的扫描路径跟业务代码包的
     * 扫描路径是不一样的，是作为一个依赖嵌入在业务代码里面的。所以采用@Configuration注解的方式注入
     */
//    @Autowired(required = false)
//    private List<MetaCustomizer> metaCustomizers = Collections.EMPTY_LIST;
//
//    @Autowired(required = false)
//    private List<TagCustomizer> tagCustomizers = Collections.EMPTY_LIST;

    private List<MetaCustomizer> metaCustomizers;
    private List<TagCustomizer> tagCustomizers;

    public RegistrationCustomizer(@Autowired(required = false) List<MetaCustomizer> metaCustomizers, @Autowired(required = false) List<TagCustomizer> tagCustomizers) {
        this.metaCustomizers = metaCustomizers;
        this.tagCustomizers = tagCustomizers;
    }

    @Override
    public void customize(ConsulRegistration registration) {
        // 先取出注册中心中已有的tag
        List<String> tags = registration.getService().getTags();
        if (tags == null) {
            tags = new ArrayList<>();
        }
        for (TagCustomizer tagCustomizer : tagCustomizers) {
            tags.addAll(tagCustomizer.customize());
        }
        // 将自定义的tag重新设置到注册中心
        registration.getService().setTags(tags);

        // 先取出注册中心中已有的meta
        Map<String, String> meta = registration.getService().getMeta();
        if (meta == null) {
            meta = new HashMap<>();
        }
        for (MetaCustomizer metaCustomizer : metaCustomizers) {
            meta.putAll(metaCustomizer.customize());
        }
        // 将自定义的meta重新设置到注册中心
        registration.getService().setMeta(meta);
    }
}
