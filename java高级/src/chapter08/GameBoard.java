package chapter08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 7-Fall 2019
 */
public class GameBoard {
    private ArrayList<Balloon> balloons;

    public GameBoard() {
        this.balloons = new ArrayList<Balloon>();
        inflateBalloons();
    }

    public void inflateBalloons() {
        ArrayList<Integer> balloonValues = fetchBalloonValuesFromFile();
        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            if (random.nextBoolean()) {
                this.balloons.add(new Money(i, balloonValues.get(random.nextInt(20))));
            } else {
                this.balloons.add(new Peruna(i));
            }
        }
        //[0,20)
        int rd = random.nextInt(20);
        balloons.set(rd, new HornedFrog(rd));
    }

    public Balloon getBalloon(int number) {
        return balloons.get(number - 1);
    }

    public void displayBalloons() {
        System.out.println("AVAILABLE BALLOONS:");
        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                if (balloons.get(i).getPopped()) {
                    if (balloons.get(i).getPeruna()) {
                        System.out.printf("%3s ", "P");
                    } else if (balloons.get(i).getHornedFrog()) {
                        System.out.printf("%3s ", "F");
                    } else {
                        System.out.printf("%3s ", "$");
                    }
                } else {
                    System.out.printf("[%2s]", String.valueOf(i + 1));
                }
            } else if (i % 5 == 4) {
                if (balloons.get(i).getPopped()) {
                    if (balloons.get(i).getPeruna()) {
                        System.out.printf("%4s \n", "P");
                    } else if (balloons.get(i).getHornedFrog()) {
                        System.out.printf("%4s \n", "F");
                    } else {
                        System.out.printf("%4s \n", "$");
                    }
                } else {
                    System.out.printf(" [%2s]\n", String.valueOf(i + 1));
                }
            } else {
                if (balloons.get(i).getPopped()) {
                    if (balloons.get(i).getPeruna()) {
                        System.out.printf("%4s ", "P");
                    } else if (balloons.get(i).getHornedFrog()) {
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
        for (int i = 1; i <= 20; i++) {
            result.append(balloons.get(i - 1).toString() + "\n");
        }
        return result.toString().trim();
    }

    private ArrayList<Integer> fetchBalloonValuesFromFile() {
        ArrayList<Integer> balloonValues = new ArrayList<>();
        try {
            FileReader fread = new FileReader(this.getBalloonValuesFileName());
            BufferedReader bread = new BufferedReader(fread);
            String line = bread.readLine();
            while (line != null) {
                balloonValues.add(Integer.parseInt(line.trim()));
                line = bread.readLine();
            }
            bread.close();
            fread.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balloonValues;
    }

    private String getBalloonValuesFileName() {
        return "src/chapter08/balloonValues.txt";
    }


}
