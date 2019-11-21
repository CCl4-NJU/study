package chapter08;

public class HornedFrog extends Balloon{
    public HornedFrog(int balloonNumber) {
        super(balloonNumber);
        this.peruna = false;
        this.hornedFrog = true;
        this.money = 0;
    }
    public void handlePop(Player player){
        this.popped = true;
        player.setMoney(this.money);
        System.out.println("Popped a HornedFrog..lost your Money!" +
                " " + player.getName() + "'s Peruna Count is now " + player.getPerunaCount() +
                " with $ " + player.getMoney() + "!\n");
    }
}
