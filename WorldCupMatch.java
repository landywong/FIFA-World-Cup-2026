import java.util.*;

public class WorldCupMatch {
    public static void main(String[] args) {
        // @author Landon Lwea
        // @version 1.0.0
        // WorldCupMatch.java
//
// ===== DESIGN RECIPE =====
//
// Step 0 - Understand and restate the problem.
// This program is a simple simulation of the FIFA World Cup 2026.
// Featuring 3 players demonstrating keeper, striker, midfielder
//
// Step 1 - Data definitions.
// Input: a hard-coded roster of three Players (a Striker, a Goalkeeper,
// and a Midfielder), each with a name (String), a country (String),
// stamina (int), and a shirt number (int).
// Output: Describes the 3 players including their country and shirt number
//
// Step 2 - Method signatures and purpose statements.
// public static void main(String[] args)
// main demonstates the functions to simulate FIFA World Cup 2026
//
// Step 3 - Examples and tests.
// List at least three cases, including edge cases. For example:
// striker.attemptShot(...) with 3 shots left -> prints the shot, keeper loses 6
// striker.attemptShot(...) with 0 shots left -> throws NoShotsRemainingException
// new Striker("", "Brazil", 10, 9, 1) -> throws IllegalArgumentException
// goalkeeper.consumeStamina(-5) -> throws IllegalArgumentException
//
// Step 4 - Skeleton / template.
/**
 * 1. roll call
 * 2. celbrations
 * 3. keeper focuses and tackles
 * 4. striker shoots
 * 5. midfielder does both
 * 6. the squad through two lenses
 * 7. bad inputs are rejected
 * 8. final whistle
 */
//
// Step 5 - Implementation, testing, refinement.
// Created secondary describe method

        System.out.println("==============================================");
        System.out.println("  World Cup Match -- FIFA 2026");
        System.out.println("==============================================");

        // -------- 1) Roll call ------------------------------------------
        System.out.println();
        System.out.println("=== Roll Call ===");

        Striker    alex = new Striker   ("Alex Ramos", "Brazil", 30, 9, 3);
        Goalkeeper kofi     = new Goalkeeper("Kofi Mensah",     "Ghana", 45, 1);
        Midfielder lena    = new Midfielder     ("Lena Fischer",          "Germany", 35, 8, 2, 4);

        // The array's static type is Adventurer[]; each slot holds a
        // different concrete subclass. This is upcasting in action.
       Player[] party = { alex, kofi, lena };

        for (Player a : party) {
            a.describe();   // inherited concrete method
        }

        // -------- 2) Celebrations ----------------------------------------
        System.out.println();
        System.out.println("=== Celebrations ===");

        for (Player a : party) {
            a.celebrate();
        }

        // -------- 3) The keeper focuses and tackles -----------------------
        System.out.println();
        System.out.println("=== The Keeper Focuses ===");

        System.out.println(kofi.getName() + " focused? " + kofi.isFocused());
        kofi.focus();
        System.out.println(kofi.getName() + " focused? " + kofi.isFocused());
        kofi.tackle(alex); // focused tackle costs the target double stamina

        // -------- 4) The striker shoots ------------------------------------
        System.out.println();
        System.out.println("=== The Striker Shoots ===");

        String[] strikerShots = {"Volley", "Header", "Bicycle Kick", "Knuckle Ball"};
        try {
            for (String shotName : strikerShots) {
                alex.attemptShot(shotName, kofi);
            }
        } catch (NoShotsRemainingException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println(alex.getName() + "'s remaining shots: "
                    + alex.getRemainingShots());
        }

        // -------- 5) The midfielder does both -------------------------------
        System.out.println();
        System.out.println("=== The Midfielder Does Both ===");

        String[] midShots = {"Curler", "Long Shot", "Free Kick"};
        try {
            for (String shotName : midShots) {
                lena.attemptShot(shotName, kofi);
            }
        } catch (NoShotsRemainingException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        lena.tackle(alex);

        // -------- 6) The squad through two lenses -----------------------------
        System.out.println();
        System.out.println("=== The Squad Through Two Lenses ===");

        System.out.println("Scorers on the pitch:");
        for (Player p : party) {
            if (p instanceof Scorer) {
                Scorer s = (Scorer) p;
                System.out.println("  " + p.getName()
                        + " (shots remaining: " + s.getRemainingShots() + ")");
            }
        }
        System.out.println("Defenders on the pitch:");
        for (Player p : party) {
            if (p instanceof Defender) {
                System.out.println("  " + p.getName());
            }
        }

        // -------- 7) Bad input is rejected --------------------------------------
        System.out.println();
        System.out.println("=== Bad Input Is Rejected ===");

        try {
            Striker badStriker = new Striker("", "Brazil", 10, 9, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            kofi.consumeStamina(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // -------- 8) Final whistle ----------------------------------------------
        System.out.println();
        System.out.println("=== Final Whistle ===");

        for (Player p : party) {
            p.describe1();
            System.out.println("  Final stamina: " + p.getStamina());
            if (p instanceof Scorer) {
                System.out.println("  Final shots remaining: "
                        + ((Scorer) p).getRemainingShots());
            }
        }
    }
}
