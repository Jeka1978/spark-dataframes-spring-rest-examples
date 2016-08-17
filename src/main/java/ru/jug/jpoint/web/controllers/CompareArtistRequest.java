package ru.jug.jpoint.web.controllers;

/**
 * Created by Evegeny on 21/04/2016.
 */
public class CompareArtistRequest {
    private String artist1;
    private String artist2;
    private int x;

    public String getArtist1() {
        return artist1;
    }

    public void setArtist1(String artist1) {
        this.artist1 = artist1;
    }

    public String getArtist2() {
        return artist2;
    }

    public void setArtist2(String artist2) {
        this.artist2 = artist2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
