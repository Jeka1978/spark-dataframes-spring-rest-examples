package ru.jug.jpoint.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.jug.jpoint.core.ArtistJudge;

import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 21/04/2016.
 */
@RestController
@RequestMapping("/music")
public class MusicJudgeController {

    @Autowired
    private ArtistJudge artistJudge;

    @RequestMapping("/topX/{artist}/{x}")
    public String topX(@PathVariable("artist") String artist, @PathVariable("x") int x) {
        List<String> topX = artistJudge.topX(artist, x);
        return artist+" top " +x+" words: "+topX.toString();
    }

    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    public String compare(CompareArtistRequest compareArtistRequest) {
        String artist1 = compareArtistRequest.getArtist1();
        String artist2 = compareArtistRequest.getArtist2();
        int commonWords = artistJudge.compare(artist1, artist2, compareArtistRequest.getX());
        return artist1 + " and " + artist2 + " have " + commonWords + " common words";

    }

}





