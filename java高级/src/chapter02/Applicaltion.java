package chapter02;

import java.util.Scanner;

public class Applicaltion {

    public static void main(String[] args) {
        do {
            System.out.println("++++++++++++++++++CRUD+++++++++++++++++");
            System.out.println("+++1.insert 2.delete 3.update 4.query+++");
            System.out.println("+++++++++++++please choose one operation+++++++++++++++");
            Scanner input = new Scanner(System.in);
            int c = input.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Insert");
                    DAO.getAll();
                    DAO.insert(new Student("Achilles", "Male", "14"));
                    break;
                case 2:
                    System.out.println("Delete");
                    DAO.delete("Achilles");
                    DAO.getAll();
                    break;
                case 3:
                    System.out.println("Update");
                    DAO.getAll();
                    DAO.update(new Student("Bean", "", "7"));
                    break;
                case 4:
                    System.out.println("Query");
                    DAO.getAll();
                    break;
                default:
                    System.out.println("consonant");
            }
        } while (true);

    }

}
