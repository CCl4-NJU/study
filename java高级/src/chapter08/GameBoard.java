package chapter08;

import java.util.Random;

/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 6-Fall 2019
 */
public class GameBoard {
    private Balloon[] balloons;

    public GameBoard() {
        this.balloons = new Balloon[20];
        inflateBalloons();
    }

    public void inflateBalloons() {
        for (int i = 1; i <= 20; i++) {
            balloons[i - 1] = new Balloon(i);
        }
        Random random = new Random();
        //[0,20)
        int rd = random.nextInt(20);
        balloons[rd].createHornedFrog();
    }

    public Balloon getBalloon(int number) {
        return balloons[number - 1];
    }

    public void displayBalloons() {
        System.out.println("AVAILABLE BALLOONS:");
        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                if (balloons[i].getPopped()) {
                    if (balloons[i].getPeruna()) {
                        System.out.printf("%3s ", "P");
                    } else if (balloons[i].getHornedFrog()) {
                        System.out.printf("%3s ", "F");
                    } else {
                        System.out.printf("%3s ", "$");
                    }
                } else {
                    System.out.printf("[%2s]", String.valueOf(i + 1));
                }
            } else if (i % 5 == 4) {
                if (balloons[i].getPopped()) {
                    if (balloons[i].getPeruna()) {
                        System.out.printf("%4s \n", "P");
                    } else if (balloons[i].getHornedFrog()) {
                        System.out.printf("%4s \n", "F");
                    } else {
                        System.out.printf("%4s \n", "$");
                    }
                } else {
                    System.out.printf(" [%2s]\n", String.valueOf(i + 1));
                }
            } else {
                if (balloons[i].getPopped()) {
                    if (balloons[i].getPeruna()) {
                        System.out.printf("%4s ", "P");
                    } else if (balloons[i].getHornedFrog()) {
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 20; i++) {
            result.append(balloons[i - 1].toString()+"\n");
        }
        return result.toString().trim();
    }


}
