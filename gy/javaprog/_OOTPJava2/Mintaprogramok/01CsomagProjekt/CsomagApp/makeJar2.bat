: �ll�tsa be az op. rendszer JAVA_HOME k�rnyezeti v�ltoz�j�t a JDK k�nyvt�rra!
: Ebben a megold�sban a ClassFiles.txt -ben megadott �llom�nyokat csomagoljuk be.

%JAVA_HOME%\bin\jar cvfm CsomagApp.jar meta-inf\manifest.mf -C classes @ClassFiles.txt -C c:\javaprog\lib\javalib extra\Console.class

pause
