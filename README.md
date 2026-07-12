# World Cup 2026 Match Simulator

> **HOW TO USE THIS TEMPLATE**
>
> 1. Copy this file into your project folder and rename it to exactly `README.md`.
> 2. Fill in **every** section below.
> 3. Replace every `<placeholder in angle brackets>` with your own words, and **delete the angle brackets**.
> 4. Delete this instruction block, and delete every `> NOTE:` line once you have acted on it.
>
> A `README.md` that still contains `<placeholders>` or these notes is an unfinished `README.md`, and your peer reviewers are told to score it as such under *Documentation*.
>
> Write for a **stranger** who has never seen the assignment. If they cannot compile and run your program using only this file, it is not done.

---

**Author:** `Landon Lwea`
**Course:** ITSC 1213, Summer 2026
**Date:** `2026-07-09`

---

## 1. Overview

`
This program simulates a simplifed version of a single scene from FIFA World Cup 2026. 
Including in this program is abstract classes, interfaces, and exceptions. 
Features Strikers who score, Goalkeeps who tackle, and Midfielders who do both!`

---

## 2. Objectives

This project demonstrates the following Java concepts. For each one, name the **file** and the **line or method** where a reader can see it.

| Concept | Where to see it               |
|---|-------------------------------|
| Abstract class | `<Player.java, Line 1`        |
| Abstract method | `<Player.celebrate(), Line 29>` |
| Inheritance (`extends`, `super`) | `Striker.java extends from Player.java` |
| Method overriding (`@Override`) | `@Override in striker celebrate()` |
| Interface declaration | `Scorer.java and Defender.java` |
| One class implementing two interfaces | `Midfielder.java>`            |
| Custom **checked** exception | `NoShotsRemainingException.java` |
| **Unchecked** exception for bad input | `Player constructor and Player.consumeStamina` |
| `try` / `catch` / `finally` | `WorldCupMatch.main, Scene 4` |
| Polymorphism through an array | `WorldCupMatch.main — the Player[] squad loop` |
| `instanceof` guarding a downcast | `e.g. WorldCupMatch.main, Scene 6` |

---

## 3. Input

**This program takes no input.** There is no keyboard input, no command-line argument, and no input file. The entire roster is **hard-coded (baked) into `WorldCupMatch.main`.**

### 3.1 The roster

| Role | Name | Country | Stamina | Shirt # | Shots | Assists |
|---|---|---|---|---|---|---|
| `Striker` | Alex Ramos | Brazil | 30 | 9 | 3 | — |
| `Goalkeeper` | Kofi Mensah | Ghana | 45 | 1 | — | — |
| `Midfielder` | Lena Fischer | Germany | 35 | 8 | 2 | 4 |

### 3.2 The stamina costs

| Constant | Declared in | Value | Meaning |
|---|---|---|---|
| `SHOT_STAMINA_COST` | `Striker` | 6 | Stamina the target loses per striker shot. |
| `SHOT_STAMINA_COST` | `Midfielder` | 3 | Stamina the target loses per midfielder shot. |
| `TACKLE_STAMINA_COST` | `Goalkeeper` | 4 | Stamina the target loses per tackle; **doubled** while focused. |
| `TACKLE_STAMINA_COST` | `Midfielder` | 2 | Stamina the target loses per tackle. |

The program is **deterministic**: it uses no random numbers and no clock, so every run prints exactly the same output.

---

## 4. Class design

### 4.1 The hierarchy

```
                    Player  (abstract)
                  /     |      \
          Striker   Goalkeeper  Midfielder
             \          |        /      \
              \         |       /        \
               \        |      /          \
            Scorer      |     /        Defender
               \        |    /           /
                \       |   /           /
                 \      |  /           /
              (Midfielder implements both)
```

### 4.2 The files

| File | What it is | Why it exists                                                                                                                     |
|---|---|-----------------------------------------------------------------------------------------------------------------------------------|
| `Player.java` | `abstract class` | `Holds the state and behavior every player shares. Abstract because a "generic player" is not a thing that can stand on a pitch.` |
| `Scorer.java` | `interface` | `<Holds the method for players to shoot and the amount of shots they have>`                                                       |
| `Defender.java` | `interface` | `<Holds the method for platers to tackle the ball>`                                                                               |
| `NoShotsRemainingException.java` | `class ... extends Exception` | `Exception for when a player attemps shooting without any attepmts left`                                                          |
| `Striker.java` | `class` | `A player who can shoot`                                                                                                          |
| `Goalkeeper.java` | `class` | `A player who can tackle`                                                                                                         |
| `Midfielder.java` | `class` | `A player who can shoot and tackle`                                                                                               |
| `WorldCupMatch.java` | `class` with `main` | `Main file which runs the simulation`                                                                                             |

` Midfielder needs 2 interfaces rather than 1 as`Midfielder` can function as both a keeper and striker
and Java also lets it implement two interfaces but not extend two classes as that is the rule of inheratance.`

---

## 5. Expected output

The program prints eight scenes, in this order:

1. **Kick-off / roll call** — `Alex Ramos, Kofi Mensah, Lena Fischer`
2. **Celebrations** — `SUIIIIIIIIIIIIII!!!, Kofi Mensah pumps his fists in the air!, GOAL GOAL GOALLLLLLLLL!!!!`
3. **The keeper focuses and tackles** — `Demonstrates the keeper tackles & focused tackles`
4. **The striker shoots** — `Demonstrates players taking shots and counts attempts`
5. **The midfielder does both** — `Demonstrates players doing both keeper and striker actions`
6. **The squad through two lenses** — `Shows the losers and winners`
7. **Bad input is rejected** — `Tests exceptions`
8. **Final whistle** — `Displays the final values`

### 5.1 Final values

At the final whistle the program prints these values, every run:

| Player | Final stamina | Final shots left |
|---|---|---|
| Alex Ramos | 20 | 0 |
| Kofi Mensah | 21 | n/a |
| Lena Fischer | 35 | 0 |

### 5.2 Actual terminal output



```text
<==============================================
  World Cup Match -- FIFA 2026
==============================================

=== Roll Call ===
Alex Ramos (Country: Brazil, Number 9)
Kofi Mensah (Country: Ghana, Number 1)
Lena Fischer (Country: Germany, Number 8)

=== Celebrations ===
SUIIIIIIIIIIIIII!!!
Kofi Mensah pumps his fists in the air!
GOAL GOAL GOALLLLLLLLL!!!!

=== The Keeper Focuses ===
Kofi Mensah focused? false
Kofi Mensah becomes focused!
Kofi Mensah focused? true
Kofi Mensah goes to tackle Alex Ramos.
  Alex Ramos consumes 8 stamina. (Stamina Remaining: 22)

=== The Striker Shoots ===
Alex Ramos shots a Volley on Kofi Mensah!
  Kofi Mensah consumes 6 stamina. (Stamina Remaining: 39)
Alex Ramos shots a Header on Kofi Mensah!
  Kofi Mensah consumes 6 stamina. (Stamina Remaining: 33)
Alex Ramos shots a Bicycle Kick on Kofi Mensah!
  Kofi Mensah consumes 6 stamina. (Stamina Remaining: 27)
Caught: Alex Ramos is out of shot attempts and cannot shoot Knuckle Ball.
Alex Ramos's remaining shots: 0

=== The Midfielder Does Both ===
Lena Fischer shots a Curler on Kofi Mensah!
  Kofi Mensah consumes 3 stamina. (Stamina Remaining: 24)
Lena Fischer shots a Long Shot on Kofi Mensah!
  Kofi Mensah consumes 3 stamina. (Stamina Remaining: 21)
Caught: Lena Fischer is out of shot attempts and cannot shoot Free Kick.
Lena Fischer goes to tackle Alex Ramos.
  Alex Ramos consumes 2 stamina. (Stamina Remaining: 20)

=== The Squad Through Two Lenses ===
Scorers on the pitch:
  Alex Ramos (shots remaining: 0)
  Lena Fischer (shots remaining: 0)
Defenders on the pitch:
  Kofi Mensah
  Lena Fischer

=== Bad Input Is Rejected ===
Caught: Player name cannot be null or empty
Caught: Cannot consume negative stamina!: -5

=== Final Whistle ===
Alex Ramos (Striker)
  Final stamina: 20
  Final shots remaining: 0
Kofi Mensah (Goalkeeper)
  Final stamina: 21
Lena Fischer (Midfielder)
  Final stamina: 35
  Final shots remaining: 0

```

---

## 6. Usage

### 6.1 Requirements

* A Java Development Kit (JDK), version `26.0.1 `javac --version` 26.0.1` or newer.
* A terminal. `javac` and `java` must be on your `PATH`.

### 6.2 Compile and run

From a terminal, in the folder containing the `.java` files:

```bash
javac *.java
java WorldCupMatch
```



```bash
chmod +x compileAndRun.sh
./compileAndRun.sh
```

### 6.3 Clean up

```bash
rm -f *.class
```

---

## 7. Error handling

This program throws two kinds of exception, and the difference matters.

### 7.1 `NoShotsRemainingException` — **checked**

* **Extends:** `Exception`.
* **Thrown by:** `Striker.attemptShot` and `Midfielder.attemptShot`, when `shotsRemaining <= 0`.
* **Why checked:** `Explain: running out of shots is a normal, recoverable game event.
  Because the class extends `Exception` rather than `RuntimeException`, the compiler
  refuses to compile any caller that does not either catch it or declare it with
  `throws`. That is the compiler forcing the caller to have a plan.`
* **Handled in:** `WorldCupMatch.main`, Scenes 4 and 5, with `try` / `catch` (and a `finally` in Scene 4).

### 7.2 `IllegalArgumentException` — **unchecked**

* **Extends:** `RuntimeException` (from the standard library; you do not write this class).
* **Thrown by:**
  * `Player` constructor — on a null/empty name, a null/empty country, negative stamina, or a shirt number below 1.
  * `Player.consumeStamina` — on a negative amount.
  * `Striker` / `Midfielder` constructors — on negative shots or negative assists.
* **Why unchecked:** `Explain: these are programmer errors, not game events. Nothing
  in a correct program should ever construct a player with an empty name. Unchecked
  exceptions do not have to be declared or caught.`
* **Demonstrated in:** `WorldCupMatch.main`, Scene 7.

### 7.3 Validation happens before mutation

`One sentence: explain that `consumeStamina` validates its argument and throws
before touching the field, so a rejected call leaves the object unchanged; and that
`attemptShot` throws before decrementing, so a failed shot does not consume a shot.
| # | Test case | Expected | Observed | Pass? |
|---|---|---|---|---|
| 1 | `striker.attemptShot("Header", keeper)` with 3 shots left | Shot announced; keeper loses 6 stamina; 2 shots left | `<...>` | `<yes/no>` |
| 2 | `striker.attemptShot(...)` a 4th time, with 0 shots left | Throws `NoShotsRemainingException`; keeper's stamina unchanged | `<...>` | `<...>` |
| 3 | The `finally` block in Scene 4 | Prints remaining shots whether or not the exception fired | `<...>` | `<...>` |
| 4 | `new Striker("", "Brazil", 10, 9, 1)` | Throws `IllegalArgumentException`; program continues | `<...>` | `<...>` |
| 5 | `goalkeeper.consumeStamina(-5)` | Throws `IllegalArgumentException`; keeper's stamina unchanged at 21 | `<...>` | `<...>` |
| 6 | `consumeStamina` with a huge amount | Stamina clamps at 0, never goes negative; `isFit()` returns `false` | `<...>` | `<...>` |
| 7 | Scene 6, `instanceof Scorer` | Lists Alex and Lena, not Kofi | `<...>` | `<...>` |
| 8 | Scene 6, `instanceof Defender` | Lists Kofi and Lena, not Alex | `<...>` | `<...>` |
| 9 | Run the program twice | Byte-for-byte identical output | `<...>` | `<...>` |
| 10 | Final values | 20 / 21 / 35 stamina; 0 / 0 shots | `<...>` | `<...>` |

### 8.1 What broke, and what I did about it

`I honesetly have no idea what the blanks are on top`

---

## 9. Design Recipe notes



* **Step 0 — Restate the problem.** `Simulate a simple version of FIFA World Cup`
* **Step 1 — Data definitions.** `Features Strikers, Keepers, and Midfielders`
* **Step 2 — Signatures and purpose statements.** `Strikers can shoot, Keepers can tackle, and Midfielders can do both`
* **Step 3 — Examples and tests.** 
* **Step 4 — Skeleton.** 
* **Step 5 — Implementation and refinement.** 

---

## 10. Acknowledgments

`Thank you for reading this far`
