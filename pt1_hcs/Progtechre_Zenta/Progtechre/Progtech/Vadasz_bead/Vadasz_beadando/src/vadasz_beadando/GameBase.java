package vadasz_beadando;

/**
 *
 * @author zentaidavid
 */
public class GameBase {
    private Player[][] gameTable;
    private int stepCount;
    private boolean stepMade = false;
    private Player actualPlayer;
    MyVector[] hunter = new MyVector[4];
    MyVector hunted;
    
    public GameBase(int size){
        gameTable = new Player[size][size];
        for(int i = 0 ; i < size; i++){
            for(int j = 0; j < size; j++){
                gameTable[i][j] = Player.NOBODY;
            }
        }
        actualPlayer = Player.HUNTER;
        hunted = new MyVector( (size-1) /2 , (size-1) / 2 );
        gameTable[hunted.getX()][hunted.getY()] = Player.HUNTED;
        
        hunter[0] = new MyVector(0,0);
        hunter[1] = new MyVector(0,size-1);
        hunter[2] = new MyVector(size-1,0);
        hunter[3] = new MyVector(size-1,size-1);
        for(int i=0; i < hunter.length; i++){
                gameTable[hunter[i].getX()][hunter[i].getY()] = Player.HUNTER;  
        }
        stepCount = 4 * size;
    }
    
    public Player[][] getGameTable(){
        return gameTable.clone();
    }
    
    public int getStepCount(){
        return stepCount;
    }
    
    public Player getActualPlayer(){
        return actualPlayer;
    }
    
    public boolean isStepMade(){
        return stepMade;
    }
    
    public boolean isNear(int i, int j, MyVector highLighted){
        return isNearX(highLighted,i,j) || isNearY(highLighted, i,j);
    }
    
    public boolean isNearX(MyVector highLighted, int i, int j){
        return ((highLighted.getX() - 1 == i || highLighted.getX() + 1 == i) && highLighted.getY() == j);
    }
    
    public boolean isNearY(MyVector highLighted, int i, int j){
        return ((highLighted.getY() - 1 == j  || highLighted.getY() + 1 == j) && highLighted.getX() == i);
    }
    
    public void MakeStep(int i, int j, MyVector highLighted){
        stepMade = false;
        if(gameTable[i][j] == Player.NOBODY && isNear(i,j,highLighted)){
            gameTable[highLighted.getX()][highLighted.getY()] = Player.NOBODY;
            gameTable[i][j] = actualPlayer;
            stepMade = true;
            if(actualPlayer == Player.HUNTER){
                actualPlayer = Player.HUNTED;
                
                stepCount--;
            } else if(actualPlayer == Player.HUNTED){
                actualPlayer = Player.HUNTER;
                hunted.setX(i);
                hunted.setY(j);
            }
        }
    }
    /*
    Ellenőrzi a metódus hogy a játék során a menekülőt bekerítették-e.
    Ha igen akkor egy logikai tömböt ( OK ) feltölt igaz értékekkel. Ha ezeke mind
    igazak akkor egy everythingIsOk nevű logikai változóban ezt eltároljuk és visszaadjuk a játék végét
    azaz ha a vadászoknak sikerült a megadott lépésszám alatt bekeríteni a menekülőt, vagy ha nem sikerült
    a megadott lépésszám alatt.
    */
    public boolean isGameOver(){
        boolean[] OK = new boolean[4];
        for(int i=0; i < OK.length;i++){
            OK[i] = false;
        }
        try{
            if(gameTable[hunted.getX()][hunted.getY() - 1] == Player.HUNTER ){
                OK[0] = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            OK[0] = true;
        }
        try{
            if(gameTable[hunted.getX() + 1][hunted.getY()] == Player.HUNTER){
                OK[1] = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            OK[1] = true;
        }
        try{
            if(gameTable[hunted.getX()][hunted.getY() + 1] == Player.HUNTER){
                OK[2] = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            OK[2] = true;
        }
        try{
            if(gameTable[hunted.getX() - 1][hunted.getY()] == Player.HUNTER){
                OK[3] = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            OK[3] = true;
        }
        boolean everythingIsOk = true;
        for(boolean l : OK){
            if(!l){
                everythingIsOk = false;
            }
        }
        return stepCount == 0 || everythingIsOk;
    }    
}