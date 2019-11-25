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
                int red = 2;
                int blue = 2;
                int risk = 2;
                int chance = 2;
                String name = getName();
                name = name.toUpperCase();
                System.out.printf("Welcome, %s! You will now begin the battle against scary shapes!", name);
                ready();

                do {
                    String menuChoice = menu(name, heroHealth, enemyHealth2, mana, choice);
                    int enemyDamage = (int) getRandom(5, 10);
                    if (menuChoice.equals("FIGHT")) {
                        int fightDamage = (int) getRandom(1, 7);
                        System.out.printf("POW! You did %d damage to the shape!\n", fightDamage);
                        enemyHealth2 -= fightDamage;
                    } else if (menuChoice.equals("MAGIC")) {
                        int magicDamage;
                        String magic = magicMenu(name, heroHealth, mana, choice);
                        if (magic.equals("FIREBALL")) {
                            magicDamage = (int) getRandom(4, 6);
                            enemyHealth2 -= magicDamage;
                            mana -= 7;
                            System.out.printf("You cast a blazing fireball for %d damage!\n", magicDamage);
                        } else if (magic.equals("THUNDERBOLT")) {
                            magicDamage = (int) getRandom(3, 13);
                            enemyHealth2 -= magicDamage;
                            mana -= 12;
                            System.out.printf("You cast a shocking thunderbolt for %d damage!\n", magicDamage);
                        } else if (magic.equals("DRAIN")) {
                            magicDamage = (int) getRandom(1, 10);
                            mana -= 9;
                            heroHealth += magicDamage;
                            enemyHealth2 -= magicDamage;
                            System.out.printf("You drained %d life from the enemy and restored %d health!\n", magicDamage, magicDamage);
                        } else if (magic.equals("CRITICAL")) {
                            magicDamage = (int) getRandom(1, 7);
                            mana -= 20;
                            int lucky = (int) getRandom(1, 2);
                            System.out.printf("You attempt to critically strike the enemy for %d damage!\n", magicDamage);
                            if (lucky == 1) {
                                magicDamage *= 4;
                                System.out.printf("You hit a critical strike for %d damage!\n", magicDamage);
                            }
                            enemyHealth2 -= magicDamage;
                        } else if (magic.equals("BACK")) {
                            enemyDamage = 0;
                        }

                    } else if (menuChoice.equals("POTION")) {
                        String potion = getPotion(name, heroHealth, mana, red, blue, risk, chance, choice);
                        if (potion.equals("RED")) {
                            red--;
                            int heal = (int) getRandom(20, 30);
                            heroHealth += heal;
                            System.out.printf("You have healed %d health points.\n", heal);
                        }
                        else if(potion.equals("BLUE")) {
                            blue--;
                            int heal = (int) getRandom(10, 20);
                            mana += heal;
                            System.out.printf("You have healed %d mana points.\n", heal);
                        }
                        else if(potion.equals("RISK")) {
                            risk--;
                            int riskLuck = (int) getRandom(1, 10);
                            if (riskLuck > 3) {
                                heroHealth += 30;
                                System.out.println("You have healed 30 hit points.");
                            }
                            else {
                                enemyHealth2 += 20;
                                System.out.println("Oh no! The enemy has healed 20 hit points.");
                            }
                        }
                        else if(potion.equals("CHANCE")) {
                            chance--;
                            int chanceLuck = (int) getRandom(1, 20);
                            if (chanceLuck == 1) {
                                heroHealth = 0;
                                System.out.println("You just drank poison and died...");
                            }
                            else if (chanceLuck == 20) {
                                enemyHealth2 = 0;
                                System.out.println("The enemy randomly explodes!");
                            }
                            else if (chanceLuck > 1 && chanceLuck < 4) {
                                heroHealth = mana;
                                System.out.println("Your health points now equals your mana");
                            }
                            else if (chanceLuck > 3 && chanceLuck < 6) {
                                mana = heroHealth;
                                System.out.println("Your mana points now equals your health points");
                            }
                            else if (chanceLuck > 5 && chanceLuck < 8) {
                                heroHealth -= 10;
                                enemyHealth2 -= 10;
                                System.out.println("Both you and the enemy take 10 damage!");
                            }
                            else if (chanceLuck > 7 && chanceLuck < 10) {
                                heroHealth += 10;
                                enemyHealth2 += 10;
                                System.out.println("Both you and the enemy heal 10 health points.");
                            }
                            else if (chanceLuck > 9 && chanceLuck < 12) {
                                heroHealth += 10;
                                mana += 10;
                                System.out.println("Both your health and mana get a small boost!");
                            }
                            else if (chanceLuck > 11 && chanceLuck < 14) {
                                heroHealth -= 10;
                                mana -= 10;
                                System.out.println("Both your health and mana get a small dip.");
                            }
                            else if (chanceLuck > 13 && chanceLuck < 16) {
                                int reverse = mana;
                                mana = heroHealth;
                                heroHealth = reverse;
                                System.out.println("Your health and mana are now reversed.");
                            }
                            else if (chanceLuck > 15 && chanceLuck < 18) {
                                heroHealth = 99;
                                mana = 0;
                                System.out.println("Your health is MAX, but your mana is gone.");
                            }
                            else {
                                System.out.println("You drank water. Nothing happened.");
                            }
                        } else if (potion.equals("BACK")) {
                            enemyDamage = 0;
                        }
                    } else if (menuChoice.equals("RUN")) {
                        System.out.println("You attempt to run but squares are pretty fast. He squared you hard.");
                        enemyDamage = 999;
                    }

                    if (enemyHealth2 > 0) {
                        heroHealth -= enemyDamage;
                        System.out.printf("The enemy attacks with geometry and inflicts %d damage!\n", enemyDamage);
                    }
                } while (enemyHealth2 > 0 && heroHealth > 0);

                if (enemyHealth2 <= 0){
                    System.out.println("You have vanquished the terrible shape!");
                }
                else {
                    System.out.println("The evil squared has squared you to death! GAME OVER");
                }
            } else if (choice == 2) {
                int heroHealth = 99;
                int mana = 99;
                int enemyHealth1 = 70;
                int red = 2;
                int blue = 2;
                int risk = 2;
                int chance = 2;
                String name = getName();
                name = name.toUpperCase();
                System.out.printf("Welcome, %s! You will now begin the battle against scary shapes!", name);
                ready();

                do {
                    String menuChoice = menu(name, heroHealth, enemyHealth1, mana, choice);
                    int enemyDamage = (int) getRandom(7, 11);
                    if (menuChoice.equals("FIGHT")) {
                        int fightDamage = (int) getRandom(1, 7);
                        System.out.printf("POW! You did %d damage to the shape!\n", fightDamage);
                        enemyHealth1 -= fightDamage;
                    } else if (menuChoice.equals("MAGIC")) {
                        int magicDamage;
                        String magic = magicMenu(name, heroHealth, mana, choice);
                        if (magic.equals("FIREBALL")) {
                            magicDamage = (int) getRandom(4, 6);
                            enemyHealth1 -= magicDamage;
                            mana -= 7;
                            System.out.printf("You cast a blazing fireball for %d damage!\n", magicDamage);
                        } else if (magic.equals("THUNDERBOLT")) {
                            magicDamage = (int) getRandom(3, 13);
                            enemyHealth1 -= magicDamage;
                            mana -= 12;
                            System.out.printf("You cast a shocking thunderbolt for %d damage!\n", magicDamage);
                        } else if (magic.equals("DRAIN")) {
                            magicDamage = (int) getRandom(1, 10);
                            mana -= 9;
                            heroHealth += magicDamage;
                            enemyHealth1 -= magicDamage;
                            System.out.printf("You drained %d life from the enemy and restored %d health!\n", magicDamage, magicDamage);
                        } else if (magic.equals("CRITICAL")) {
                            magicDamage = (int) getRandom(1, 7);
                            mana -= 20;
                            int lucky = (int) getRandom(1, 2);
                            System.out.printf("You attempt to critically strike the enemy for %d damage!\n", magicDamage);
                            if (lucky == 1) {
                                magicDamage *= 4;
                                System.out.printf("You hit a critical strike for %d damage!\n", magicDamage);
                            }
                            enemyHealth1 -= magicDamage;
                        } else if (magic.equals("BACK")) {
                            enemyDamage = 0;
                        }

                    } else if (menuChoice.equals("POTION")) {
                        String potion = getPotion(name, heroHealth, mana, red, blue, risk, chance, choice);
                        if (potion.equals("RED")) {
                            red--;
                            int heal = (int) getRandom(20, 30);
                            heroHealth += heal;
                            System.out.printf("You have healed %d health points.\n", heal);
                        }
                        else if(potion.equals("BLUE")) {
                            blue--;
                            int heal = (int) getRandom(10, 20);
                            mana += heal;
                            System.out.printf("You have healed %d mana points.\n", heal);
                        }
                        else if(potion.equals("RISK")) {
                            risk--;
                            int riskLuck = (int) getRandom(1, 10);
                            if (riskLuck > 3) {
                                heroHealth += 30;
                                System.out.println("You have healed 30 hit points.");
                            }
                            else {
                                enemyHealth1 += 20;
                                System.out.println("Oh no! The enemy has healed 20 hit points.");
                            }
                        }
                        else if(potion.equals("CHANCE")) {
                            chance--;
                            int chanceLuck = (int) getRandom(1, 20);
                            if (chanceLuck == 1) {
                                heroHealth = 0;
                                System.out.println("You just drank poison and died...");
                            }
                            else if (chanceLuck == 20) {
                                enemyHealth1 = 0;
                                System.out.println("The enemy randomly explodes!");
                            }
                            else if (chanceLuck > 1 && chanceLuck < 4) {
                                heroHealth = mana;
                                System.out.println("Your health points now equals your mana");
                            }
                            else if (chanceLuck > 3 && chanceLuck < 6) {
                                mana = heroHealth;
                                System.out.println("Your mana points now equals your health points");
                            }
                            else if (chanceLuck > 5 && chanceLuck < 8) {
                                heroHealth -= 10;
                                enemyHealth1 -= 10;
                                System.out.println("Both you and the enemy take 10 damage!");
                            }
                            else if (chanceLuck > 7 && chanceLuck < 10) {
                                heroHealth += 10;
                                enemyHealth1 += 10;
                                System.out.println("Both you and the enemy heal 10 health points.");
                            }
                            else if (chanceLuck > 9 && chanceLuck < 12) {
                                heroHealth += 10;
                                mana += 10;
                                System.out.println("Both your health and mana get a small boost!");
                            }
                            else if (chanceLuck > 11 && chanceLuck < 14) {
                                heroHealth -= 10;
                                mana -= 10;
                                System.out.println("Both your health and mana get a small dip.");
                            }
                            else if (chanceLuck > 13 && chanceLuck < 16) {
                                int reverse = mana;
                                mana = heroHealth;
                                heroHealth = reverse;
                                System.out.println("Your health and mana are now reversed.");
                            }
                            else if (chanceLuck > 15 && chanceLuck < 18) {
                                heroHealth = 99;
                                mana = 0;
                                System.out.println("Your health is MAX, but your mana is gone.");
                            }
                            else {
                                System.out.println("You drank water. Nothing happened.");
                            }
                        } else if (potion.equals("BACK")) {
                            enemyDamage = 0;
                        }
                    } else if (menuChoice.equals("RUN")) {
                        System.out.println("You attempt to run but triangles are pretty fast. He stabbed with the pointy end.");
                        enemyDamage = 999;
                    }

                    if (enemyHealth1 > 0) {
                        heroHealth -= enemyDamage;
                        System.out.printf("The enemy attacks with geometry and inflicts %d damage!\n", enemyDamage);
                    }
                } while (enemyHealth1 > 0 && heroHealth > 0);

                if (enemyHealth1 <= 0){
                    System.out.println("You have vanquished the terrible shape!");
                }
                else {
                    System.out.println("The evil triangle has triangled you to death! GAME OVER");
                }
            } else if (choice == 3) {
                int heroHealth = 99;
                int mana = 99;
                int enemyHealth3 = 99;
                int red = 2;
                int blue = 2;
                int risk = 2;
                int chance = 2;
                String name = getName();
                name = name.toUpperCase();
                System.out.printf("Welcome, %s! You will now begin the battle against scary shapes!", name);
                ready();

                do {
                    String menuChoice = menu(name, heroHealth, enemyHealth3, mana, choice);
                    int enemyDamage = (int) getRandom(5, 15);
                    if (menuChoice.equals("FIGHT")) {
                        int fightDamage = (int) getRandom(1, 7);
                        System.out.printf("POW! You did %d damage to the shapes!\n", fightDamage);
                        enemyHealth3 -= fightDamage;
                    } else if (menuChoice.equals("MAGIC")) {
                        int magicDamage;
                        String magic = magicMenu(name, heroHealth, mana, choice);
                        if (magic.equals("FIREBALL")) {
                            magicDamage = (int) getRandom(4, 6);
                            enemyHealth3 -= magicDamage;
                            mana -= 7;
                            System.out.printf("You cast a blazing fireball for %d damage!\n", magicDamage);
                        } else if (magic.equals("THUNDERBOLT")) {
                            magicDamage = (int) getRandom(3, 13);
                            enemyHealth3 -= magicDamage;
                            mana -= 12;
                            System.out.printf("You cast a shocking thunderbolt for %d damage!\n", magicDamage);
                        } else if (magic.equals("DRAIN")) {
                            magicDamage = (int) getRandom(1, 10);
                            mana -= 9;
                            heroHealth += magicDamage;
                            enemyHealth3 -= magicDamage;
                            System.out.printf("You drained %d life from the enemy and restored %d health!\n", magicDamage, magicDamage);
                        } else if (magic.equals("CRITICAL")) {
                            magicDamage = (int) getRandom(1, 7);
                            mana -= 20;
                            int lucky = (int) getRandom(1, 2);
                            System.out.printf("You attempt to critically strike the enemy for %d damage!\n", magicDamage);
                            if (lucky == 1) {
                                magicDamage *= 4;
                                System.out.printf("You hit a critical strike for %d damage!\n", magicDamage);
                            }
                            enemyHealth3 -= magicDamage;
                        } else if (magic.equals("BACK")) {
                            enemyDamage = 0;
                        }

                    } else if (menuChoice.equals("POTION")) {
                        String potion = getPotion(name, heroHealth, mana, red, blue, risk, chance, choice);
                        if (potion.equals("RED")) {
                            red--;
                            int heal = (int) getRandom(20, 30);
                            heroHealth += heal;
                            System.out.printf("You have healed %d health points.\n", heal);
                        }
                        else if(potion.equals("BLUE")) {
                            blue--;
                            int heal = (int) getRandom(10, 20);
                            mana += heal;
                            System.out.printf("You have healed %d mana points.\n", heal);
                        }
                        else if(potion.equals("RISK")) {
                            risk--;
                            int riskLuck = (int) getRandom(1, 10);
                            if (riskLuck > 3) {
                                heroHealth += 30;
                                System.out.println("You have healed 20 hit points.");
                            }
                            else {
                                enemyHealth3 += 20;
                                System.out.println("Oh no! The enemy has healed 20 hit points.");
                            }
                        }
                        else if(potion.equals("CHANCE")) {
                            chance--;
                            int chanceLuck = (int) getRandom(1, 20);
                            if (chanceLuck == 1) {
                                heroHealth = 0;
                                System.out.println("You just drank poison and died...");
                            }
                            else if (chanceLuck == 20) {
                                enemyHealth3 = 0;
                                System.out.println("The enemy randomly explodes!");
                            }
                            else if (chanceLuck > 1 && chanceLuck < 4) {
                                heroHealth = mana;
                                System.out.println("Your health points now equals your mana");
                            }
                            else if (chanceLuck > 3 && chanceLuck < 6) {
                                mana = heroHealth;
                                System.out.println("Your mana points now equals your health points");
                            }
                            else if (chanceLuck > 5 && chanceLuck < 8) {
                                heroHealth -= 10;
                                enemyHealth3 -= 10;
                                System.out.println("Both you and the enemy take 10 damage!");
                            }
                            else if (chanceLuck > 7 && chanceLuck < 10) {
                                heroHealth += 10;
                                enemyHealth3 += 10;
                                System.out.println("Both you and the enemy heal 10 health points.");
                            }
                            else if (chanceLuck > 9 && chanceLuck < 12) {
                                heroHealth += 10;
                                mana += 10;
                                System.out.println("Both your health and mana get a small boost!");
                            }
                            else if (chanceLuck > 11 && chanceLuck < 14) {
                                heroHealth -= 10;
                                mana -= 10;
                                System.out.println("Both your health and mana get a small dip.");
                            }
                            else if (chanceLuck > 13 && chanceLuck < 16) {
                                int reverse = mana;
                                mana = heroHealth;
                                heroHealth = reverse;
                                System.out.println("Your health and mana are now reversed.");
                            }
                            else if (chanceLuck > 15 && chanceLuck < 18) {
                                heroHealth = 99;
                                mana = 0;
                                System.out.println("Your health is MAX, but your mana is gone.");
                            }
                            else {
                                System.out.println("You drank water. Nothing happened.");
                            }
                        } else if (potion.equals("BACK")) {
                            enemyDamage = 0;
                        }
                    } else if (menuChoice.equals("RUN")) {
                        System.out.println("You attempt to run but the deadly duo show how much geometry hurts.");
                        enemyDamage = 999;
                    }

                    if (enemyHealth3 > 0) {
                        heroHealth -= enemyDamage;
                        System.out.printf("The enemy attacks with geometry and inflicts %d damage!\n", enemyDamage);
                    }
                } while (enemyHealth3 > 0 && heroHealth > 0);

                if (enemyHealth3 <= 0){
                    System.out.println("You have vanquished the terrible shapes!");
                }
                else {
                    System.out.println("You were never seen again. Except in a math textbook... GAME OVER");
                }
            } else if (choice == 4) {
                System.out.println("You ran away to live another day.");
            } else {
                System.out.println("Please choose one of the available choices.");
            }

            System.out.println("Press y if you'd like to play again.");
            again = sc.next();
        } while(again.equals("y"));

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

    public static String menu(String name, int heroHealth, int enemyHealth, int mana, int version) {
        Scanner sc = new Scanner(System.in);
        if (version == 1) {
            battleScreen1(name, heroHealth, enemyHealth, mana);
        }
        else if(version == 2) {
            battleScreen2(name, heroHealth, enemyHealth, mana);
        }
        else {
            battleScreen3(name, heroHealth, enemyHealth, mana);
        }
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
            option = menu(name, heroHealth, enemyHealth, mana, version);
        }
        return option;

    }

    public static String magicMenu(String name, int heroHealth, int mana, int version) {
        Scanner sc = new Scanner(System.in);
        if (version == 1) {
            magicSpells1(name, heroHealth, mana);
        }
        else if (version == 2) {
            magicSpells2(name, heroHealth, mana);
        }
        else {
            magicSpells3(name, heroHealth, mana);
        }
        System.out.println("Select your spell!");
        String spellChoice = sc.next();
        if(spellChoice.equalsIgnoreCase("Fireball")){
            if(mana < 7){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana, version);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Thunderbolt")){
            if(mana < 12){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana, version);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Drain")){
            if(mana < 9){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana, version);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Critical")){
            if(mana < 15){
                System.out.println("You don't have enough mana!");
                spellChoice = magicMenu(name, heroHealth, mana, version);
            }
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else if(spellChoice.equalsIgnoreCase("Back")){
            spellChoice = spellChoice.toUpperCase();
            return spellChoice;
        } else {
            System.out.println("Please enter a correct spell!");
            spellChoice = magicMenu(name, heroHealth, mana, version);
        }
        return spellChoice;
    }

    public static String getPotion(String name, int heroHealth, int mana, int red, int blue, int risk, int chance, int version){
        Scanner sc = new Scanner(System.in);
        if (version == 1) {
            potionScreen1(name, heroHealth, mana, red, blue, risk, chance);
        }
        else if (version == 2) {
            potionScreen2(name, heroHealth, mana, red, blue, risk, chance);
        }
        else {
            potionScreen3(name, heroHealth, mana, red, blue, risk, chance);
        }
        System.out.println("Select your potion.");
        String potionChoice = sc.next();
        if (potionChoice.equalsIgnoreCase("red")){
            if (red == 0) {
                System.out.println("You are out of red potions!");
                potionChoice = getPotion(name, heroHealth, mana, red, blue, risk, chance, version);
            }
            potionChoice = potionChoice.toUpperCase();
            return potionChoice;
        } else if (potionChoice.equalsIgnoreCase("blue")) {
            if (blue == 0) {
                System.out.println("You are out of blue potions!");
                potionChoice = getPotion(name, heroHealth, mana, red, blue, risk, chance, version);
            }
            potionChoice = potionChoice.toUpperCase();
            return potionChoice;
        } else if (potionChoice.equalsIgnoreCase("risk")) {
            if (risk == 0) {
                System.out.println("You are out of risk potions!");
                potionChoice = getPotion(name, heroHealth, mana, red, blue, risk, chance, version);
            }
            potionChoice = potionChoice.toUpperCase();
            return potionChoice;
        } else if (potionChoice.equalsIgnoreCase("chance")) {
            if (chance == 0) {
                System.out.println("You are out of chance potions!");
                potionChoice = getPotion(name, heroHealth, mana, red, blue, risk, chance, version);
            }
            potionChoice = potionChoice.toUpperCase();
            return potionChoice;
        } else if (potionChoice.equalsIgnoreCase("back")) {
            potionChoice = potionChoice.toUpperCase();
            return potionChoice;
        } else {
            System.out.println("Please enter a correct potion name.");
            potionChoice = getPotion(name, heroHealth, mana, red, blue, risk, chance, version);
        }
        return potionChoice;
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
        System.out.println("     FIREBALL: Reliable but low damage (4-6) MP cost: 7                                        X");
        System.out.print("X                                                                                          X  ");
        System.out.println("   THUNDERBOLT: Potentially high damage (3-13) MP cost: 12                                   X");
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.println("   DRAIN: Absorb damage done as health (1-10) MP cost: 9                                      X");
        System.out.print("X                                   MAGIC <--                                              X  ");
        System.out.println("   CRITICAL: 50% chance to deal 400% damage ((1-5) * 4) MP cost: 15                          X");
        System.out.print("X                                   POTION                                                 X  ");
        System.out.println("                                  BACK                                                       X");
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
        System.out.println("     FIREBALL: Reliable but low damage (4-6) MP cost: 7                                        X");
        System.out.print("X                                                                                          X  ");
        System.out.println("   THUNDERBOLT: Potentially high damage (3-13) MP cost: 12                                   X");
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.println("   DRAIN: Absorb damage done as health (1-10) MP cost: 9                                      X");
        System.out.print("X                                   MAGIC <--                                              X  ");
        System.out.println("   CRITICAL: 50% chance to deal 400% damage ((1-5) * 4) MP cost: 15                          X");
        System.out.print("X                                   POTION                                                 X  ");
        System.out.println("                                  BACK                                                       X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
    public static void battleScreen3(String name, int heroHealth, int enemyHealth3, int mana) {
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
        System.out.printf("                                     HP: %02d                                                    X\n", enemyHealth3);
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
        System.out.println("     FIREBALL: Reliable but low damage (4-6) MP cost: 7                                        X");
        System.out.print("X                                                                                          X  ");
        System.out.println("   THUNDERBOLT: Potentially high damage (3-13) MP cost: 12                                   X");
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.println("   DRAIN: Absorb damage done as health (1-10) MP cost: 9                                      X");
        System.out.print("X                                   MAGIC <--                                              X  ");
        System.out.println("   CRITICAL: 50% chance to deal 400% damage ((1-5) * 4) MP cost: 15                          X");
        System.out.print("X                                   POTION                                                 X  ");
        System.out.println("                                  BACK                                                       X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void potionScreen1(String name, int heroHealth, int mana, int red, int blue, int risk, int chance) {
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
        System.out.printf("     RED POTION x %02d: Heal from 20-30 hit points                                               X\n", red);
        System.out.print("X                                                                                          X  ");
        System.out.printf("    BLUE POTION x %02d: Heal from 10-20 mana points                                            X\n", blue);
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.printf("   RISK POTION x %02d: Has a chance to heal 30 hit points for either being                     X\n", risk);
        System.out.print("X                                   MAGIC                                                  X  ");
        System.out.printf("   CHANCE POTION x %02d: Something completely random happens                                   X\n", chance);
        System.out.print("X                                   POTION <--                                             X  ");
        System.out.println("                                  BACK                                                       X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
    public static void potionScreen2(String name, int heroHealth, int mana, int red, int blue, int risk, int chance) {
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
        System.out.printf("     RED POTION x %02d: Heal from 20-30 hit points                                               X\n", red);
        System.out.print("X                                                                                          X  ");
        System.out.printf("    BLUE POTION x %02d: Heal from 10-20 mana points                                            X\n", blue);
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.printf("   RISK POTION x %02d: Has a chance to heal 30 hit points for either being                     X\n", risk);
        System.out.print("X                                   MAGIC                                                  X  ");
        System.out.printf("   CHANCE POTION x %02d: Something completely random happens                                   X\n", chance);
        System.out.print("X                                   POTION <--                                             X  ");
        System.out.println("                                  BACK                                                       X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
    public static void potionScreen3(String name, int heroHealth, int mana, int red, int blue, int risk, int chance) {
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
        System.out.printf("     RED POTION x %02d: Heal from 20-30 hit points                                               X\n", red);
        System.out.print("X                                                                                          X  ");
        System.out.printf("    BLUE POTION x %02d: Heal from 10-20 mana points                                            X\n", blue);
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.printf("   RISK POTION x %02d: Has a chance to heal 30 hit points for either being                     X\n", risk);
        System.out.print("X                                   MAGIC                                                  X  ");
        System.out.printf("   CHANCE POTION x %02d: Something completely random happens                                   X\n", chance);
        System.out.print("X                                   POTION <--                                             X  ");
        System.out.println("                                  BACK                                                       X");
        System.out.print("X                                   RUN                                                    X  ");
        System.out.println("                                                                                             X");
        System.out.print("X                                                                                          X  ");
        System.out.println("                                                                                             X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
}
