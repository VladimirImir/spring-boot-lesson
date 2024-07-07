package com.dev.sprinboot.lesson.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class ApplicationConfiguration {

    @PostConstruct
    public void init() {
        log.warn("app is loaded!!!");
    }
}
