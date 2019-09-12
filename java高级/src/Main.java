import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("$0.00");
        Scanner input = new Scanner(System.in);
        int startBalance = input.nextInt();
        System.out.printf("%-20s","Starting Balance$");
        System.out.printf("%,-7.2f\n", (double)startBalance);

        System.out.printf("%30s %10s\n", "Deposit","Withdraw");
        for(int i=1;i<=10;i++){
            String deposit = input.nextLine();
            String withdraw = input.nextLine();
            System.out.printf("%10s", "Transaction" + i);
        }


        System.out.printf("%s %-10s %s\n", "SMU", "ABC", "XYZ");
        System.out.printf("The year is %10d\n", 2019);

        System.out.print("How old are you? ");


    }


}
