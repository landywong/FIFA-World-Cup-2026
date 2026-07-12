public interface Scorer {
    // @author Landon Lwea
    // @version 1.0.0
    /**
     * Attempts a shot to opponent
     * @param shotName type of shot, displayed in announcement
     * @param opponent player that must defend against shot
     */
    /** @throws NoShotsRemainingException if this scorer has no shots left. */
    void attemptShot(String shotName, Player opponent) throws
            NoShotsRemainingException;

    /** How many shots this scorer has left. */
    int getRemainingShots();
}