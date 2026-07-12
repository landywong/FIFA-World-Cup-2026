public class Midfielder extends Player implements Scorer, Defender {
    // @author Landon Lwea
    // @version 1.0.0
    /**
     * bad
     */
    public static final int SHOT_STAMINA_COST = 3;
    public static final int TACKLE_STAMINA_COST = 2;

    private int shotsRemaining;
    private int assists;

    /** @throws IllegalArgumentException if shotsRemaining or assists is negative. */
    // Inheritance Midfielder from Player
    public Midfielder(String name, String country, int stamina,
                      int shirtNumber, int shotsRemaining, int assists) {
        super(name, country, stamina, shirtNumber);
        if (shotsRemaining < 0 || assists < 0) {
            throw new IllegalArgumentException(
                    "A midfielders shot attempts and assists must be non-negative.");
        }
        this.shotsRemaining  = shotsRemaining;
        this.assists = assists;
    }

    public int getAssists(){return this.assists;}

    @Override public int getRemainingShots(){return this.shotsRemaining;}
    @Override public void celebrate() {System.out.println("GOAL GOAL GOALLLLLLLLL!!!!");}
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
    @Override public void tackle(Player target) {
        System.out.println(this.name
                + " goes to tackle " + target.getName() + ".");
            target.consumeStamina(TACKLE_STAMINA_COST);
    }
}
