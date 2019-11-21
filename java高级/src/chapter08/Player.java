package chapter08;

import java.util.Scanner;
/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 7-Fall 2019
 */

public class Player {
    private String name;
    private int money;
    private int perunaCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPerunaCount() {
        return perunaCount;
    }

    public void setPerunaCount(int perunaCount) {
        this.perunaCount = perunaCount;
    }

    public void takeTurn(GameBoard gb) {
        gb.displayBalloons();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(this.name + "'s turn. Pick a balloon: ");
            int pop = scanner.nextInt();
            if (pop > 20) {
                System.out.println("Invalid selection!");
            } else {
                Balloon balloon = gb.getBalloon(pop);
                if (balloon.getPopped()) {
                    System.out.println("Balloon was already popped!");
                } else {
                    balloon.handlePop(this);
                    break;
                }
            }
        }
    }
}
