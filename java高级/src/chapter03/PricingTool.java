/**
 * name:
 * studentId:
 * Lab 3-Fall 2019
 */

package chapter03;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class PricingTool {
    //Specify money format
    static NumberFormat moneyFormat = new DecimalFormat("#,###.00");

    static Scanner scan = new Scanner(System.in);
    static double totalCost = 0.0;
    static double totalClientCost = 0.0;
    static String staffingProposal = "";
    static double consultantHourlyRate = 35.00;
    static double seniorConsultantHourlyRate = 55.00;
    static double managerHourlyRate = 65.00;
    static double seniorManagerHourlyRate = 75.00;
    static double principalHourlyRate = 100.00;
    static double consultantHourlyBillRate = 135.00;
    static double seniorConsultantHourlyBillRate = 155.00;
    static double managerHourlyBillRate = 165.00;
    static double seniorManagerHourlyBillRate = 175.00;
    static double principalHourlyBillRate = 200.00;

    public static void main(String[] args) {
        System.out.println("Welcome to the Pricing Tool\n");
        while (true) {
            int option = displayMenu();
            if (option == 1) {
                displayHourlyRates();
            } else if (option == 2) {
                displayHourlyBillRates();
            } else if (option == 3) {
                staffProject();
            } else if (option == 4) {
                displayProjectStaffingProposal();
            } else if (option == 5) {
                calculateProfit();
            } else if (option == 9) {
                System.out.println("You have successfully submitted your project proposal. Good-bye!");
                break;
            } else {
                System.out.println("Incorrect menu option, please try again.");
            }

        }

    }

    public static int displayMenu() {
        System.out.println("Please choose from one of the following menu options -");
        System.out.println("1) Display levels and hourly rates of consultants");
        System.out.println("2) Display levels and hourly bill rates of consultants");
        System.out.println("3) Staff project");
        System.out.println("4) Display project staffing proposal");
        System.out.println("5) Calculate profit");
        System.out.println("9) Submit project staffing proposal and exit");
        System.out.print("option: ");
        int option = scan.nextInt();
        System.out.print("\n");
        return option;
    }

    public static void displayHourlyRates() {
        System.out.println("Levels and Hourly Bill Rates");
        System.out.println("----------------------------");
        System.out.printf("%-20s%-11s\n", "Employee Level", "Hourly Rate");
        System.out.println("===============================");
        System.out.printf("%-20s$%.2f\n", "Consultant", consultantHourlyRate);
        System.out.printf("%-20s$%.2f\n", "Senior Consultant", seniorConsultantHourlyRate);
        System.out.printf("%-20s$%.2f\n", "Manager", managerHourlyRate);
        System.out.printf("%-20s$%.2f\n", "Senior Manager", seniorManagerHourlyRate);
        System.out.printf("%-20s$%.2f\n", "Principal", principalHourlyRate);
        System.out.print("\n");
    }

    public static void displayHourlyBillRates() {
        System.out.println("Levels and Hourly Rates");
        System.out.println("-----------------------");
        System.out.printf("%-20s%-11s\n", "Employee Level", "Hourly Rate");
        System.out.println("===============================");
        System.out.printf("%-20s$%.2f\n", "Consultant", consultantHourlyBillRate);
        System.out.printf("%-20s$%.2f\n", "Senior Consultant", seniorConsultantHourlyBillRate);
        System.out.printf("%-20s$%.2f\n", "Manager", managerHourlyBillRate);
        System.out.printf("%-20s$%.2f\n", "Senior Manager", seniorManagerHourlyBillRate);
        System.out.printf("%-20s$%.2f\n", "Principal", principalHourlyBillRate);
        System.out.print("\n");
    }

    public static void staffProject() {
        int num = 0;
        double hours = 0.0;
        while (true) {
            System.out.println("How do you want to staff your project?");
            System.out.println("Enter 1 for Consultant");
            System.out.println("Enter 2 for Senior Consultant");
            System.out.println("Enter 3 for Manager");
            System.out.println("Enter 4 for Senior Manager");
            System.out.println("Enter 5 for Principal");
            System.out.println("Enter any other number when done.");
            System.out.print("Level: ");
            int level = scan.nextInt();
            System.out.print("\n");
            if (level == 1) {
                System.out.print("How many Consultants would you like to staff? ");
                num = scan.nextInt();
                hours = getHoursPerWeek();
                staffingProposal += num + " Consultant(s) at " + hours + " hours per week\n";
                updateTotalCost(num, hours, consultantHourlyRate);
                updateTotalClientCost(num, hours, consultantHourlyBillRate);
                System.out.print("\n");
            } else if (level == 2) {
                System.out.print("How many Consultants would you like to staff? ");
                num = scan.nextInt();
                hours = getHoursPerWeek();
                staffingProposal += num + " Senior Consultant(s) at " + hours + " hours per week\n";
                updateTotalCost(num, hours, seniorConsultantHourlyRate);
                updateTotalClientCost(num, hours, seniorConsultantHourlyBillRate);
                System.out.print("\n");
            } else if (level == 3) {
                System.out.print("How many Consultants would you like to staff? ");
                num = scan.nextInt();
                hours = getHoursPerWeek();
                staffingProposal += num + " Manager(s) at " + hours + " hours per week\n";
                updateTotalCost(num, hours, managerHourlyRate);
                updateTotalClientCost(num, hours, managerHourlyBillRate);
                System.out.print("\n");
            } else if (level == 4) {
                System.out.print("How many Consultants would you like to staff? ");
                num = scan.nextInt();
                hours = getHoursPerWeek();
                staffingProposal += num + " Senior Manager(s) at " + hours + " hours per week\n";
                updateTotalCost(num, hours, seniorManagerHourlyRate);
                updateTotalClientCost(num, hours, seniorManagerHourlyBillRate);
                System.out.print("\n");
            } else if (level == 5) {
                System.out.print("How many Consultants would you like to staff? ");
                num = scan.nextInt();
                hours = getHoursPerWeek();
                staffingProposal += num + " Principal(s) at " + hours + " hours per week\n";
                updateTotalCost(num, hours, principalHourlyRate);
                updateTotalClientCost(num, hours, principalHourlyBillRate);
                System.out.print("\n");
            } else {
                break;
            }
        }
    }

    public static double getHoursPerWeek() {
        System.out.print("How many hours per week? ");
        return scan.nextDouble();
    }

    public static void updateTotalCost(int num, double hours, double rate) {
        totalCost += rate * num * hours;
        System.out.printf("The current employee cost with an hourly rate of $" + moneyFormat.format(rate) + " is $" + moneyFormat.format(totalCost)+"\n");
    }

    public static void updateTotalClientCost(int num, double hours, double rate) {
        totalClientCost += rate * num * hours;
        System.out.printf("The current cost to the client with an hourly bill rate of $%s is $%s\n", moneyFormat.format(rate), moneyFormat.format(totalClientCost));
    }

    public static void displayProjectStaffingProposal() {
        System.out.println("Your project will be staffed as follows:");
        System.out.println(staffingProposal);
    }

    public static double calculateProfit() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Your total cost of employee salaries per week is: $"+moneyFormat.format(totalCost));
        System.out.println("The total cost to the client per week is: $"+moneyFormat.format(totalClientCost));
        System.out.println("Your profit per week is: $"+moneyFormat.format(totalClientCost-totalCost));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("\n");
        return totalClientCost-totalCost;
    }

}
