public class Goalkeeper extends Player implements Defender {
    // @author Landon Lwea
    // @version 1.0.0
    public static final int TACKLE_STAMINA_COST = 4;

    private boolean focused;

    // Inheritance Keeper from Player
    public Goalkeeper(String name, String country, int stamina, int shirtNumber){
        super(name, country, stamina, shirtNumber);
        this.focused = false;
    }

    public boolean isFocused() {return this.focused;}

    /** Focus. While focused, tackles cost the target double stamina. */
    public void focus() {this.focused = true;
        System.out.println(this.name
                + " becomes focused!");
    }

    @Override public void celebrate() {
        System.out.println(this.name + " pumps his fists in the air!");
    }
    @Override public void tackle(Player target) {
        System.out.println(this.name
                + " goes to tackle " + target.getName() + ".");
        if (this.focused) {
            target.consumeStamina(TACKLE_STAMINA_COST * 2);
        } else {
            target.consumeStamina(TACKLE_STAMINA_COST);
        }
    }
}
