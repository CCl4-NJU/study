package chapter08;

/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 6-Fall 2019
 */
public class Launcher {
    public static void main(String[] args) {
        //TEST 1: Uncomment this block to test Balloon
        // Your output should match the output in the instructions
//        Balloon b1 = new Balloon(1);
//        b1.setMoney(1000);
//        System.out.println(b1);
//        Balloon b2 = new Balloon(2);
//        b2.createPeruna();
//        System.out.println(b2);
//        Balloon b3 = new Balloon(3);
//        b3.createHornedFrog();
//        System.out.println(b3);
//        b1.pop();
//        System.out.println(b1);

        //TEST 2: Uncomment this block to test GameBoard
        // Your output should match the output in the instructions.
        // Note that your money values are randomly generated and will be different
//        GameBoard gb = new GameBoard();
//        System.out.println(gb);

        //TEST 3: Uncomment this block to test Player
        // Your output should match the output in the instructions.
        // Note that your money values are randomly generated and will be different
//        GameBoard gb = new GameBoard();
//        Player p = new Player("Fred");
//        p.takeTurn(gb);

        //TEST 4: Uncomment this block to test PerunaPop game
        PerunaPop pp = new PerunaPop();
        pp.playGame();
    }
    //end main
}//end Launcher

