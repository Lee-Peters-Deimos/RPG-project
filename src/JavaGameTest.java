import java.util.Scanner;
public class JavaGameTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name = getName();
        name = name.toUpperCase();
        int heroHealth = 99;
        int enemyHealth = 50;
        int mana = 99;
        String menu;
        battleScreen1(name, heroHealth, enemyHealth, mana);
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
        battleScreen2(name, heroHealth, enemyHealth, mana);
        magicSpells1(name, heroHealth, mana);
    }


    public static String getName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name. Must be 4 characters");
        String name = scanner.next();
        if (name.length() != 4){
            System.out.println("Must be 4 characters");
            name = getName();
        }
        return name;
    }

    public static void menu() {

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
        System.out.println("                                  Q           Q                                              X");
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
        System.out.println("                                  Q           Q                                              X");
        System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.printf("X                                   HP: %02d                                                 X     ", heroHealth);
        System.out.println("                                                                                          X  ");
        System.out.printf("X                                   MP: %02d                                                 X", mana);
        System.out.println("     FIREBALL: Reliable but low damage (6-8) MP cost: 7                                      X");
        System.out.print("X                                                                                          X  ");
        System.out.println("   THUNDERBOLT: Potentially high damage (3-15) MP cost: 12                                   X");
        System.out.print("X                                   FIGHT                                                  X  ");
        System.out.println("   DRAIN: Absorb damage done as health (1-5) MP cost: 9                                      X");
        System.out.print("X                                   MAGIC <--                                              X  ");
        System.out.println("   DOUBLE: Attack twice MP cost: 20                                                          X");
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
}
