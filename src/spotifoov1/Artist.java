package spotifoov1;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Artist {
    private String songName;
    private String artistName;
    private String albumName;
    private String genre;
    private String filePath ;
    private String albumImage ;
    private String noPicture ;
    //private ArrayList <String> data =new ArrayList<>();

    public Artist() {
    }

    public Artist(String songName, String artistName, String albumName, String genre, String filePath, String albumImage) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.genre = genre;
        this.filePath = filePath;
        this.albumImage = albumImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilePath() {
        return "./assets/songs/" + filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAlbumImage() {
        return "./assets/albums/" + albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public String getNoPicture() {
        return "./assets/no-picture.png";
    }



    public void playSong ()  {
        SpotiView sptV = new SpotiView();
        try{
            Desktop d = Desktop.getDesktop();
            File f = new File(this.getFilePath());
           // System.out.println(f.exists());
            if (getFilePath().contains(".mp3") && f.exists() && !getFilePath().contains("no file")){
                d.open(f);
                if (getAlbumImage().contains("no file")){
                    d.open(new File(getNoPicture()));
                }else{
                    File f1 =new File(getAlbumImage());
                    if (f1.exists())
                        d.open(new File(getAlbumImage()));
                    else
                        d.open(new File(getNoPicture()));

                }
            }else{
                System.out.println("There's no File");
                return;
            }
          //  System.out.println("Song file path " + this.getFilePath());
            //d.open(new File(getAlbumImage()));
        }catch (Exception ex) {
            System.out.println("Error File is not found ");
        }
    }

}
