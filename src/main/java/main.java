import java.util.Scanner;

public class main {
    static Scanner input = new Scanner(System.in);
    static rentMusic myStore = new rentMusic("Ridiculous Records");
    static int userChoice;
    static int userSelection;

    public static void main(String args[]) {
        do {
            System.out.println(myStore.toString());
            System.out.print("0. To Quit\n1. Display Music\n2. Rent Music\nType here: ");
             userChoice = input.nextInt();
            System.out.println();
            switch (userChoice) {
                case 1:
                    myStore.displayAllSongs(); break;
                case 2: rentMusic(); break;
            }
        } while (userChoice != 0);
        System.out.println("Farewell! Come back soon!");
    }

    public static void rentMusic(){
        System.out.println("Here are the song options\n");
        myStore.displaySongSelections();
        System.out.print("Choose a song: ");
        userSelection = input.nextInt();
        userSelection -= 1;

        if(!myStore.isRented(userSelection)){
            input.nextLine();
            System.out.println("Please type CONFIRM to confirm this song");
            String userConfirmation = input.nextLine();
            if(userConfirmation.equals("CONFIRM")){
                myStore.selectSong(userSelection);
                System.out.println("You have just rented " + myStore.showSong(userSelection));
            }
        }else{
            System.out.println("\n"+myStore.selectSong(userSelection)+"\n");
        }
    }
    }


