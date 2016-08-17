package ru.jug.jpoint.web;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.jug.jpoint.AppConfig;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 21/04/2016.
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"ru.jug.jpoint.web.controllers","ru.jug.jpoint.aop"})
public class WebConfig {
    @PostConstruct
    public void init(){
        System.out.println("********************************************WEB CONFIG*********************");
    }
}
