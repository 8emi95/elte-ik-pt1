package poker;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Dobreff András
 */
class Game {

    private int bid;
    private Vector<Player> players;
    private Pot pot;
    
    private int roundNum;
    private Player winnerOfRound;
    private Vector<Player> loosersOfRound;
    
    public Game(int bid){
        this.bid = bid;
        this.players = new Vector<>();
        this.pot = new Pot();
    }

    public int getRoundNum() {
        return roundNum;
    }
    
    public Vector<Player> getPlayers(){
        return players;
    }

    public int getPot(){
        return pot.getAmount();
    }
    
    //Possible error: Before any round was played this function will return null 
    public Player getWinnerOfRound() {
        return winnerOfRound;
    }
    
    //Possible error: Before any round was played this function will return null 
    public Vector<Player> getLoosersOfRound() {
        return loosersOfRound;
    }
  
    public boolean end() {
        return this.players.size() <= 1;
    }
    
    public void addPlayer(String name, int money){
        Player newPlayer = new Player(name);
        newPlayer.setMoney(money);
        players.add(newPlayer);
    }
    
    public void playNextRound() {
        pot.clear();
        this.playersTakeBid();
        this.winnerOfRound = this.calculateWinner();
        this.winnerOfRound.setMoney(this.winnerOfRound.getMoney()+pot.getAmount());
        this.loosersOfRound = calculateLoosersOfRound();
        this.players.removeAll(this.loosersOfRound);
        this.roundNum++;
    }
    
    public Player getWinner() {
        // Possible error: If there is no Player in the game, the end() function returns true
        // So there will be an array out of bounds exception
        if(this.end()){
            return this.players.get(0);
        }else{
            return null;
        }
    }

    
    private Player calculateWinner(){
        Random rand = new Random();
        // Possible error: If there is no Player in the game this function will throw an exception
        int index = rand.nextInt(players.size());
        return players.get(index);
    }
    
    private void playersTakeBid(){
        for(Player p : players){
            // Possible error: Players may take bids they don't have resulting a negative wealth
            p.setMoney( p.getMoney() - this.bid);
            pot.addBid(this.bid);
        }
    }
    
    private Vector<Player> calculateLoosersOfRound(){
        Vector<Player> loosers = new Vector<>();
        
        for(Player p : players){
            // Possible error: A Player with negative wealth will never be a looser
            if(p.getMoney() == 0){
                loosers.add(p);
            }
        }
        
        return loosers;
    }
}
