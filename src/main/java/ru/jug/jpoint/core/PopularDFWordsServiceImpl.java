package ru.jug.jpoint.core;

import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.spark.sql.functions.*;

/**
 * Created by Evegeny on 21/04/2016.
 */
@Service
public class PopularDFWordsServiceImpl implements PopularDFWordsService {

    @AutowiredBroadcast
    private Broadcast<UserConfig> userConfig;

    @Override
    public List<String> topX(DataFrame lines, int x) {
        DataFrame sorted = lines.withColumn("words", lower(column("words")))
                .filter(not(column("words").isin(userConfig.value().garbage.toArray())))
                .groupBy(column("words")).agg(count("words").as("count"))
                .sort(column("count").desc());
        sorted.show();
        Row[] rows = sorted.take(x);
        List<String> topX = new ArrayList<>();
        for (Row row : rows) {
            topX.add(row.getString(0));
        }
        return topX;
    }
}
