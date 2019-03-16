# 5. gyakorlat

Az előző órai Enor megvalósításból kiindulva oldjuk meg az alábbi feladatokat:

* A program írja ki soronként a hat meccs eredményét ilyen alakban: HomeTeam HomeGoals-AwayGoals AwayTeam
	* Jelenleg minden sorhoz ugyanazt írja ki. Miért van ez? Miért rossz?
* Számlálás tétellel írjuk ki az összes a fordulóban esett gólt
* Maximumkiválasztás tétellel határozzuk meg a két csapat nevét, akik a leggólgazdagabb meccsen szerepeltek
	* Törekedjünk a kódújrafelhasználásra
	* Vigyázzunk az üres fájl esetére, ha szükséges, használjunk kivételkezelést
	* Miért nem működik? :) Javítsuk ki!

Generalizáljuk a felsorolót:

* A Match osztályt szedjük ki külön fájlba, hiszen semmi köze a felsoroló mechanizmushoz, hogy mit is sorolunk fel
* A felsoroló osztály legyen generikus, a típusparamétere a felsorolandó típus. A főprogramot is frissítsük, aminek működése legyen ugyanaz, mint eddig
