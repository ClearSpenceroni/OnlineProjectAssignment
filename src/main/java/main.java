import java.util.Scanner;

public class main {
    //Objects
    static Scanner input = new Scanner(System.in);
    static RentMusic myStore = new RentMusic("Ridiculous Records");

    //Primitives
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

    /**
     * Method that rents the music
     */
    public static void rentMusic(){
        boolean isConfirmed = false;
        boolean sentinel = false;
        String userLoop;
       do {
           do {
               System.out.println("Here are the song options\n");
               myStore.displaySongSelections();
               System.out.print("Choose a song: ");
               userSelection = input.nextInt();
               userSelection -= 1;

               if (!myStore.isRented(userSelection)) {
                   input.nextLine();
                   System.out.println("Please type CONFIRM to confirm this song or type CANCEL to go back");
                   String userConfirmation = input.nextLine();
                   if (userConfirmation.equalsIgnoreCase("CONFIRM")) {
                       myStore.selectSong(userSelection);
                       isConfirmed = true;
                       System.out.println("You have just rented " + myStore.showSong(userSelection));
                   } else if(userConfirmation.equalsIgnoreCase("cancel")){
                       break;
                   }
               } else {
                   System.out.println("\n" + myStore.selectSong(userSelection) + "\n");
               }
           }while(!isConfirmed);
           System.out.println("Would you like to rent another song?(YES or NO): ");
           userLoop = input.nextLine();
           if(userLoop.equalsIgnoreCase("yes")) {
               sentinel = true;
           }else{
               sentinel = false;
           }
       }while(sentinel);
    }
    }


