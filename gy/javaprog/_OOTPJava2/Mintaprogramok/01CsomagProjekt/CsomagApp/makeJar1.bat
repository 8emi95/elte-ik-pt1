: Állítsa be az op. rendszer JAVA_HOME környezeti változóját a JDK könyvtárra!
: Ebben a megoldásban becsomagoljuk a classes könyvtár összes állományát és az extra\Console.class-t.

%JAVA_HOME%\bin\jar cvfm CsomagApp.jar meta-inf\manifest.mf -C classes . -C c:\javaprog\lib\javalib extra\Console.class

pause
