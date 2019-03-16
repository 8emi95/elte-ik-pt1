/*
 * Mintaprogramok/19. fejezet
 * CloneMely.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat - Di�k objektum kl�noz�sa
 *
 * K�sz�ts�nk egy Ember oszt�lyt, melyben egy ember nev�t �s
 * sz�let�si �v�t t�roljuk! Sz�rmaztassunk ebb�l egy Di�k
 * oszt�lyt, mely tartalmaz egy jegyeket t�rol� t�mb�t is.
 * Kl�nozzuk a megadott oszt�lyok objekumait �gy, hogy a
 * m�solt objektumok f�ggetlenek legyenek az eredetit�l,
 * vagyis kl�nozzuk a jegyeket is!
 */

class Ember implements Cloneable {                         //1
  private String nev;
  private int szulEv;

  public Ember(String nev, int szulEv) {
    this.nev = nev;
    this.szulEv = szulEv;
  }

  public Object clone() {                                  //2
    try {
      return super.clone();
    }
    catch (CloneNotSupportedException e) {
      // Nem fordulhat el�, hisz az objektum kl�nozhat�:
      return this;
    }
  }

  public String toString() {
    return nev + " " + szulEv;
  }
}

class Diak extends Ember {                                 //3
  private int[] jegyek;
  private int jegyekSzama = 3;

  public Diak(String nev, int szulEv) {
    super(nev,szulEv);
    // A di�knak alap�rtelmez�sben 3 db 4-ese van:
    jegyek = new int[jegyekSzama];
    for (int i=0; i<jegyekSzama; i++)
      jegyek[i] = 4;
  }

  public void setJegy(int index, int jegy) {
    jegyek[index] = jegy;
  }

  public String toString() {
    String str = super.toString();
    for (int i=0; i<jegyekSzama; i++)
      str = str + " " + jegyek[i];
    return str;
  }

  public Object clone() {                                  //4
    Diak diak = (Diak)super.clone();
    diak.jegyek = (int[])jegyek.clone();
    return diak;
  }
}

public class CloneMely {
  public static void main (String args[]) {
    Diak diak1 = new Diak("Karinthy Frigyes",1887);
    Diak diak2 = (Diak)diak1.clone();                      //5
    diak1.setJegy(2,5);                                    //6
    System.out.println(diak1);
    System.out.println(diak2);
  }
}

/*
A program fut�sa
Karinthy Frigyes 1887 4 4 5
Karinthy Frigyes 1887 4 4 4

A program elemz�se
Az Ember oszt�ly //1-ben implement�lja a Cloneable jel�l�
interf�szt. A clone() met�dus (//2) az �sben megadott kl�noz�st
h�vja meg; a met�dus visszat�r�si �rt�ke a m�solt objektum lesz.
A kl�noz�s a try �gban t�rt�nik. A catch �gra nem ker�lhet a
vez�rl�s, hiszen objektumunk kl�nozhat�; a szintaktika itt
megk�v�nja a visszaad�si �rt�k megad�s�t, ez�rt visszaadjuk
az eredeti objektumot.

A Di�k oszt�lyban (//3) a Cloneable interf�szt m�r nem kell
implement�lnunk, hiszen azt az �s oszt�lyban m�r megtett�k,
�s az implement�l�s �r�kl�dik (ha m�gis implement�ln�nk, az
nem okozna szintaktikai hib�t). Mivel m�ly kl�noz�st szeretn�nk
v�grehajtani (a jegyek t�mb�t is kl�nozzuk), //4-ben �t kell
�rnunk a clone() met�dust. A CloneNotSupported Exception
kiv�tellel nem kell foglalkoznunk, azt az �s clone()-ban m�r
lekezelt�k. El�sz�r elk�sz�tj�k az objektum sek�ly m�solat�t
az �s clone() megh�v�s�val. Az �gy kapott diak objektumra
r�k�nyszer�tj�k saj�t oszt�ly�t (//5). Itt azonban a b�jtr�l
b�jtra val� m�sol�s k�vetkezt�ben a jegyek t�mb mutat�ja m�g
az eredeti t�mbre mutat, ez�rt a t�mb�t is kl�nozzuk (//6) -
�gy az objektumnak saj�t, diszjunkt t�mbje lesz. A met�dus
visszat�r�si �rt�ke az �gy kieg�sz�tett objektum lesz.

A main met�dusban l�trehozunk egy diak1 objektumot, melyr�l
//7-ben egy m�solatot k�sz�t�nk diak2 azonos�t�val.
//8-ban a diak1 2. index� jegy�t �t�rjuk 5-re. A program
fut�s�b�l l�tszik, hogy csak diak1-nek v�ltozott meg a jegye.
Ha csak sek�ly kl�noz�st alkalmaztunk volna, - azaz nem adtuk
volna meg //4-ben a clone() met�dust vagy elhagytuk volna abb�l
a //6-os sort, - akkor a //8-as utas�t�s hat�s�ra mindk�t
di�knak megv�ltozott volna a jegye.
*/
