public abstract class Player {
    // @author Landon Lwea
    // @version 1.0.0
    protected String name;
    protected String country;
    protected int stamina;
    protected int shirtNumber;

    /** @throws IllegalArgumentException on a null/empty name, a null/empty
     * country, negative stamina, or a shirt number below 1. */
    // abstract class & method
    public Player(String name, String country, int stamina, int shirtNumber) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                    "Player name cannot be null or empty");
        }
        if (stamina < 0) {
            throw new IllegalArgumentException(
                    "Hit points cannot be negative: " + stamina);
        }
        if (shirtNumber < 1) {
            throw new IllegalArgumentException(
                    "Shirt number must be at least 1: " + shirtNumber);
        }

        this.name = name;
        this.country = country;
        this.shirtNumber = shirtNumber;
        this.stamina = stamina;
    }

    public String getName() {return this.name;}
    public String getCountry() {return this.country;}
    public int getStamina() {return this.stamina;}
    public int getShirtNumber() {return this.shirtNumber;}

    /** True while stamina is above zero. */
    public boolean isFit() {return this.stamina > 0;}

    /** Subtract stamina, never below zero, and announce the result.
    * @throws IllegalArgumentException if amount is negative. */
    public void consumeStamina(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Cannot consume negative stamina!: " + amount);
        }
        this.stamina -= amount;
        if (this.stamina < 0) {
            this.stamina = 0;
        }
        System.out.println("  " + this.name + " consumes " + amount
                + " stamina. (Stamina Remaining: " + this.stamina + ")");
        if (!this.isFit()) {
            System.out.println("  " + this.name
                    + " is tired. Player must be rested before returning!");
        }
    }

    /** Print a one-line summary of this player. */
    public void describe() {
        System.out.println(this.name
                + " (Country: " + this.country + ", Number " + this.shirtNumber + ")");
    }
    public void describe1() {
        System.out.println(this.name
                + " ("+ getClass().getSimpleName() + ")");
    }

    /** Every concrete subclass MUST supply a body. */
    public abstract void celebrate();
}