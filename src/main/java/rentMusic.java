

public class rentMusic {
private String storeName;
private final String[] musicTitles = {"It's Five O'Clock Somewhere", "I Get Around", "Rubber Band Man", "Ventura " +
        "Highway",
        "Keep " +
            "On" +
        " Loving you"};
private final String[] musticArtist = {"Alan Jackson, Jimmy Buffet", "Beach Boys", "The Spinners", "America", "REO " +
        "Speedwagon"};
 private int[] musicRents = {0, 0, 0, 1, 0};

    public rentMusic(String name){
    storeName = name;
    }

    public void displayAllSongs(){
        System.out.println("Here are the songs:\n");
        for(int i = 0; i < musicTitles.length; i++){
            System.out.println(musicTitles[i]+" by " + musticArtist[i]);
        }
        System.out.println();
    }

    public String selectSong(int trackNum){
        if(!(isRented(trackNum))){
            musicRents[trackNum] = 1;
            return musicTitles[trackNum] + " by " + musticArtist[trackNum];
        }else{
            return "Sorry,that song is currently rented. Returning to home page";
        }

    }

    public String showSong(int trackNum){
        return musicTitles[trackNum] + " by " + musticArtist[trackNum];
    }
    public void displaySongSelections(){
        for(int i = 0; i < musicTitles.length; i++){
            if(isRented(i)){
                System.out.println((i+1)+". "+musicTitles[i] + " by " + musticArtist[i]+"(RENTED)");
            }else{
                System.out.println((i+1)+". "+musicTitles[i] + " by " + musticArtist[i]+"(Available)");
            }
        }
        System.out.println();
    }

    public boolean isRented(int trackNum){
        if(musicRents[trackNum] == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "Welcome to " + storeName + "! We have a selection of 5 different records with more on the way!\n " +
                "Where would you like to go?";
    }
}
