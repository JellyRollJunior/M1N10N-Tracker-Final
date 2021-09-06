import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
    menu text + response text
 */
public class MinionTrackerInterface {
    private String menuTitle;
    private String[] menuOptions;
    private String[] menuResponses;


    public MinionTrackerInterface(String menuTitle) {
        this.menuTitle = menuTitle;
        menuOptions = new String[6];
        instantiateMenuOptions(menuOptions);

        menuResponses = new String[10];
        instantiateMenuResponses(menuResponses);
    }

    public MinionTrackerInterface() {
        this("Minion Tracker");
    }

    private void instantiateMenuOptions(String[] menuOptions) {
        menuOptions[0] = "List minions";
        menuOptions[1] = "Add a new minion";
        menuOptions[2] = "Remove minion";
        menuOptions[3] = "Attribute evil deed to a minion";
        menuOptions[4] = "Debug";
        menuOptions[5] = "exit";
    }

    private void instantiateMenuResponses(String[] menuResponses) {
        menuResponses[0] = "Your minions: ";
        menuResponses[1] = "Please enter new minion name: ";
        menuResponses[2] = "Please enter new minion height: ";
        menuResponses[3] = " added to your list of minions";
        menuResponses[4] = "Which minion would you like to release? ";
        menuResponses[5] = " has been released";
        menuResponses[6] = "Who performed an evil deed? ";
        menuResponses[7] = "'s evil deed has been recorded";
        menuResponses[8] = "Goodbye!";
        menuResponses[9] = "Enter a number corresponding to which task you would like performed: ";
    }

    public void displayMenuTitle() {
        encapsulateTitleWithStars();
    }

    public void encapsulateTitleWithStars(){
        printStarRows();
        System.out.println("* " + menuTitle + " *");
        printStarRows();
    }

    public void printStarRows() {
        int titleLength = menuTitle.length();
        for (int i = 0; i < titleLength; i++) {
            System.out.print("*");
        }
        System.out.println("****");     // rectangle buffer
    }

    public void displayMenu() {
        int menuIndex = 1;
        for (String option : menuOptions) {
            System.out.println( "" + menuIndex + ". " + option);
            menuIndex++;
        }
        System.out.print( menuResponses[9] );
    }

    public int getMenuInput() {
        return getUserInput(menuOptions.length);
    }

    public void displayMinions(ArrayList<Minion> minionList) {
        System.out.println(menuResponses[0]);
        int menuIndex = 1;
        for (Minion minion : minionList) {
            System.out.println("" + menuIndex + ". " + minion);
            menuIndex++;
        }
    }

    public Minion createMinion() {
        Scanner minionScanner = new Scanner(System.in);

        System.out.print(menuResponses[1]);
        String name = minionScanner.nextLine();

        Double height;
        System.out.print(menuResponses[2]);
        while (true) {
            try {
                height = minionScanner.nextDouble();
                break;
            } catch (InputMismatchException exception) {
                minionScanner.next();
                System.out.print("Invalid input, please enter a double: ");
            }
        }
        Minion returnMinion = new Minion(name, height);
        System.out.println(returnMinion + menuResponses[3]);
        return returnMinion;
    }

    private int getUserInput(int maxIndex) {
        Scanner minionScanner = new Scanner(System.in);
        int userInput;
        while (true) {
            try {
                userInput = minionScanner.nextInt();

                // if input out of range, retry
                if (userInput < 1
                        | userInput > maxIndex) {
                    System.out.print("Invalid input, please try again: ");
                    continue;
                }
                break;
            } catch (InputMismatchException exception) {
                minionScanner.next();
                System.out.print("Invalid input, please enter an int: ");
            }
        }
        return userInput;
    }

    public int deleteMinion(int minionListSize) {
        System.out.print(menuResponses[4]);
        int deleteMinionIndex = getUserInput(minionListSize);

        System.out.println("Minion " + deleteMinionIndex + menuResponses[5]);
        deleteMinionIndex--;
        return deleteMinionIndex;
    }

    public int addEvilDeed(int minionListSize) {
        System.out.print(menuResponses[6]);
        int evilDeedDoer = getUserInput(minionListSize);

        System.out.println("Minion" + evilDeedDoer + menuResponses[7]);
        int evilDeedDoerIndex = evilDeedDoer - 1;
        return evilDeedDoerIndex;
    }

    public void debug(ArrayList<Minion> minionList) {
        for (Minion minion : minionList) {
            System.out.println(minion);
        }
    }

    public void exit() {
        System.out.println(menuResponses[8]);
    }
}

