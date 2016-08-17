package ru.jug.jpoint.core;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.jug.jpoint.AppConfig;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 20/04/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class PopularWordsServiceImplTest {
    @Autowired
    PopularWordsService popularWordsService;

    @Autowired
    JavaSparkContext sc;

    @Test
    public void testTopX() throws Exception {
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("java java java but scala groovy groovy"));
        List<String> top = popularWordsService.topX(rdd, 1);
        Assert.assertEquals("java",top.get(0));
    }
}