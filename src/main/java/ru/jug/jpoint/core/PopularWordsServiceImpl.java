package ru.jug.jpoint.core;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.List;

/**
 * Created by Evegeny on 20/04/2016.
 */
@Service
public class PopularWordsServiceImpl implements PopularWordsService {
    @AutowiredBroadcast
    private Broadcast<UserConfig> userConfig;

    @Override
    public List<String> topX(JavaRDD<String> lines, int x) {
        return lines.map(String::toLowerCase)
                .flatMap(WordsUtil::getWords)
                .filter(w -> !userConfig.value().garbage.contains(w))
                .mapToPair(w -> new Tuple2<>(w, 1))
                .reduceByKey((a, b) -> a + b)
                .mapToPair(Tuple2::swap).sortByKey(false).map(Tuple2::_2).take(x);
    }
}
