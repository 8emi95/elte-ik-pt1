: Java k�rnyezet be�ll�t�sai
: Csak a JDK haszn�lata mellett sz�ks�ges, �s csak az aktu�lis ablakban lesz hat�sa. 
: A k�t k�rnyezeti v�ltoz� be�ll�t�s�t �rdemes a rendszer be�ll�t�sain�l v�glegesen elv�gezni (ekkor nem kell a setjava). 

: Figyelem! HA a JBuilder-t nem a C:\JBuilder8 mapp�ba telep�tette, akkor m�dos�tsa a PATH �s JAVA_HOME sor�t!

SET PATH=%PATH%;C:\JBuilder8\jdk1.4\bin
sET JAVA_HOME=C:\JBuilder8\jdk1.4
sET CLASSPATH=.;c:\javaprog\lib\javalib.jar
doskey
c:
cd \javaprog\_MyPrograms
