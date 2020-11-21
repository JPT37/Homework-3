/*
JOSEPH TAMSEN
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

import java.util.Hashtable;

public class SongCollection {

    //Attributes
    private String name;
    private Hashtable<String, Song> songs;

    //Constructor
    public SongCollection(String name) {
        this.name = name;
        songs = new Hashtable<String, Song>();
    }

    //Getters and Setters
    public Hashtable getSongs() {
        return songs;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //methods for adding and printing songs after running code
    public Song lookUpSong(String title){
        return this.songs.get(title);
    }
    public void addSong (Song song){
        this.songs.put(song.getTitle(),song);
    }
    public void printSongs(){
        this.songs.forEach((title, song) -> {
            String artist=song.getArtist();
            String genre = song.getGenre();
            System.out.println("------------------");
            System.out.println(title.toUpperCase());
            System.out.println(artist);
            System.out.println(genre); });
    }
}
