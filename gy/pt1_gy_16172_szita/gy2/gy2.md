# 2. gyakorlat

## Felkészülésül

Hello World

```java
package hu.elte.progtech.hello;	//1.

public class Greeter {	//2.

    public static void main(String[] args) {	//3.
        System.out.println("Hello World");	//4.
    }	//5.

}
```

### Kódmagyarázat, és néhány kapcsolódó gondolat

1. Javában illik mindent csomagba (package) tenni. Bár ha csak egy osztályod van, nem kötelező, de nyilván nem ez az általános
	* Egy csomagba logikailag összetartozó esetleg &bdquo;egy szinten levő&rdquo; osztályokat/interfészeket/enumokat teszünk
	* A csomagnevek felépítése hierarchikus, a nagytól megy a kicsi felé, pontokkal elálasztva. Hagyományosan egy országdomainnel kezdődik, aztán a cég, aztán a projekt következik. Végül a projekten belüli csomaghierarchia elemei
	* A forrásfájl helyének is követnie kell az osztályhierarchiát. A példabeli fájl relatív elérési útja a projekt sourcefájljainak gyökerétől a hu/elte/progtech/hello/Greeter.java
	* A package-nevek hagyományosan kisbetűsek, és persze egybeírandók
	* Egy package-ben legfeljebb egy felső szintű publikus osztály lehet. Ezt később kifejtem, pontosan mit is jelent
	* A fájlban definiált osztály teljes neve (Fully Qualified Name &ndash; FQN) a csomagnévből és az osztálynévből áll össze, esetünkben: hu.elte.progtech.hello.Greeter
	* A használt osztályokat importálni szoktuk. Ez nem azonos a C++ #include-jával! Az import inkább a using namespace utasításhoz hasonlít; arra jó, hogy ne kelljen a FQN-t használni egy osztály használatához. Azaz ha egy másik package-beli osztályban kiadom az import hu.elte.progtech.hello.Greeter; parancsot, akkor a Greetert tudom minősített név nélkül is példányosítani
	* Az &bdquo;include-olás&rdquo; inkább a classpath-ra rakással analóg &ndash; de ezt ezen a szinten intézi az IDE
	* Az import hu.elte.progtech.hello.*; parancs importálja az összes az említett csomagba tartozó osztályt. Ezt a hagyományos java-konvenciók szerint nem illik használni, írjunk ki minden importot explicit (IDE megoldja megfelelő billentyűparancsra)
2. Osztálydefiníció
	* Az osztály definíciója innen az itt megnyitott kapcsos zárójel csukó párjáig tart
	* Javaban mindent valamilyen osztály kontextusában tudunk használni, nem lehet csak úgy globális függvényeket vagy változókat deklarálni
	* Az osztály neve hagyományosan camel case-t használ &ndash; azaz ha több szavas, a több szót egybeírjuk úgy, hogy minden szót nagy betűvel kezdünk (az elsőt is)
	* Az osztály neve általában egy főnév és a feladatára utal
	* A zárójelezést javaban a példában látott módon illik tördelni
	* Az osztályban adattagok (fieldek) és metódusok (tagfüggvények) vannak. Bár biztos ki fogom ejteni a számon, de a javaban a &bdquo;függvény&rdquo; szónak nem igazán van értelme, pongyola, hiszen az a &bdquo;globális&rdquo; függvényt jelenti, míg a metódus az mindig egy osztályhoz tartozik
	* Az osztálynak van láthatósága, ezt egy módosítószóval kell megadni (access modifier). Ez lehet private, protected vagy public, esetleg maradhat üresen
	* Top level classok esetén (azaz, ha az osztály nem egy adattagja egy másik osztálynak &ndash; ez a példa ilyen top level osztályról szól) csak public vagy üres lehet
	* Ez logikus is, ha megértjük melyik mit jelent. Akár osztályról, akár adattagról, akár metódusról beszélünk, mindegyik az alábbi 4 kategóriába eshet láthatóság szempontjából:
		* Üres: package private. Az érintett entitás csak az őt tartalmazó osztály csomagjából érhető el
		* private. Az érintett entitás csak az őt definiáló osztályból érhető el
		* protected. Mint a package private + a definiáló osztály saját (más package-beli) leszármazottaiból is elérhető
		* public. Mindenhonnan elérhető
	* Innen látszik, hogy a private-nek és protectednek felső szintű osztályok esetén nincs értelme. Egyik esetében sincs ugyanis őt definiáló osztály. A protected ugyan még a package private tulajdonságaival **is** bír, de ha ezt akarjuk, akkor használjuk a package private-ot eleve
	* class: A class az osztálydefiníció kulcsszava. Az osztályok az objektumorientált szemlélet alap építőkövei, egy-egy &bdquo;sablon&rdquo;-nak kell elképzelni egy osztályt. Magában az osztály még nem egy entitás, de adattagjainak értelmes értéket adva azzá válik. Egy osztályból több példány is lehet. Egy tipikus osztály lehet mondjuk a Student egy String name és egy int credits adattaggal, és ekkor létre tudunk hozni különféle hallgató objektumokat, mindegyiket rá jellemző név és kreditérték adatokkal. Az osztály tehát egy típusdefiníció.
        * Ez a konkrét osztály kissé kilóg a sorból, hiszen nem példányosítjuk, és csak egy statikus metódusa van. Nem ez lesz az általános
3. Metódusdefiníció
    * A metódus az osztály tagfüggvénye. Mint minden eleme az osztálynak, ennek is van láthatósága, ami a korábban megismert 4 értéket veheti fel. Mivel ez public, ezért ezt mindenhonnan meg lehet hívni a Greeter osztályra hivatkozva
	* static. A statikus osztályszintűt jelent. Azt jelenti, hogy ez a main() nevű függvény a Greeter osztály példányosítása nélkül is hívható, így: Greeter.main(p); (ahol p egy String[] paraméter). Amúgy egy már létező Greeter g példányon keresztül is hívható: g.main(p);, de a statikusakat nem illik így használni, hiszen egyrészt felesleges ezért példányosítani, másrészt megtévesztő is lehet
	* void. Olyan metódus, ami nem &bdquo;tér vissza&rdquo; a futása végén a hívás helyére egy értékkel, azaz ő egy eljárás (procedure)
	* main. A metódus neve. Lehet bármi, ami nem reserved szó (kulcsszó), illetve nem számjeggyel kezdődik
	* (String[] args). A metódus formális paraméterlistája. Itt most egy tagú, egy String-tömböt vár, aminek a formális neve args, tehát a függvényben ha akarjuk, ezzel hivatkozhatunk rá
	* nyitó kapcsos zárójel. Innen kezdődik a metódus végrehajtása
	* main(String[]). A függvény nevét és paramétereinek típusát nevezik együtt szignatúrának (ez alapján nem lehet felüldefiniálni egy metódust azonos scope-ban)
	* public static void main(String[] args). Ezt az egészet hívják deklarációnak. Speciálisan kell pontosan egy ilyennek lennie minden Java-projektben, és ez a bizonyos String tömböt váró statikus main nevű függvény lesz a Java-program belépési pontja
		* A paraméter neve mindegy
		* A public és static módosítók sorrendje mindegy
4.	A konzolra való kiírás metódushívása
    * A System egy osztály, ami a konzolos input-output műveleteket, valamint a környezeti változókhoz való hozzáférés lehetőségét biztosítja. Az FQN-je java.lang.System, a java.lang az egyetlen olyan csomag, amit nem kell importálni, ezért bár egy import sorunk sincs, a Systemet mégis elértük az osztály nevével
    * Az out egy publikus statikus adattagja a Systemnek. Publikus, mert elérjük kívülről (egy másik, a Greeter osztály kontextusából), és statikus, mert a System osztályon, nem annak egy példányán keresztül érjük el. Amúgy a szerepe ugyanaz, mint a coutnak C++-ból: ő a kimeneti célra használható konzol
    * println("Hello World"); A println() függvény hívása a "Hello World" stringliterállal, mint aktuális paraméterrel. A println() túlterhelt (overload) függvény, több lehetséges paraméterezése is van. Paraméter nélkül egyszerűen csak kiír egy üres sort. String paraméterrel kiírja a kapott stringet és egy új sor jelet. C++-beli megfelelője ezért a ALANY<<PARAMÉTER<<endl; lenne. Létezik sima print() függvény is, ez nem rakja ki az új sort
5.	Eddig tart a main() futása; itt &bdquo;tér vissza&rdquo; a vezérlés a hívás helyére, ami itt az operációs rendszer

## Órai anyag

* A Java kulcsszavait fogjuk végigvenni egyesével. Mi hol használható, mi mire való. Ezzel egyúttal felvázoljuk a félév első felének tematikáját, hiszen bár a kulcsszavakat most felsoroljuk, a hozzájuk kapcsolódó témákat még nem vesszük azok teljes mélyégében
* Ilyenek:
	* Kivételkezelés
	* OOP (származtatás, interfészek, polimorfizmus, meg úgy általában minden)
	* Típusozás (primitív típusok vs. ... majd meglátjuk mik)
* A primitív típusokról, láthatóságról, szálkezelésről (említés szintjén), vezérlési szerkezetekről, függvényekről már igyekszem ezen az órán eleget beszélni, persze ha szükséges, ki fogunk ezekre is térni még később
