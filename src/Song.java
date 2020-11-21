/*
JOSEPH TAMSEN
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

//Attributes of song
public class Song {
    private String title;
    private String artist;
    private String genre;
    //Constructor
    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }
    //Getters and Setters
    public String getTitle() {
        return this.title;
    }
    public String getArtist() {
        return this.artist;
    }
    public  String getGenre() {
        return this.genre;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

}
