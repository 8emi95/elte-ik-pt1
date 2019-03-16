# Konzultáció &ndash; 2017. 05. 29.

* Készítsünk egy programot, mellyel a következő játékot lehet játszani:
	* Legyen az ablak tetején egy tallózó gomb, amivel .flag kiterjesztésű fájlt nyithatunk meg
		* A fájlban soronként legyenek országnevek (akárhány szó lehet), ill. a sor utolsó szava legyen egy .png kiterjesztésű állomány, ami az ország zászlaja
		* A fájlban legalább 3 sor legyen és mindegyik képfájl létezzen a projekt könyvtárában. Ezeket a dolgokat megnyitáskor ellenőrizzük
	* Ha sikerült a megnyitás, töltődjön fel a jobb oldalon egy lista az országok neveivel, középen pedig legyen egy üres rész
	* Az üres rész alatt jelenjen meg egy "Következő" gomb, aminek hatására a betöltött zászlók közül az egyik véletlenszerűen jelenjen meg az addig üres középső panelben, a "Következő" gomb felirata pedig változzon meg "Tippelek"-re
	* Gombnyomásra a felhasználó a listában épp kijelölt országra tippelhet, miszerint annak az országnak a zászlaját látjuk most
		* A "Tippelek" gomb addig ne legyen aktív, amíg a listában nincs kijelölés
		* A listában csak egy elemet lehessen kijelölni
	* A tippelés után egy címkén a gomb alatt jelenjen meg, hogy sikerült-e vagy sem és a "Tippelek" gomb felirata váltson vissza "Következő"-re
	* A címke felirata a "Következő" megnyomására is változzon meg: azt írja ki, eddig összesen hányból hány találata volt
	* A "Következő" megnyomására a lista kijelölése is törlődjön
	* Bármikor lehessen új fájlt tallózni, ekkor a régi adatok törlődjenek
