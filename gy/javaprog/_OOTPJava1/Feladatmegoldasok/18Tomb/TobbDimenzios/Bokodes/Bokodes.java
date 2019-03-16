/*
 * Feladatmegoldások/18. fejezet
 * Bokodes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */
 
public class Bokodes {
  public static void main(String[] args) {
    final int MERET=8;
    int[][] tabla = new int[MERET][MERET];
    int x,y;
    for (int i=0 ; i<100; i++){
      x=(int)(Math.random()*MERET);
      y=(int)(Math.random()*MERET);
      tabla[x][y]++;
    }
    for (x=0; x<MERET; x++){
      for (y=0; y<MERET; y++){
        System.out.println((char)('A'+x)+""+(y+1)+": "+tabla[x][y]);
      }
      System.out.println();
    }
  }
}