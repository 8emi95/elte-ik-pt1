: Java környezet beállításai
: Csak a JDK használata mellett szükséges, és csak az aktuális ablakban lesz hatása. 
: A két környezeti változó beállítását érdemes a rendszer beállításainál véglegesen elvégezni (ekkor nem kell a setjava). 

: Figyelem! HA a JBuilder-t nem a C:\JBuilder8 mappába telepítette, akkor módosítsa a PATH és JAVA_HOME sorát!

SET PATH=%PATH%;C:\JBuilder8\jdk1.4\bin
sET JAVA_HOME=C:\JBuilder8\jdk1.4
sET CLASSPATH=.;c:\javaprog\lib\javalib.jar
doskey
c:
cd \javaprog\_MyPrograms
