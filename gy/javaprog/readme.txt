Angster Erzs�bet: Objektumorient�lt tervez�s �s programoz�s Java 
  -  1. k�tet, 3. kiad�s
  -  2. k�tet, 2. kiad�s
K�z�s mell�klet 


2005. m�rcius


javaprog.zip
------------
Bontsa ki a javaprog.zip f�jlt �s tegye a c: lemezegys�g javaprog mapp�j�ba! 
Ha m�s helyre teszi, akkor a k�nyv �s a javaprog projekt hivatkoz�sai �rtelemszer�en cser�lend�k.
A feladat mapp�j�nak nev�ben szerepl� m�nusz jel azt jelenti, hogy a feladat nincs megoldva.


JBuilder kulcs
--------------
A JBuilder alapv�ltozata ingyenes, de haszn�lat�hoz sz�ks�g van egy regisztr�ci�s �llom�nyra. Ezt a Borland let�lt�skor automatikusan adja, de k�l�n is lehet k�rni.   

Let�lt�s: http://www.borland.com/products/downloads

A JBuilder els� ind�t�sakor a regisztr�ci�s f�jlt meg kell adni.


A k�rnyezetr�l
--------------
A jpx f�jlok JBuilder projektek.

Bizonyos projektek futtat�s�hoz el�rhet�v� kell tenni a javalib k�nyvt�rat. Ez�rt
a JBuilder els� ind�t�sakor v�gezze el a k�vetkez� l�p�seket:

  Tools/Configure Libraries.../new/
     Name=javalib
     Location=User Home
     Library Paths/Add/ c:/javaprog/lib/javalib.jar

A javalib k�nyvt�r JBuilder 9.0 (jdk1.4.1_01) alatt lett leford�tva, a k�s�bbi verzi�kkal kompatibilis.

K�t speci�lis projekt seg�ts�g�vel �n�ll� java f�jlokat lehet ford�tani �s futtatni:
- javaprog.jpx: �n�ll� java alkalmaz�s f�jl ford�t�sa �s futtat�sa
- javaapplet.jpx: �n�ll� java applet f�jl ford�t�sa �s futtat�sa. A class f�jl 
  a javaprog_classes mapp�ban keletkezik. Futtat�shoz meg kell adni a html f�jlt
  (Project properties/Run/Edit/Html file)


Futtathat� jar (esettanulm�nyokn�l)
-----------------------------------
A jar f�jl hordozhat�. A futtathat� JAR f�jlok futtat�s�nak felt�tele, hogy a g�pen telep�tve legyen a JAVA futtat�k�rnyezet: %JAVA_HOME%/jre 

Az egyes k�nyvt�rakban tal�lhat� runJar.bat futtatja a JAR f�jlt. El�tte �ll�tsa be az op. rendszer JAVA_HOME k�rnyezeti v�ltoz�j�t a JDK k�nyvt�rra (pl. C:/JBuilderX/jdk1.4)!

A grafikus JAR �llom�nyok dupla kattint�sra is futnak. T�rs�tsa a JAR f�jlhoz a %JAVA_HOME%/bin k�nyvt�r javaw.exe f�jlj�t (ha az m�g nincs t�rs�tva)!


A JBuilder haszn�lat�r�l a doc k�nyvt�rban tal�l b�vebb le�r�st.
