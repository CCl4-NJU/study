package chapter04;

import java.util.Scanner;

public class AirplaneSeatReservation {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] rowOneSeats = new String[]{"1A", "1B", "1C"};
        String[] rowTwoSeats = new String[]{"2A", "2B", "2C"};
        String[] rowThreeSeats = new String[]{"3A", "3B", "3C"};

        double[] rowOnePrices = new double[]{35.00, 15.00, 45.00};
        double[] rowTwoPrices = new double[]{30.00, 12.00, 40.00};
        double[] rowThreePrices = new double[]{25.00, 10.00, 35.00};

        double total = 0.0;

        System.out.println("Reserve seats for your upcoming flight");
        display(rowOneSeats, rowTwoSeats, rowThreeSeats, rowOnePrices, rowTwoPrices, rowThreePrices);

        System.out.print("How many seats do you want to reserve? ");
        int numSeats = scanner.nextInt();
        for (int i = 0; i < numSeats; i++) {
            int row = getRow();
            if (row == 1) {
                total += makeReservation(rowOneSeats, rowOnePrices, row);
            } else if (row == 2) {
                total += makeReservation(rowTwoSeats, rowTwoPrices, row);
            } else if (row == 3) {
                total += makeReservation(rowThreeSeats, rowThreePrices, row);
            }
            System.out.printf("Your subtotal is: $%.2f\n", total);
            System.out.println("-----");
            System.out.print("\n");
        }
        display(rowOneSeats, rowTwoSeats, rowThreeSeats, rowOnePrices, rowTwoPrices, rowThreePrices);
        printReceipt(numSeats,total);
    }

    public static void display(String[] rowOneSeats, String[] rowTwoSeats, String[] rowThreeSeats, double[] rowOnePrices, double[] rowTwoPrices, double[] rowThreePrices) {
        System.out.printf("%18s\n", "SEATING CHART");
        System.out.print("\n");
        System.out.printf("%20s\n", "-----------------");
        System.out.printf("%3s%18s\n", "/", "\\");
        System.out.printf("%2s%20s\n", "/", "\\");
        System.out.printf("/%22s\n", "\\");
        System.out.printf("|%22s\n", "|");
        System.out.printf("|%22s\n", "|");
        System.out.printf("|%22s\n", "|");
        printRowSeats(rowOneSeats);
        printRowPrice(rowOnePrices);
        System.out.printf("|%22s\n", "|");
        printRowSeats(rowTwoSeats);
        printRowPrice(rowTwoPrices);
        System.out.printf("|%22s\n", "|");
        printRowSeats(rowThreeSeats);
        printRowPrice(rowThreePrices);
        System.out.printf("|%22s\n", "|");
        System.out.print("\n");
    }

    public static void printRowSeats(String[] rowSeats) {
        System.out.print("|");
        for (int i = 0; i < rowSeats.length; i++) {
            System.out.printf("%6s ", rowSeats[i]);
        }
        System.out.println("|");
    }

    public static void printRowPrice(double[] rowPrices) {
        System.out.print("|");
        for (int i = 0; i < rowPrices.length; i++) {
            System.out.printf("$%.2f ", rowPrices[i]);
        }
        System.out.println("|");

    }

    public static int getRow() {
        System.out.print("Enter the row for the seat you want to reserve: (One/Two/Three) ");
        String row = scanner.next();
        if (row.toLowerCase().equals("one")) {
            return 1;
        } else if (row.toLowerCase().equals("two")) {
            return 2;
        } else if (row.toLowerCase().equals("three")) {
            return 3;
        }
        return 0;
    }

    public static double makeReservation(String[] rowSeats, double[] prices, int row) {
        System.out.println("=======================");
        printRowSeats(rowSeats);
        printRowPrice(prices);
        System.out.println("=======================");
        System.out.print("Which seat do you want? (A/B/C) ");
        String seatLetter = scanner.next();
        System.out.println("The seat you selected is: " + row+ seatLetter.toUpperCase());
        int seatNum=0;
        if(seatLetter.toUpperCase().equals("A")){
            seatNum = 0;
            System.out.printf("The price of the seat is: $%.2f\n",prices[seatNum]);
        }else if(seatLetter.toUpperCase().equals("B")){
            seatNum = 1;
            System.out.printf("The price of the seat is: $%.2f",prices[seatNum]);
        }else if (seatLetter.toUpperCase().equals("C")){
            seatNum = 2;
            System.out.printf("The price of the seat is: $%.2f",prices[seatNum]);
        }
        updateSeatingChart(rowSeats, seatNum);
        System.out.println("=======================");
        printRowSeats(rowSeats);
        printRowPrice(prices);
        System.out.println("=======================");
        return prices[seatNum];

    }
    public static void updateSeatingChart(String[] rowSeats, int seatNum){
        System.out.println("Updated row chart:");
        rowSeats[seatNum] = "X";
    }
    public static void printReceipt(int numSeats, double total){
        System.out.println("Here's your receipt:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("Subtotal: $%.2f\n",total);
        System.out.printf("Taxes: $%.2f\n",total/(1+0.09)*0.09); //航空旅客运输进项税额=（票价+燃油附加费）÷(1+9%)×9%
        System.out.println("====================");
        System.out.printf("Total: $%.2f\n",total + total/(1+0.09)*0.09);
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }
}
