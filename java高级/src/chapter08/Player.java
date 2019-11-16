package chapter08;

import java.util.Scanner;
/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 6-Fall 2019
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
                    handlePop(balloon);
                    break;
                }
            }
        }
    }

    public void handlePop(Balloon balloon) {
        balloon.pop();
        if (balloon.getPeruna()) {
            this.perunaCount += 1;
            System.out.println("Popped a Peruna!" +
                    " " + this.name + "'s Peruna Count is now " + this.perunaCount +
                    " with $ " + this.money + "!\n");
        } else if (balloon.getHornedFrog()) {
            this.money = 0;
            System.out.println("Popped a HornedFrog!" +
                    " " + this.name + "'s Peruna Count is now " + this.perunaCount +
                    " with $ " + this.money + "!\n");
        } else {
            this.money += balloon.getMoney();
            System.out.println("Popped $ " + balloon.getMoney() + "!" +
                    " " + this.name + "'s Peruna Count is now " + this.perunaCount +
                    " with $ " + this.money + "!\n");
        }
    }
}
