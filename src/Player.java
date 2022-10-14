


public class Player {

    private int money = 500 ;

    public Player() {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Player{" +
                "money=" + money +
                '}';
    }
}
