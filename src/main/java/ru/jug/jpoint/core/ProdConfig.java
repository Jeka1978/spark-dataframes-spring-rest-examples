package ru.jug.jpoint.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 21/04/2016.
 */
@PropertySource("classpath:prod.properties")
@Configuration
//@Profile("PROD")
public class ProdConfig {
}
