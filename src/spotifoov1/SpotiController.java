package spotifoov1;


import java.util.ArrayList;
import java.util.Scanner;

public class SpotiController {
    public static Scanner sc = new Scanner (System.in);
    SpotiView spv = new SpotiView();
    SpotiModel sptM = new SpotiModel();

    public SpotiController() {
        sptM.loadFile();
    }

    public void choiceFromMenu ()  {
        while (true) {
            spv.displayMainMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    selectSong();
                    break;
                }
                case 2: {
                    selectArtist();
                    break;
                }
                case 3: {
                    selectAlbum();
                }
                case 4: {
                    selectGenre();
                    break;
                }
                case 5: {
                    try {
                        System.out.println("Please enter the song you want to search ");
                        String input = sc.next();
                        ArrayList<Artist> searchedList = sptM.listAllSongs(input);


                        for (int i = 1; i <= searchedList.size(); i++) {
                            System.out.println("[" + (i) + "] " + searchedList.get(i - 1).getSongName());

                        }
                        System.out.println("Choose song of the songs you want :");
                        choice = sc.nextInt();
                        searchedList.get(choice - 1).playSong();
                    }catch (Exception e) {
                        System.out.println("Enter valid input !!");
                    }
                        break;

                    }
                case 6: {
                    System.out.println("Closing the app");
                    return;
                }
                default: {
                    System.out.println("Please enter valid number");
                }

            }
        }
    }
    private void selectSong () {
        ArrayList <Artist> allSongs = sptM.listAllSongs();

        for (int i = 1; i <= allSongs.size() ; i++) {
            System.out.println("["+(i) +"] " + allSongs.get(i-1).getSongName());

        }
        System.out.println("Choose song of the songs you want :");
        int choice = sc.nextInt();
        allSongs.get(choice - 1).playSong();
    }

    private void selectArtist () {
        ArrayList <Artist> allArtist = sptM.listOfAllArtists();

        for (int i = 1; i <= allArtist.size() ; i++) {
            System.out.println("["+(i) +"] " + allArtist.get(i-1).getArtistName());

        }
        System.out.println("Please Choose Artist you want :");
        int choice = sc.nextInt();

        ArrayList <Artist> allSongs  =  sptM.getListOfSongsByArtist(allArtist.get(choice-1).getArtistName());
        for (int i = 1; i <= allSongs.size() ; i++) {
            System.out.println("["+(i) +"] " + allSongs.get(i-1).getSongName());

        }
        System.out.println("Choose song of the songs you want :");
        choice = sc.nextInt();
        allSongs.get(choice - 1).playSong();
    }
    private void selectAlbum () {
        ArrayList <Artist> allAlbum = sptM.listOfAllArtists();

        for (int i = 1; i <= allAlbum.size() ; i++) {
            System.out.println("["+(i) +"] " + allAlbum.get(i-1).getAlbumName());

        }
        System.out.println("Please Choose Album you want :");
        int choice = sc.nextInt();

        ArrayList <Artist> allSongs  =  sptM.getListOfSongsByAlbum(allAlbum.get(choice-1).getAlbumName());
        for (int i = 1; i <= allSongs.size() ; i++) {
            System.out.println("["+(i) +"] " + allSongs.get(i-1).getSongName());

        }
        System.out.println("Choose song of the songs you want :");
        choice = sc.nextInt();
        allSongs.get(choice - 1).playSong();
    }
    private void selectGenre () {
        ArrayList <Artist> allGenres = sptM.listOfAllGenres();

        for (int i = 1; i <= allGenres.size() ; i++) {
            System.out.println("["+(i) +"] " + allGenres.get(i-1).getGenre());

        }
        System.out.println("Please Choose Genre you want :");
        int choice = sc.nextInt();

        ArrayList <Artist> allSongs  =  sptM.getListOfSongsByGenre(allGenres.get(choice-1).getGenre());
        for (int i = 1; i <= allSongs.size() ; i++) {
            System.out.println("["+(i) +"] " + allSongs.get(i-1).getSongName());

        }
        System.out.println("Choose song of the songs you want :");
        choice = sc.nextInt();
        allSongs.get(choice - 1).playSong();
    }
}

