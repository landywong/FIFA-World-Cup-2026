public class Striker extends Player implements Scorer {
    // @author Landon Lwea
    // @version 1.0.0
    public static final int SHOT_STAMINA_COST = 6;

    private int shotsRemaining;

    /** @throws IllegalArgumentException if shotsRemaining is negative. */
    // Inheritance Striker from Player
    public Striker(String name, String country, int stamina,
                   int shirtNumber, int shotsRemaining) {
        super(name, country, stamina, shirtNumber);
        if (shotsRemaining < 0) {
            throw new IllegalArgumentException(
                    "A striker cannot start with negative shot attempts: " + shotsRemaining);
        }
        this.shotsRemaining = shotsRemaining;
    }

    @Override public int getRemainingShots(){return this.shotsRemaining;}
    @Override public void celebrate(){ System.out.println("SUIIIIIIIIIIIIII!!!");}
    @Override public void attemptShot(String shotName, Player opponent)
            throws NoShotsRemainingException {
        if (this.shotsRemaining <= 0) {
            throw new NoShotsRemainingException(
                    this.name + " is out of shot attempts and cannot shoot "
                            + shotName + ".");
        }
        this.shotsRemaining--;
        System.out.println(this.name + " shots a " + shotName
                + " on " + opponent.getName() + "!");
        opponent.consumeStamina(SHOT_STAMINA_COST);
    }
}
