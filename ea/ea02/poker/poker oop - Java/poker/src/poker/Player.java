package poker;

/**
 *
 * @author Dobreff András
 */
class Player {

    private String name;
    private int money;
    
    public Player(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int money){
        this.money = money;
    }
}
