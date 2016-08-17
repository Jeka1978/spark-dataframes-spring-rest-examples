package ru.jug.jpoint;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 20/04/2016.
 */
@Configuration
@ComponentScan(basePackages = "ru.jug.jpoint.core")
@PropertySource("classpath:user.properties")
public class AppConfig {


    @Bean
    public JavaSparkContext sc() {
        SparkConf conf = new SparkConf().setAppName("music analytst").setMaster("local[*]");
        return new JavaSparkContext(conf);
    }

    @Bean
    public SQLContext sqlContext(){
        return new SQLContext(sc());
    }


}
