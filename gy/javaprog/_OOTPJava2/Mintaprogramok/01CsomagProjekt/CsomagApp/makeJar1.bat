: �ll�tsa be az op. rendszer JAVA_HOME k�rnyezeti v�ltoz�j�t a JDK k�nyvt�rra!
: Ebben a megold�sban becsomagoljuk a classes k�nyvt�r �sszes �llom�ny�t �s az extra\Console.class-t.

%JAVA_HOME%\bin\jar cvfm CsomagApp.jar meta-inf\manifest.mf -C classes . -C c:\javaprog\lib\javalib extra\Console.class

pause
