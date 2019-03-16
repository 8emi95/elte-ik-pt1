import java.util.*;
/**
 * Feladat leírása:
 * Egy többnapos versenyen lények vesznek részt. Ki nyeri a versenyt, azaz melyik lény teszi
meg a legnagyobb távolságot úgy, hogy közben életben marad? Kezdetben minden lény
valamennyi vízzel rendelkezik, és a megtett távolsága 0. A verseny során háromféle nap
lehetséges: napos, felhős és esős. Ezekre a különböző fajtájú lények eltérő módon
reagálnak vízfogyasztás és haladás szempontjából. Minden lény először a rendelkezésére álló
víz mennyiségét változtatja meg, ezután ha tud, mozog. Bármely lény elpusztul, ha a vize
elfogy (0 lesz az érték), ezután értelemszerűen semmilyen tevékenységre sem képes.
Minden lény jellemzői: az egyedi neve (string), a rendelkezésre álló víz mennyisége (egész), a
maximálisan tárolható víz mennyisége (egész), hogy él-e (logikai), illetve az eddig megtett
távolság (egész). A versenyen részt vevő lények fajtái a következők: homokjáró,
szivacs, lépegető.
A következő táblázat tartalmazza az egyes fajták jellemzőit.
fajta       víz változtatás         távolság         max.víz
            napos   felhős esős  napos felhős esős
homokjáró   -1       0      3      3    1      0     8
szivacs     -4      -1      6      0    1      3     20
lépegető    -2      -1      3      1    2      1     12
* 
Az egyes lények a vízkészlet megváltoztatása során nem léphetik túl a fajtára jellemző
maximális értéket, legfeljebb azt érhetik el.
A program egy szövegfájlból olvassa be a verseny adatait! Az első sorban az induló lények
száma szerepel. A következő sorok tartalmazzák a lények adatait szóközökkel elválasztva: a
lény nevét, a fajtáját és a kezdetben rendelkezésére álló víz mennyiségét. A fajtát egy karakter
azonosít: h – homokjáró, s – szivacs, l – lépegető.
A lényeket leíró részt követő sorban a verseny napjai szerepelnek egy karaktersorozatban.
Az egyes jelek értelmezése: n – napos, f – felhős, e – esős.
A program kérje be a fájl nevét, majd jelenítse meg a nyertes nevét! (Feltehetjük, hogy a fájl
formátuma helyes.) Egy lehetséges bemenet:
4
Vandor h 4
Seta l 7
Csuszo s 12
Siklo s 10
nffeeennf 
* Tesztelés:
* lenyek.txt  - megfelelően lefut a program.
* lenyek2.txt - Nem indult el a versenyen egyetlen versenyző sem.
* lenyek3.txt - Lapos a maximálisnál több vizet próbált bevinni a versenyre, de nem sikerült.
* lenyek4.txt - Sajnos egyetlen élőlény sem tudta teljesíteni a versenyt.
 * @author bandoo
 */
public class Verseny {

    ArrayList<Leny> lenyek = new ArrayList<>();
    ArrayList<Character> days = new ArrayList<>();
    public static void main(String[] args) {
        Beolvaso beolvas = new Beolvaso();
        Verseny v = new Verseny();
        v.readIn(beolvas);
        v.vezerles();
        v.selectWinner();
    }
    /** Bekér konzolról egy fájlnevet és, ha tudja beolvassa a fájlt és feltölti 
        a lenyek és days ArrayListeket.
        beolvas a beolvasó osztály egy példánya */
    private  void readIn(Beolvaso beolvas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a fájl nevét!");
        String fileName = sc.nextLine();
        sc.close();
        beolvas.read(fileName, lenyek, days);
    }
    /** A napok alapján meghívja a napnak megfelelő metódusokat minden lényre. */
    private void vezerles() {
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i) == 'n') {
                for (int j = 0; j < lenyek.size(); j++) {
                    lenyek.get(j).sunny();
                }
            }
            else if (days.get(i) == 'f') {
                for (int j = 0; j < lenyek.size(); j++) {
                    lenyek.get(j).cloudy();
                }
            }
            else if (days.get(i) == 'e') {
                for (int j = 0; j < lenyek.size(); j++) {
                    lenyek.get(j).rainy();
                }
            }
        }
    }
    /** Kiválasztja a lények közül a győztest, de csak akkor ha él. 
        Amennyiben holtverseny alakul ki, akkor a több győztes közül a
        legutolsó lényt fogja győztesnek választani. */
    private void selectWinner() {
        if(lenyek.size()>0){
            Leny winner = lenyek.get(0);
            boolean found=false;
            for (int i = 0; i < lenyek.size(); i++) {
                if (winner.roadSoFar() <= lenyek.get(i).roadSoFar() && lenyek.get(i).isAlive()) {
                    winner = lenyek.get(i);
                    found=true;
                }
            }
            if(found){
                System.out.println("A verseny nyertese: " + winner.getName() + 
                                   "\nAz általa megtett út: " + winner.roadSoFar());
            }
            else{
                System.out.println("Nem volt aki túlélte volna a versenyt!");
            }
        }
        else{
            System.out.println("Nem indult el a versenyen egyetlen lény sem!");
        }
    }
}