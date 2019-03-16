package poker;

/**
 *
 * @author Dobreff András
 */
class Pot {
    private int amount = 0;
    
    public void addBid(int bid){
        // Possible error: The bid should be checked if it's not negative
        this.amount += bid;
    }
    
    public int getAmount(){
        return amount;
    }
    
    public void clear(){
        amount = 0;
    }
}
