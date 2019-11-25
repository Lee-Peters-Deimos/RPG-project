import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Scanner;
import java.util.Random;
public class JavaGameTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String again;
        System.out.println("Welcome to Shape Dungeon!");
        do{
            System.out.println("Please select your difficulty!");
            System.out.println("Press 1 for Easy");
            System.out.println("Press 2 for Medium");
            System.out.println("Press 3 for Hard");
            System.out.println("Press 4 to quit and run!");
            choice = sc.nextInt();
            if(choice == 1){
                int heroHealth = 99;
                int mana = 99;
                int enemyHealth2 = 50;
                String name = getName();
                name = name.toUpperCase();
                System.out.printf("Welcome, %s! You will now begin the battle against scary shapes!", name);
                ready();

                do {
                    String menuChoice = menu(name, heroHealth, enemyHealth2, mana);
                    if (menuChoice.equals("FIGHT")) {
                        int fightDamage = (int) getRandom(1, 5);
                        System.out.printf("POW! You did %d damage to the shape!", fightDamage);
                        enemyHealth2 -= fightDamage;
                    } else if (menuChoice.equals("MAGIC")) {
                        int magicDamage;
                        String magic = magicMenu(name, heroHealth, mana);
                        if (magic.equals("FIREBALL")) {
                            magicDamage = (int) getRandom(4, 6);
                            enemyHealth2 -= magicDamage;
                            mana -= 7;
                            System.out.printf("You cast a blazing fireball for %d damage!", magicDamage);
                        } else if (magic.equals("THUNDERBOLT")) {
                            magicDamage = (int) getRandom(3, 10);
                            enemyHealth2 -= magicDamage;
                            mana -= 12;
                            System.out.printf("You cast a shocking thunderbolt for %d damage!", magicDamage);
                        } else if (magic.equals("DRAIN")) {
                            magicDamage = (int) getRandom(1, 5);
                            mana -= 9;
                            heroHealth += magicDamage;
                            enemyHealth2 -= magicDamage;
                            System.out.printf("You drained %d life from the enemy and restored %d health!", magicDamage, magicDamage);
                        } else if (magic.equals("CRITICAL")) {
                            magicDamage = (int) getRandom(1, 5);
                            mana -= 15;
                            int chance = (int) getRandom(1, 2);
                            System.out.printf("You attempt to critically strike the enemy for %d damage!", magicDamage);
                            if (chance == 1) {
                                magicDamage *= 4;
                                System.out.printf("You hit a critical strike for %d damage!", magicDamage);
                            }
                            enemyHealth2 -= magicDamage;
                        } else if(magic.equals("BACK")){
                            menu(name, heroHealth)
                        }

                    }
                } while (enemyHealth2 >0);





            }

            System.out.println("Press y if you'd like to play again.");
            again = sc.next();
        } while(again.equals("y"));


        String name = getName();
        name = name.toUpperCase();
        int heroHealth = 99;
        int mana = 99;
        int enemyHealth1 = 50;
        int enemyHealth2 = 30;
        String menu;
        battleScreen1(name, heroHealth, enemyHealth2, mana);
//        System.out.println("Select Choice: ");
//        menu = scanner.next();
//        menu = menu.toUpperCase();
//        if (menu.equals("FIGHT")){
//
//        } else if (menu.equals("MAGIC")) {
//
//        } else if (menu.equals("POTION")) {
//
//        } else if (menu.equals("RUN")) {
//
//        } else {
//            System.out.println();
//        }
        battleScreen2(name, heroHealth, enemyHealth1, mana);
        battleScreen3(name, heroHealth, enemyHealth1, enemyHealth2, mana);
        magicSpells1(name, heroHealth, mana);
        magicSpells2(name, heroHealth, mana);
        magicSpells3(name, heroHealth, mana);
    }
    public static double getRandom(int min, int max){
        return (Math.random() * ((max - min) +1) + min);
    }
    public static void ready(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter when ready!");
        String ready = sc.nextLine();
        if(!ready.equals("")){
            System.out.println("Please don't type nothing! Please press enter");
            ready();
        } else{
            System.out.println("LETS GO!");
        }
    }


    public static String getName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name. Must be 4 characters");
        String name = sc.next();
        if (name.length() != 4){
            System.out.println("Must be 4 characters");
            name = getName();
        }
        return name;
    }

    public static String menu(String name, int heroHealth, int enemyHealth2, int mana) {
        Scanner sc = new Scanner(System.in);
        battleScreen1(name, heroHealth, enemyHealth2, mana);
        System.out.println("Make your choice!");
        String option = sc.next();
        if(option.equalsIgnoreCase("fight")){
            option = option.toUpperCase();
            return option;
        } else if(option.equalsIgnoreCase("magic")){
            option = option.toUpperCase();
            return option;
        } else if(option.equalsIgnoreCase("potion")){
            option = option.toUpperCase();
            return option;
        } else if(option.equalsIgnoreCase("run")){
            option = option.toUpperCase();
            return option;
        } else{
            System.out.println("Please enter a correct choice!");
            option = menu(name, heroHealth, enemyHealth2, mana);
        }
        return option;

    }

    public static String magicMenu(String name, int heroHealth, int mana) {
        Scanner sc = new Scanner(System.in);
        magicSpells1(name, heroHealth, mana);
        System.out.println("Select your spell!");
        String spellChoice = sc.next();
        if(spellChoice.equalsIgnoreCase("Fireball")){
            if(mana < 7){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Thunderbolt")){
            if(mana < 12){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Drain")){
            if(mana < 9){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Critical")){
            if(mana < 15){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Back")){
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else {
            System.out.println("Please enter a correct spell!");
            spellChoice = magicMenu(name, heroHealth, mana);
        }
        return spellChoice;
    }

    public static void battleScreen1(String name, int heroHealth, int enemyHealth, int mana){
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.print("X                                      X  " + name + "  X                                             ");
        System.out.println("                                     X  Q SQUARE  X                                          X");
        System.out.print("X                                      XXXXXXXXXX                                             ");
        System.out.println("                                     XXXXXXXXXXXXXX                                          X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                  QQQQQQQQQQQQQ                                              X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                  Q           Q                                              X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                  Q     Q     Q                                              X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                  Q           Q                                              X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                  Q           Q                                              X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                  QQQQQQQQQQQQQ                                              X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.printf("X                                   HP: %02d                                                    ", heroHealth);
        System.out.println("                                                                                             X");
        System.out.printf("X                                   MP: %02d                                                    ", mana);
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   FIGHT                                                     ");
        System.out.printf("                                   HP: %02d                                                    X\n", enemyHealth);
        System.out.print("X                                   MAGIC                                                     ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   POTION                                                    ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   RUN                                                       ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");








    }

    public static void magicSpells1(String name, int heroHealth, int mana) {
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.print("X                                      X  " + name + "  X                                             ");
        System.out.println("                                     X  Q SQUARE  X                                          X");
        System.out.print("X                                      XXXXXXXXXX                                             ");
        System.out.println("                                     XXXXXXXXXXXXXX                                          X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");

        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                  QQQQQQQQQQQQQ                                              X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                  Q           Q                                              X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                  Q     Q     Q                                              X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                  Q           Q                                              X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                  Q           Q                                              X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                  QQQQQQQQQQQQQ                                              X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.printf("X                                   HP: %02d                                                 X     ", heroHealth);
        System.out.println("                                                                                          X  ");
        System.out.printf("X                                   MP: %02d                                                 X", mana);
        System.out.println("     FIREBALL: Reliable but low damage (6-8) MP cost: 7                                        X");
        System.out.print("X                                                                                          X  ");
        System.out.println("   THUNDERBOLT: Potentially high damage (3-15) MP cost: 12                                   X");
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.println("   DRAIN: Absorb damage done as health (1-5) MP cost: 9                                      X");
        System.out.print("X                                   MAGIC <--                                              X  ");
        System.out.println("   CRITICAL: 50% chance to deal 400% damage ((1-5) * 4) MP cost: 15                          X");
        System.out.print("X                                   POTION                                                 X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void battleScreen2(String name, int heroHealth, int enemyHealth, int mana) {
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.print("X                                      X  " + name + "  X                                             ");
        System.out.println("                                     X  P TRIANGLE  X                                        X");
        System.out.print("X                                      XXXXXXXXXX                                             ");
        System.out.println("                                     XXXXXXXXXXXXXXXX                                        X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                        P                                                    X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                       P P                                                   X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                      P   P                                                  X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                     P     P                                                 X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                    P       P                                                X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                   PPPPPPPPPPP                                               X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.printf("X                                   HP: %02d                                                    ", heroHealth);
        System.out.println("                                                                                             X");
        System.out.printf("X                                   MP: %02d                                                    ", mana);
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   FIGHT                                                     ");
        System.out.printf("                                   HP: %02d                                                    X\n", enemyHealth);
        System.out.print("X                                   MAGIC                                                     ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   POTION                                                    ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   RUN                                                       ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void magicSpells2(String name, int heroHealth, int mana) {
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.print("X                                      X  " + name + "  X                                             ");
        System.out.println("                                     X  P TRIANGLE  X                                        X");
        System.out.print("X                                      XXXXXXXXXX                                             ");
        System.out.println("                                     XXXXXXXXXXXXXXXX                                        X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                        P                                                    X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                                       P P                                                   X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                      P   P                                                  X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                                     P     P                                                 X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                    P       P                                                X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                                   PPPPPPPPPPP                                               X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.printf("X                                   HP: %02d                                                 X     ", heroHealth);
        System.out.println("                                                                                          X  ");
        System.out.printf("X                                   MP: %02d                                                 X", mana);
        System.out.println("     FIREBALL: Reliable but low damage (6-8) MP cost: 7                                        X");
        System.out.print("X                                                                                          X  ");
        System.out.println("   THUNDERBOLT: Potentially high damage (3-15) MP cost: 12                                   X");
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.println("   DRAIN: Absorb damage done as health (1-5) MP cost: 9                                      X");
        System.out.print("X                                   MAGIC <--                                              X  ");
        System.out.println("   CRITICAL: 50% chance to deal 400% damage ((1-5) * 4) MP cost: 15                          X");
        System.out.print("X                                   POTION                                                 X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
    public static void battleScreen3(String name, int heroHealth, int enemyHealth1, int enemyHealth2, int mana) {
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.print("X                                      X  " + name + "  X                                             ");
        System.out.println("             X  P TRIANGLE  X                                  X  Q SQUARE  X                X");
        System.out.print("X                                      XXXXXXXXXX                                             ");
        System.out.println("             XXXXXXXXXXXXXXXX                                  XXXXXXXXXXXXXX                X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                    P                                          QQQQQQQQQQQQQ                 X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                   P P                                         Q           Q                 X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                  P   P                                        Q           Q                 X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                 P     P                                       Q           Q                 X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                P       P                                      Q           Q                 X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("               PPPPPPPPPPP                                     QQQQQQQQQQQQQ                 X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.printf("X                                   HP: %02d                                                    ", heroHealth);
        System.out.println("                                                                                             X");
        System.out.printf("X                                   MP: %02d                                                    ", mana);
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   FIGHT                                                     ");
        System.out.printf("                 HP: %02d                                          HP: %02d                      X\n", enemyHealth1, enemyHealth2);
        System.out.print("X                                   MAGIC                                                     ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   POTION                                                    ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   RUN                                                       ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
    public static void magicSpells3(String name, int heroHealth, int mana) {
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.print("X                                      X  " + name + "  X                                             ");
        System.out.println("            X  P TRIANGLE  X                                    X  Q SQUARE  X               X");
        System.out.print("X                                      XXXXXXXXXX                                             ");
        System.out.println("            XXXXXXXXXXXXXXXX                                    XXXXXXXXXXXXXX               X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                             ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                       OOOOO                                                 ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                    P                                          QQQQQQQQQQQQQ                 X");
        System.out.print("X                                   OOOOOOOOOOOOO                                             ");
        System.out.println("                   P P                                         Q           Q                 X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                  P   P                                        Q           Q                 X");
        System.out.print("X                                      OOOOOOO                                                ");
        System.out.println("                 P     P                                       Q           Q                 X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("                P       P                                      Q           Q                 X");
        System.out.print("X                                      OO   OO                                                ");
        System.out.println("               PPPPPPPPPPP                                     QQQQQQQQQQQQQ                 X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.printf("X                                   HP: %02d                                                 X     ", heroHealth);
        System.out.println("                                                                                          X  ");
        System.out.printf("X                                   MP: %02d                                                 X", mana);
        System.out.println("     FIREBALL: Reliable but low damage (6-8) MP cost: 7                                        X");
        System.out.print("X                                                                                          X  ");
        System.out.println("   THUNDERBOLT: Potentially high damage (3-15) MP cost: 12                                   X");
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.println("   DRAIN: Absorb damage done as health (1-5) MP cost: 9                                      X");
        System.out.print("X                                   MAGIC <--                                              X  ");
        System.out.println("   CRITICAL: 50% chance to deal 400% damage ((1-5) * 4) MP cost: 15                          X");
        System.out.print("X                                   POTION                                                 X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
}
