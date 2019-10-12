/**
 *  name:
 *  studentId:
 *  Lab 4-Fall 2019
 *
 *
 * */

import java.util.Scanner;

public class VolumeOfCones {
    public static void main(String[] args) {
        double[] radiusArray = new double[5];
        double[] heightArray = new double[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            //input radius
            System.out.print("Enter the radius of cone " + i + ": ");
            radiusArray[i-1] = scanner.nextDouble();

            //input height
            System.out.print("Enter the height of cone " + i + ": ");
            heightArray[i-1] = scanner.nextDouble();
        }

        //output result pi*r*r*h/3
        for (int i = 1; i <= 5; i++) {
            System.out.printf("The volume of cone %d with radius %.4f and height %.4f is: %.4f\n",i,radiusArray[i-1],heightArray[i-1],Math.PI*radiusArray[i-1]*radiusArray[i-1]*heightArray[i-1]/3);
        }
    }
}
