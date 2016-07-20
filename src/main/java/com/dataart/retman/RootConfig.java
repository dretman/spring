package com.dataart.retman;

import com.dataart.retman.repository.SpitterRepository;
import com.dataart.retman.repository.SpittleRepository;
import com.dataart.retman.repository.impl.SpitterRepositoryImpl;
import com.dataart.retman.repository.impl.SpittleRepositoryImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.dataart.retman", excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

    @Bean
    public SpittleRepository spittleRepository() {
        return new SpittleRepositoryImpl();
    }

    @Bean
    public SpitterRepository spitterRepository() {
        return new SpitterRepositoryImpl();
    }

    @Bean
    public MessageSource messageSource() {
//        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("file:///D:/PROJECTS/SPRING/messages");
        source.setCacheSeconds(1);
        return source;
    }

}
