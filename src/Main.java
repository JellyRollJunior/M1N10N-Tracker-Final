import java.util.ArrayList;

/*
    holds array of minions
    receives user input from interface and acts on array of minions accordingly
 */
public class Main {

    public static void main(String[] args) {
        // instantiate minion list
        ArrayList<Minion> minionList = new ArrayList<>();

        // test
        Minion zoe = new Minion("zoe", 20.0);
        minionList.add(zoe);
        System.out.println(minionList.get(0));

        // instantiate interface
        MinionTrackerInterface trackerInterface = new MinionTrackerInterface("minion Tracker");
        while (true) {
            // display interface to user
            trackerInterface.displayMenuTitle();
            trackerInterface.displayMenu();

            // collect user input
            int userInput = trackerInterface.getMenuInput();

            // main logic
            switch (userInput) {
                case 1 -> trackerInterface.displayMinions(minionList);
                case 2 -> {
                    Minion newMinion = trackerInterface.createMinion();
                    minionList.add(newMinion);
                }
                case 3 -> {
                    trackerInterface.displayMinions(minionList);
                    int deleteMinionIndex = trackerInterface.deleteMinion(minionList.size());
                    minionList.remove(deleteMinionIndex);
                }
                case 4 -> {
                    trackerInterface.displayMinions(minionList);
                    int evilDeedDoerIndex = trackerInterface.addEvilDeed(minionList.size());
                    minionList.get(evilDeedDoerIndex).performEvilDeed();
                }
                case 5 -> trackerInterface.debug(minionList);
                case 6 -> {
                    trackerInterface.exit();
                    System.exit(0);
                }
                default -> System.exit(0);
            }
        }
    }
}
