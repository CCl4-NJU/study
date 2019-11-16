package chapter08;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 6-Fall 2019
 */
public class Balloon {
    private int balloonNumber;
    private int money;
    private boolean popped;
    private boolean peruna;
    private boolean hornedFrog;

    // Money format
    private NumberFormat moneyFormat = new DecimalFormat("$###,###,###,###");

    public Balloon(int balloonNumber) {
        this.balloonNumber = balloonNumber;
        Random random = new Random();
        //Generate a random number in the range of 0 or 1.
        int rd = random.nextBoolean() ? 1 : 0;
        if (rd == 0) {
            createPeruna();
        } else {
            createMoney();
        }
        this.popped = false;
    }

    public int getBalloonNumber() {
        return balloonNumber;
    }

    public void setBalloonNumber(int balloonNumber) {
        this.balloonNumber = balloonNumber;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean getPopped() {
        return popped;
    }

    public void setPopped(boolean popped) {
        this.popped = popped;
    }

    public boolean getPeruna() {
        return peruna;
    }

    public void setPeruna(boolean peruna) {
        this.peruna = peruna;
    }

    public boolean getHornedFrog() {
        return hornedFrog;
    }

    public void setHornedFrog(boolean hornedFrog) {
        this.hornedFrog = hornedFrog;
    }

    public void createHornedFrog() {
        this.money = 0;
        this.peruna = false;
        this.hornedFrog = true;
    }

    public void createPeruna() {
        this.money = 0;
        this.peruna = true;
        this.hornedFrog = false;
    }

    public void createMoney() {
        this.peruna = false;
        this.hornedFrog = false;
        while (true) {
            Random random = new Random();
            //[50,1000)
            int rd = random.nextInt(950) + 50;
            if (rd % 50 == 0) {
                this.money = rd;
                break;
            }
        }
    }

    public void pop() {
        this.popped = true;
    }

    public String toString() {
        return "Balloon #" + String.format("%2s", this.balloonNumber) +
                " Popped: " + String.format("%5s", this.popped) +
                " Peruna: " + String.format("%5s", this.peruna) +
                " Horned Frog: " + String.format("%5s", this.hornedFrog) +
                " Money: " + moneyFormat.format(this.money);
    }
}
