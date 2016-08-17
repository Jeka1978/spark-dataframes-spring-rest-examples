package ru.jug.jpoint.core;

import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 20/04/2016.
 */
public interface ArtistJudge {
    List<String> topX(String artist, int x);

    int compare(String artist1, String artist2, int x);
}
