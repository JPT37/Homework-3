/*
JOSEPH TAMSEN
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;

public class Library {

    //Attributes
    private String ownerName;
    private SongCollection home;
    private Hashtable<String, Playlist> playlists;


    //Constructor
    public Library(String ownerName) {
        this.ownerName = ownerName;
        this.home = new SongCollection("home");
        this.playlists = new Hashtable<String, Playlist>();
    }

    //Getters
    public String getOwnerName(){
        return ownerName;
    }
    public Hashtable getPlaylists() {
        return playlists;
    }
    public SongCollection getHome() {
        return home;
    }

    //Methods for adding, creating, and uploading demo songs
    public void addPlaylist (Playlist playlist){
        this.playlists.put(playlist.getName(), playlist);

        playlist.getSongs().forEach((title, song) -> {
            this.home.addSong((Song) song);
        });
    }
    public Playlist createPlaylist (Scanner input) {
        System.out.println("Name of Playlist: ");
        String name = input.nextLine();
        System.out.println("Description of Playlist: ");
        String description = input.nextLine();
        Playlist playlist = new Playlist(name, description);
        char addAnother = 'n';
        do {
            System.out.println("Adding" + name + "to the playlist.");
            String title, artist, genre;
            System.out.print("Name of Song: ");
            title = input.nextLine();
            System.out.print("Artist Name: ");
            artist = input.nextLine();
            System.out.print("Genre: ");
            genre = input.nextLine();
            playlist.addSong(new Song(title, artist, genre));
            System.out.println("Want to add another song? (Y/N) ");
            addAnother = input.nextLine().charAt(0);
        }
        while (Character.toLowerCase(addAnother) == 'y');
        return playlist;
    }
    public void uploadDemoSongs () {
        Path file = Paths.get("./demo_songs.txt");
        InputStream input = null;
        try {
            input = newInputStream(file);
            BufferedReader reader = new BufferedReader (new InputStreamReader(input));
            String s = null;
            String[] songDetail;

            while ((s=reader.readLine()) != null) {
                songDetail = s.split(",");
                System.out.println(Arrays.toString(songDetail));

                String title;
                title = songDetail[0];
                String artist;
                artist = songDetail[1];
                String genre;
                genre = songDetail[2];

                Song song = new Song(title, artist, genre);
                this.home.addSong(song);

            }input.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
    public void printLibrary() {
        System.out.println("Library Owner: " + ownerName);
        System.out.println("Songs in your Library: ");
        this.home.printSongs();
        this.playlists.forEach((name, playlist) -> {
            System.out.println();
            System.out.println("The playlist " + playlist.getName() + "on spotify");
            System.out.println(playlist.getName() + "'s description: " + playlist.getDescription());
            System.out.println("----------------");
            playlist.printSongs();
        });
    }
}
