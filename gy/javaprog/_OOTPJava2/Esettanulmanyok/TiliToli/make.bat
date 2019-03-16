Rem Állítsa be az op. rendszer JAVA_HOME környezeti változóját a JDK könyvtárra!
Rem A képeket be kell másolni az src könyvtárból a classes könyvtárba!

%JAVA_HOME%\bin\javac -sourcepath src -d classes -classpath .;c:\javaprog\lib\javalib.jar; @src\Files.txt
pause