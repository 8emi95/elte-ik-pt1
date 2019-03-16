# 12. és 13. hét &ndash; Feladat

* Készítsük el a dámajáték számítógépes változatát.
	* Ihlet: https://en.wikipedia.org/wiki/English_draughts
	* Elvárások:
		* Java8
		* Swing
		* Model-View
	* Szabályok (kb. részfeladatok):
		1. Legyen adott egy 8-szor 8-as négyzethálós tábla
		2. Erre az ismert elrendezésben pakoljunk fel 12-12 piros és fehér figurát (piros van felül, fehér alul, a fugurák a sötét mezőkön vannak, a két középső sor kivételével, a bal alsó sarok sötét színű)
		3. A játékosok felváltva léphetnek, a piros kezd; a katonák a saját menetirányukba átlósan léphetnek
		4. Ha saját figurával vannak akadályoztatva azt nem ugorhatják át
		5. Ha ellenségessel, azt igen, ekkor az ellenséges figura lekerül a tábláról
		6. Ha az ütés után újra ütésben áll a figuránk, újra üthetünk (tehát ilyenkor újra mi jövünk)
		7. Ha ütni lehet, akkor ütni kell (ha több figurával is tudunk, akkor mindegy melyikkel)
		8. Ha minden figuránk akadályozva van, vagy nincs bábunk, vesztettünk - ekkor ajánlja fel az új játék kezdését
		9. A játékot lehessen feladni (ha épp mi jövünk) &ndash; ekkor ajánlja fel az új játék kezdését
		10. A játékban lehessen döntetlent megállapítani &ndash; ekkor ajánlja fel az új játék kezdését
		11. A játék mutassa az indítás óta eltelt játszmák összesített eredményét (győzelem 1 pont, döntetlen 0,5 pont)
		12. Legyen játékidő-számláló (minden játszmánál újraindítva)
		13. Amikor mi jövünk, jelölje be azokat a mezőket, ahonnan valid lépést indíthatunk; ha rákattintottunk egy ilyen mezőre, jelölje azokat, ahova valid módon megérkezhetünk
		14. Ha egy bábuval megérkezünk a menetirány szerinti 8. sorba, az "királlyá" változik, onnantól kezdve tud hátrafelé is lépni (rögtön, abban a lépésben ilyenkor nem lehet visszafelé ütni!)
		15. Amikor új játékot kezdünk (startup, győzelem, döntetlen esetek), kérdezze meg a pályaméretet. Legyen 3 lehetőség, 5-8-12, ebből a 12 legyen a default
		16. A játékméretek listáját fájlból töltsük be indításkor!
