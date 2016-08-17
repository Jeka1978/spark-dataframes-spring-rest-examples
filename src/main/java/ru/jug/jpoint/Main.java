package ru.jug.jpoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.jug.jpoint.core.ArtistJudge;

import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 20/04/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ArtistJudge judge = context.getBean(ArtistJudge.class);
        List<String> topX = judge.topX("beatles", 10);
        System.out.println(topX);
        System.out.println("common ketty and britney" + judge.compare("britney", "ketty", 6));
    }
}
