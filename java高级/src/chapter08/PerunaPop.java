package chapter08;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * name: Baiquan Wang
 * student id: 47431271
 * Lab 6-Fall 2019
 */
public class PerunaPop {
    private GameBoard gb;
    private Player[] players;
    // Money format
    private NumberFormat moneyFormat = new DecimalFormat("$###,###,###,###");

    public PerunaPop() {
        this.gb = new GameBoard();
        createPlayers();
    }

    public void createPlayers() {
        System.out.println("Welcome to Peruna Pop!\n");
        this.players = new Player[2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String player = scanner.next();
            this.players[i] = new Player(player);
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
            System.out.println(this.players[0].getName() + "'s turn");
            players[0].takeTurn(gb);
            if (players[0].getPerunaCount() == 3) {
                break;
            }
            //player1
            System.out.println(this.players[1].getName() + "'s turn");
            players[1].takeTurn(gb);
            if (players[1].getPerunaCount() == 3) {
                break;
            }

        }
        if (players[0].getMoney() > players[1].getMoney()) {
            System.out.println("Game over!! " + players[0].getName() + " won with " + moneyFormat.format(players[0].getMoney())+"!");
        } else {
            System.out.println("Game over!! " + players[1].getName() + " won with " + moneyFormat.format(players[1].getMoney())+"!");
        }

    }
}
