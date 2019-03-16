package poker;

import java.util.Vector;
import java.util.Scanner;

/**
 *
 * @author Dobreff András
 */
public class ConsoleUserInterface {
    
    private static void writeOutPlayerStats(Vector<Player> players) {
        for(Player player : players){
            System.out.println(player.getName()+" has "+player.getMoney());
        }
    }

    private static void writeOutLoosersOfRound(Vector<Player> loosersOfRound) {
        for(Player player : loosersOfRound){
            System.out.println("--" + player.getName()+" looses");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter number of Players: ");
        int playernum = Integer.parseInt(s.nextLine()); //Possible error: Pattern cannot be parsed to an integer
        
        System.out.println("Enter money for Players: "); 
        int money = Integer.parseInt(s.nextLine()); //Possible error: Pattern cannot be parsed to an integer
        
        System.out.println("Enter bid for Players: ");
        int bid  = Integer.parseInt(s.nextLine()); //Possible error: Pattern cannot be parsed to an integer
       
        Game game = new Game(bid);
        
        for(int i = 0; i<playernum; i++){
            System.out.println("Enter "+(i+1)+". player name");
            String playername = s.nextLine();
            game.addPlayer(playername, money);
        }

        while(!game.end()){
            int roundNum = game.getRoundNum();
            System.out.println("Round "+roundNum);
            writeOutPlayerStats(game.getPlayers());
            
            game.playNextRound();
            
            System.out.println("The Pot is "+game.getPot());
            System.out.println("The Winner of this round is "+game.getWinnerOfRound().getName());
            writeOutLoosersOfRound(game.getLoosersOfRound());
        }
        
        Player winner = game.getWinner(); //Possible error: This function may return null (However in this place the game is already ended, so there will be a winner)
        System.out.println("The Winner is " + winner.getName());
    }
}
