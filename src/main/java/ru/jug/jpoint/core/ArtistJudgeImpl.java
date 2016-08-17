package ru.jug.jpoint.core;

import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Evegeny on 20/04/2016.
 */
@Service
public class ArtistJudgeImpl implements ArtistJudge {

    @Autowired
    private PopularDFWordsService popularDFWordsService;

    @Autowired
    private WordDataFrameCreator wordDataFrameCreator;

    @Value("${path2Dir}")
    private String path;

    @Override
    public List<String> topX(String artist, int x) {
        DataFrame dataFrame = wordDataFrameCreator.create(path + "data/songs/" + artist + "/*");
        System.out.println(artist);
        return popularDFWordsService.topX(dataFrame, x);
    }

    @Override
    public int compare(String artist1, String artist2, int x) {
        List<String> artist1Words = topX(artist1, x);
        List<String> artist2Words = topX(artist2, x);
        int size = artist1Words.size();
        artist1Words.removeAll(artist2Words);
        return size - artist1Words.size();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Вронский", null, "Анна");
        Comparator<String> cmp = Comparator.nullsLast(Comparator.naturalOrder());

        System.out.println(Collections.max(list, cmp));
      /*  System.out.println(list.stream().collect(Collectors.maxBy(cmp)).get());
        System.out.println(list.stream().max(cmp).get());
*/
    }




}
