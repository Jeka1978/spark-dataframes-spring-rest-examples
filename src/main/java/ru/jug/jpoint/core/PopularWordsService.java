package ru.jug.jpoint.core;

import org.apache.spark.api.java.JavaRDD;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Evegeny on 20/04/2016.
 */
public interface PopularWordsService extends Serializable{
    List<String> topX(JavaRDD<String> lines, int x);
}
