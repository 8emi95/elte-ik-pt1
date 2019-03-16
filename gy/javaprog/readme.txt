Angster Erzsébet: Objektumorientált tervezés és programozás Java 
  -  1. kötet, 3. kiadás
  -  2. kötet, 2. kiadás
Közös melléklet 


2005. március


javaprog.zip
------------
Bontsa ki a javaprog.zip fájlt és tegye a c: lemezegység javaprog mappájába! 
Ha más helyre teszi, akkor a könyv és a javaprog projekt hivatkozásai értelemszerûen cserélendõk.
A feladat mappájának nevében szereplõ mínusz jel azt jelenti, hogy a feladat nincs megoldva.


JBuilder kulcs
--------------
A JBuilder alapváltozata ingyenes, de használatához szükség van egy regisztrációs állományra. Ezt a Borland letöltéskor automatikusan adja, de külön is lehet kérni.   

Letöltés: http://www.borland.com/products/downloads

A JBuilder elsõ indításakor a regisztrációs fájlt meg kell adni.


A környezetrõl
--------------
A jpx fájlok JBuilder projektek.

Bizonyos projektek futtatásához elérhetõvé kell tenni a javalib könyvtárat. Ezért
a JBuilder elsõ indításakor végezze el a következõ lépéseket:

  Tools/Configure Libraries.../new/
     Name=javalib
     Location=User Home
     Library Paths/Add/ c:/javaprog/lib/javalib.jar

A javalib könyvtár JBuilder 9.0 (jdk1.4.1_01) alatt lett lefordítva, a késõbbi verziókkal kompatibilis.

Két speciális projekt segítségével önálló java fájlokat lehet fordítani és futtatni:
- javaprog.jpx: önálló java alkalmazás fájl fordítása és futtatása
- javaapplet.jpx: önálló java applet fájl fordítása és futtatása. A class fájl 
  a javaprog_classes mappában keletkezik. Futtatáshoz meg kell adni a html fájlt
  (Project properties/Run/Edit/Html file)


Futtatható jar (esettanulmányoknál)
-----------------------------------
A jar fájl hordozható. A futtatható JAR fájlok futtatásának feltétele, hogy a gépen telepítve legyen a JAVA futtatókörnyezet: %JAVA_HOME%/jre 

Az egyes könyvtárakban található runJar.bat futtatja a JAR fájlt. Elõtte állítsa be az op. rendszer JAVA_HOME környezeti változóját a JDK könyvtárra (pl. C:/JBuilderX/jdk1.4)!

A grafikus JAR állományok dupla kattintásra is futnak. Társítsa a JAR fájlhoz a %JAVA_HOME%/bin könyvtár javaw.exe fájlját (ha az még nincs társítva)!


A JBuilder használatáról a doc könyvtárban talál bõvebb leírást.
