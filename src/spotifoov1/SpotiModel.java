package spotifoov1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;



public class SpotiModel {
    SpotiView sptv = new SpotiView();
    ArrayList <Artist> listOfArtist = new ArrayList<>();


    public void loadFile() {
        try{
        File myfile = new File("./assets/data.txt");
        Scanner myReader = new Scanner(myfile);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String arr[] = data.split(",");
            Artist artist = new Artist(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
            listOfArtist.add(artist);

        }myReader.close();

        }catch (FileNotFoundException e) {
            sptv.errorForNotFoundFile();
        }

    }

    public ArrayList<Artist> listAllSongs () {
        return listOfArtist;
    }

    public ArrayList<Artist> listAllSongs (String filterText) {
        ArrayList <Artist> matchedResults = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getSongName().contains(filterText)){
                matchedResults.add(matchedValue);
            }
        }
        return matchedResults;
    }

    public ArrayList<Artist> listAllSongs (String albumName,String filterText) {
        ArrayList <Artist> matchedResults = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getSongName().contains(filterText)&& matchedValue.getAlbumName().equals(albumName) ){
                matchedResults.add(matchedValue);
            }
        }
        return matchedResults;
    }

    public ArrayList<Artist> listOfAllAlbums (String filterText) {
        ArrayList <Artist> matchedResults = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getAlbumName().contains(filterText))
            {
                boolean existed = false;
                for (int i = 0; i <matchedResults.size() ; i++) {
                    if (matchedValue.getAlbumName().equals(matchedResults.get(i).getAlbumName())) {
                        existed = true;
                        break;
                    }
                }
                if (!existed) {
                    matchedResults.add(matchedValue);
                }
            }
        }
        return matchedResults;
    }

    public ArrayList<Artist> listOfAllArtists (String filterText) {
        ArrayList <Artist> matchedResults = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getArtistName().contains(filterText))
            {
                boolean existed = false;
                for (int i = 0; i <matchedResults.size() ; i++) {
                    if (matchedValue.getArtistName().equals(matchedResults.get(i).getArtistName())) {
                        existed = true;
                        break;
                    }
                }
                if (!existed) {
                    matchedResults.add(matchedValue);
                }
            }
        }
        return matchedResults;
    }

    public ArrayList<Artist> listOfAllArtists () {
        ArrayList <Artist> matchedResults = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            boolean existed = false;
            for (int i = 0; i <matchedResults.size() ; i++) {
                if (matchedValue.getArtistName().equals(matchedResults.get(i).getArtistName())) {
                    existed = true;
                    break;
                }
            }
            if (!existed) {
                matchedResults.add(matchedValue);
            }
        }

        return matchedResults;
    }
    public ArrayList<Artist> listOfAllGenres () {
        ArrayList <Artist> matchedResults = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            boolean existed = false;
            for (int i = 0; i <matchedResults.size() ; i++) {
                if (matchedValue.getGenre().equals(matchedResults.get(i).getGenre())) {
                    existed = true;
                    break;
                }
            }
            if (!existed) {
                matchedResults.add(matchedValue);
            }
        }

        return matchedResults;
    }
    public ArrayList<Artist> listOfAllGenres (String filterText) {
        ArrayList <Artist> matchedResults = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getGenre().contains(filterText))
            {
                boolean existed = false;
                for (int i = 0; i <matchedResults.size() ; i++) {
                    if (matchedValue.getGenre().equals(matchedResults.get(i).getGenre())) {
                        existed = true;
                        break;
                    }
                }
                if (!existed) {
                    matchedResults.add(matchedValue);
                }
            }
        }
        return matchedResults;
    }


    public ArrayList<Artist> getListOfSongsByArtist (String artistmName) {
        ArrayList <Artist> allSongs = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getArtistName().equals(artistmName) ){
                allSongs.add(matchedValue);
            }
        }
        return allSongs;
    }
    public ArrayList<Artist> getListOfSongsByAlbum (String albumName) {
        ArrayList <Artist> allSongs = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getAlbumName().equals(albumName) ){
                allSongs.add(matchedValue);
            }
        }
        return allSongs;
    }
    public ArrayList<Artist> getListOfSongsByGenre (String genreName) {
        ArrayList <Artist> allSongs = new ArrayList<>();
        for (Artist matchedValue:listOfArtist) {
            if (matchedValue.getGenre().equals(genreName) ){
                allSongs.add(matchedValue);
            }
        }
        return allSongs;
    }
}