/* 
 * Feladatmegold�sok/18. fejezet
 * VeletlenEloszlas.java 
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */
 
public class VeletlenEloszlas {
  // V�letlen eg�sz sz�m gener�l�sa k�t hat�r�rt�k k�z�tt:
  static int veletlen(int alsoHatar, int felsoHatar) {
    if (alsoHatar > felsoHatar) {
      int seged=alsoHatar; alsoHatar=felsoHatar; felsoHatar=seged;
    }
    return alsoHatar + (int)(Math.random()*(felsoHatar-alsoHatar+1));
  }
  
  public static void main(String[] args) {
    final int DB=100;                  // a gener�lt sz�mok sz�ma
    final int HATAR1=100, HATAR2=200;  // a gener�lt sz�mok als� �s fels� hat�rai
    final int N=HATAR2-HATAR1+1;       // a t�mb m�rete
    
    int eloszlas[] = new int[N];
    
    int szam;
    for (int i=0; i<DB; i++) {
      // V�letlen sz�m gener�l�sa a k�t hat�r�rt�k k�z�tt:
      szam = veletlen(HATAR1,HATAR2);
      // Indexk�pz�s, gy�jt�s:
      eloszlas[szam-HATAR1]++;
    }
    // Eredm�ny ki�r�sa:
    for (int i=0; i<eloszlas.length; i++) {
      System.out.print(i+HATAR1+": "+eloszlas[i]+"  ");
    }
  }
}
