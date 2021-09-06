
/*
    Minion class which holds data on each minion
 */
public class Minion {
    private String name;
    private Double height;
    private int evilDeedsPerformed = 0;

    public Minion(String name, Double height) {
       this.name = name;
       this.height = height;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public int getEvilDeedsPerformed() {
        return evilDeedsPerformed;
    }

    public void performEvilDeed() {
        evilDeedsPerformed++;
    }

    @Override
    public String toString() {
        return "name: " + getName()
                + ", height: " + getHeight()
                + ", evil deeds performed: " + getEvilDeedsPerformed();
    }
}
