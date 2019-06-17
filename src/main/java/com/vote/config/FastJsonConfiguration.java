package com.vote.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    // 配置fast json消息转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        // 创建消息转换器配置
        FastJsonConfig fastJsonConfig = converter.getFastJsonConfig();
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        converter.setSupportedMediaTypes(fastMediaTypes);
        converter.setFastJsonConfig(fastJsonConfig);
        // 将消息转换器配置到执行链
        converters.add(converter);
    }
}
