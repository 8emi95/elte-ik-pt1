/* 
 * Feladatmegoldások/18. fejezet
 * VeletlenEloszlas.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */
 
public class VeletlenEloszlas {
  // Véletlen egész szám generálása két határérték között:
  static int veletlen(int alsoHatar, int felsoHatar) {
    if (alsoHatar > felsoHatar) {
      int seged=alsoHatar; alsoHatar=felsoHatar; felsoHatar=seged;
    }
    return alsoHatar + (int)(Math.random()*(felsoHatar-alsoHatar+1));
  }
  
  public static void main(String[] args) {
    final int DB=100;                  // a generált számok száma
    final int HATAR1=100, HATAR2=200;  // a generált számok alsó és felsõ határai
    final int N=HATAR2-HATAR1+1;       // a tömb mérete
    
    int eloszlas[] = new int[N];
    
    int szam;
    for (int i=0; i<DB; i++) {
      // Véletlen szám generálása a két határérték között:
      szam = veletlen(HATAR1,HATAR2);
      // Indexképzés, gyûjtés:
      eloszlas[szam-HATAR1]++;
    }
    // Eredmény kiírása:
    for (int i=0; i<eloszlas.length; i++) {
      System.out.print(i+HATAR1+": "+eloszlas[i]+"  ");
    }
  }
}
