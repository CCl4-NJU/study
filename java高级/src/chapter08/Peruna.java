package chapter08;

public class Peruna extends Balloon {
    public Peruna(int balloonNumber) {
        super(balloonNumber);
        this.peruna = true;
        this.hornedFrog = false;
        this.money = 0;
    }

    public void handlePop(Player player) {
        this.popped = true;
        player.setPerunaCount(player.getPerunaCount() + 1);
        System.out.println("Popped a Peruna! " +
                " " + player.getName() + "'s Peruna Count is now " + player.getPerunaCount() +
                " with $ " + player.getMoney() + "!\n");
    }
}
