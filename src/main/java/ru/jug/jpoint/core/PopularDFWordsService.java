package ru.jug.jpoint.core;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.DataFrame;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 20/04/2016.
 */
public interface PopularDFWordsService extends Serializable{
    List<String> topX(DataFrame lines, int x);
}
