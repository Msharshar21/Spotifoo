package spotifoov1;

public class SpotiView {
    public void displayMainMenu () {
        System.out.println("Main menu options:\n" +
                "[1] Songs\n" +
                "[2] Artists\n" +
                "[3] Albums\n" +
                "[4] Genres\n" +
                "[5] Search\n" +
                "[6] Exit\n" +
                "Choose an option and press enter:");
    }

    public void displaySearchMenu () {
        System.out.println("Main menu options:\n" +
                "[1] Songs\n" +
                "[2] Artists\n" +
                "[3] Albums\n" +
                "[4] Genres\n" +
                "Choose a search option and press enter:");
    }




    public void showErrorMsg () {
        System.out.println("Not Valid Option ");
    }

    public void errorForNotFoundFile (){
        System.out.println("The file is not found");
    }

    public void showErrorMsgForSong () {
        System.out.println("Error cannot play the song");
    }

}



