package chapter08;

import java.util.Random;

public class Money extends Balloon{
    public Money(int balloonNumber,int amount){
        super(balloonNumber);
        this.peruna = false;
        this.hornedFrog = false;
        this.money = amount;

    }
    public void handlePop(Player player){
        this.popped = true;
        player.setMoney(player.getMoney() + this.money);
        System.out.println("Popped $ " + this.getMoney() + "! " +
                " " + player.getName() + "'s Peruna Count is now " + player.getPerunaCount() +
                " with $ " + player.getMoney() + "!\n");
    }
}
