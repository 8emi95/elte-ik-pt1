/*
 * Mintaprogramok/19. fejezet
 * CloneMely.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat - Diák objektum klónozása
 *
 * Készítsünk egy Ember osztályt, melyben egy ember nevét és
 * születési évét tároljuk! Származtassunk ebbõl egy Diák
 * osztályt, mely tartalmaz egy jegyeket tároló tömböt is.
 * Klónozzuk a megadott osztályok objekumait úgy, hogy a
 * másolt objektumok függetlenek legyenek az eredetitõl,
 * vagyis klónozzuk a jegyeket is!
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
      // Nem fordulhat elõ, hisz az objektum klónozható:
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
    // A diáknak alapértelmezésben 3 db 4-ese van:
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
A program futása
Karinthy Frigyes 1887 4 4 5
Karinthy Frigyes 1887 4 4 4

A program elemzése
Az Ember osztály //1-ben implementálja a Cloneable jelölõ
interfészt. A clone() metódus (//2) az õsben megadott klónozást
hívja meg; a metódus visszatérési értéke a másolt objektum lesz.
A klónozás a try ágban történik. A catch ágra nem kerülhet a
vezérlés, hiszen objektumunk klónozható; a szintaktika itt
megkívánja a visszaadási érték megadását, ezért visszaadjuk
az eredeti objektumot.

A Diák osztályban (//3) a Cloneable interfészt már nem kell
implementálnunk, hiszen azt az õs osztályban már megtettük,
és az implementálás öröklõdik (ha mégis implementálnánk, az
nem okozna szintaktikai hibát). Mivel mély klónozást szeretnénk
végrehajtani (a jegyek tömböt is klónozzuk), //4-ben át kell
írnunk a clone() metódust. A CloneNotSupported Exception
kivétellel nem kell foglalkoznunk, azt az õs clone()-ban már
lekezeltük. Elõször elkészítjük az objektum sekély másolatát
az õs clone() meghívásával. Az így kapott diak objektumra
rákényszerítjük saját osztályát (//5). Itt azonban a bájtról
bájtra való másolás következtében a jegyek tömb mutatója még
az eredeti tömbre mutat, ezért a tömböt is klónozzuk (//6) -
így az objektumnak saját, diszjunkt tömbje lesz. A metódus
visszatérési értéke az így kiegészített objektum lesz.

A main metódusban létrehozunk egy diak1 objektumot, melyrõl
//7-ben egy másolatot készítünk diak2 azonosítóval.
//8-ban a diak1 2. indexû jegyét átírjuk 5-re. A program
futásából látszik, hogy csak diak1-nek változott meg a jegye.
Ha csak sekély klónozást alkalmaztunk volna, - azaz nem adtuk
volna meg //4-ben a clone() metódust vagy elhagytuk volna abból
a //6-os sort, - akkor a //8-as utasítás hatására mindkét
diáknak megváltozott volna a jegye.
*/
