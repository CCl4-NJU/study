package chapter07;
/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 5-Fall 2019
 */


import java.util.Random;
import java.util.Scanner;

public class Pop3 {
    public static int money = 0;
    public static int peruna = 0;
    public static int[] ballon = new int[20];
    public static Boolean[] ballon_status = new Boolean[20];
    public static Scanner scanner = new Scanner(System.in);

    public static void inflate() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            ballon[i] = random.nextBoolean() ? 1 : getBalloonValue();
            ballon_status[i] = false;
        }
        //[0,19]
        ballon[random.nextInt(20)] = -1;
    }

    public static int selecBallon() {
        int pop;
        while (true) {
            System.out.print("Select a balloon to pop (1-20): ");
            pop = scanner.nextInt();
            if (pop > 20) {
                System.out.println("Invalid selection!");
            } else {
                if (ballon_status[pop - 1]) {
                    System.out.println("Balloon was already popped!");
                } else {
                    break;
                }
            }
        }
        return pop;
    }

    public static int getBalloonValue() {
        Random random = new Random();
        //number in the range of 50 to 1000（a multiple of 50）
        //[50, 1000]
        return (random.nextInt(20) + 1) * 50;
    }

    public static void pop(int number) {
        ballon_status[number - 1] = true;
        if (ballon[number - 1] == 1) {
            System.out.println("You popped a Peruna!\n");
            peruna += 1;
        } else if (ballon[number - 1] == -1) {
            System.out.println("Horned Frog! You lost your money!\n");
            money = 0;
        } else {
            System.out.println("You popped $" + ballon[number - 1] + "!");
            money += ballon[number - 1];
        }
    }

    public static void displayBalloons() {
        System.out.printf("%7s:%5s\n", "Perunas", String.valueOf(peruna));
        System.out.printf("%7s:%2s%3s\n", "Money", "$", String.valueOf(money));
        System.out.print("\n");
        System.out.println("AVAILABLE BALLOONS:");
        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                if (ballon_status[i]) {
                    if (ballon[i] == 1) {
                        System.out.printf("%3s ", "P");
                    } else if (ballon[i] == -1) {
                        System.out.printf("%3s ", "F");
                    } else {
                        System.out.printf("%3s ", "$");
                    }
                } else {
                    System.out.printf("[%2s]", String.valueOf(i + 1));
                }
            } else if (i % 5 == 4) {
                if (ballon_status[i]) {
                    if (ballon[i] == 1) {
                        System.out.printf("%4s \n", "P");
                    } else if (ballon[i] == -1) {
                        System.out.printf("%4s \n", "F");
                    } else {
                        System.out.printf("%4s \n", "$");
                    }
                } else {
                    System.out.printf(" [%2s]\n", String.valueOf(i + 1));
                }
            } else {
                if (ballon_status[i]) {
                    if (ballon[i] == 1) {
                        System.out.printf("%4s ", "P");
                    } else if (ballon[i] == -1) {
                        System.out.printf("%4s ", "F");
                    } else {
                        System.out.printf("%4s ", "$");
                    }
                } else {
                    System.out.printf(" [%2s]", String.valueOf(i + 1));
                }
            }
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {
        inflate();
        while (true) {
            displayBalloons();
            int number = selecBallon();
            pop(number);
            if (peruna == 4) {
                System.out.println("You popped four Perunas! Game Over!");
                System.out.printf("You won $%3s!\n", String.valueOf(money));
                break;
            }
        }
    }
}
