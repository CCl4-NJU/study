package chapter08;

/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 7-Fall 2019
 */
public class Launcher {
    public static void main(String[] args) {
//TEST 1: Uncomment this block to test your subclasses of Balloon
// Your output should match the output in the instructions
//        Player p = new Player("Fred");
//        Money m1 = new Money(1, 500);
//        System.out.println(m1);
//        m1.handlePop(p);
//        Peruna p1 = new Peruna(2);
//        System.out.println(p1);
//        p1.handlePop(p);
//        HornedFrog hf1 = new HornedFrog(2);
//        System.out.println(hf1);
//        hf1.handlePop(p);
//TEST 2: Uncomment this block to test GameBoard
// Your output should match the output in the instructions.
// Note that your money values are randomly generated and will be different
//        GameBoard gb = new GameBoard();
//        System.out.println(gb);
//TEST 3: Uncomment this block to test Player
// Your output should match the output in the instructions.
// Note that your money values are randomly generated and will be different
//        GameBoard anotherGb = new GameBoard();
//        Player p2 = new Player("Fred");
//        p2.takeTurn(anotherGb);
// //TEST 4: Uncomment this block to test PerunaPop game
        PerunaPop pp = new PerunaPop();
        pp.playGame();
    } //end main
} //end Launcher
