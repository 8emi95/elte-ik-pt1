: Állítsa be az op. rendszer JAVA_HOME környezeti változóját a JDK könyvtárra!
: Ebben a megoldásban a ClassFiles.txt -ben megadott állományokat csomagoljuk be.

%JAVA_HOME%\bin\jar cvfm CsomagApp.jar meta-inf\manifest.mf -C classes @ClassFiles.txt -C c:\javaprog\lib\javalib extra\Console.class

pause
