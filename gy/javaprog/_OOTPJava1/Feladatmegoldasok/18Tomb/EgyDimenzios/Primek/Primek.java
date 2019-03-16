/* 
 * Feladatmegold�sok/18. fejezet
 * Primek.java 
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */
 
import extra.*;

public class Primek {
  public static void main (String args[]) {
    // Hat�rsz�m bek�r�se, ennek megfelel� nagysag� t�mb lefoglal�sa.
    // Csak a 2. elemt�l haszn�ljuk a t�mb�t (az 1 nem pr�m).
    int hatar = Console.readInt("Meddig? ");
    boolean[] szamok = new boolean[hatar+1];

    // Kezdetben minden elem pr�m:
    for (int i=2; i<szamok.length; i++)
      szamok[i] = true;

    // Ami m�g pr�m, annak a t�bbsz�r�seit false-ra �ll�tjuk:
    for (int i=2; i<szamok.length; i++)
      if (szamok[i])
        for (int j=2*i; j<szamok.length; j+=i)
          szamok[j]=false;

    // A true �rt�k� elemek indexei a primek:
    int nPrim=0;
    for (int i=2; i<szamok.length; i++)
      if (szamok[i])
        System.out.println(Format.right(++nPrim,2)+": "+i);
  } 
} 
