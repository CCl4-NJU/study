package chapter07;

import java.util.Scanner;

public class Pop1 {
    public static int money = 0;
    public static int peruna = 0;
    public static int[] ballon = new int[20];
    public static Scanner scanner = new Scanner(System.in);

    public static void inflate() {
        for (int i = 0; i < 20; i++) {
            ballon[i] = new java.util.Random().nextBoolean() ? 1 : 100;
        }
    }

    public static int selecBallon() {
        System.out.print("Select a balloon to pop (1-20): ");
        int pop = scanner.nextInt();
        return pop;
    }

    public static void pop(int number) {
        if(ballon[number-1] == 1){
            System.out.println("You popped a Peruna!");
            peruna += 1;
        }else{
            System.out.println("You popped $100!");
            money += 100;
        }
    }

    public static void displayBalloons() {
        System.out.printf("%7s:%5s\n", "Perunas", String.valueOf(peruna));
        System.out.printf("%7s:%2s%3s\n", "Money", "$", String.valueOf(money));
        System.out.print("\n");
        System.out.println("AVAILABLE BALLOONS:");
        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                if (ballon[i] == 1) {
                    System.out.printf("%3s", "P");
                } else {
                    System.out.printf("%3s", "$");
                }
            } else if (i % 5 == 4) {
                if (ballon[i] == 1) {
                    System.out.printf("%5s\n", "P");
                } else {
                    System.out.printf("%5s\n", "$");
                }
            }else {
                if (ballon[i] == 1) {
                    System.out.printf("%5s", "P");
                } else {
                    System.out.printf("%5s", "$");
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
        }
    }
}
