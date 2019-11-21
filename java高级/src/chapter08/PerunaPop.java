package chapter08;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 7-Fall 2019
 */
public class PerunaPop {
    private GameBoard gb;
    private ArrayList<Player> players;
    // Money format
    private NumberFormat moneyFormat = new DecimalFormat("$###,###,###,###");

    public PerunaPop() {
        this.gb = new GameBoard();
        createPlayers();
    }

    public void createPlayers() {
        System.out.println("Welcome to Peruna Pop!\n");
        this.players = new ArrayList<Player>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String player = scanner.next();
            this.players.add(new Player(player));
        }
        System.out.print("\n");
    }

    public void playGame() {
        while (true) {
//            for (int i = 0; i < this.players.length; i++) {
//                System.out.println(this.players[i].getName() + "'s turn");
//                this.players[i].takeTurn(gb);
//                if (this.players[i].getPerunaCount() == 3) {
//
//                }
//            }
            //player0
            System.out.println(this.players.get(0).getName() + "'s turn");
            players.get(0).takeTurn(gb);
            if (players.get(0).getPerunaCount() == 3) {
                break;
            }
            //player1
            System.out.println(this.players.get(1).getName() + "'s turn");
            players.get(1).takeTurn(gb);
            if (players.get(1).getPerunaCount() == 3) {
                break;
            }

        }
        if (players.get(0).getMoney() > players.get(1).getMoney()) {
            System.out.println("Game over!! " + players.get(0).getName() + " won with " + moneyFormat.format(players.get(0).getMoney())+"!");
        } else if(players.get(0).getMoney() < players.get(1).getMoney()){
            System.out.println("Game over!! " + players.get(1).getName() + " won with " + moneyFormat.format(players.get(1).getMoney())+"!");
        }else{
            System.out.println("Game over!! You guys are even");
        }

    }
}
