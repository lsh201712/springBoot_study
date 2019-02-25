package com.sky.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 通过SimpleMappingExceptionResolver做全局异常处理
 */
@Configuration
public class GlobalException {

    /**
     * 该方法必须要有返回值。返回值类型必须是:SimpleMappingExceptionResolver
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mappings =  new Properties();
        /**
         * 参数一:异常的类型，注意必须是异常类型的全名、
         * 参数二:视图名称
         */
        mappings.put("java.lang.ArithmeticException","error1");
        mappings.put("java.lang.NullPointerException","error2");

        //设置异常与视图映射信息
        resolver.setExceptionMappings(mappings);
        return  resolver;
    }

}
