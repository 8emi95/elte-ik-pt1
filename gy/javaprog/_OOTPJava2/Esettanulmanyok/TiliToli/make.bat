Rem �ll�tsa be az op. rendszer JAVA_HOME k�rnyezeti v�ltoz�j�t a JDK k�nyvt�rra!
Rem A k�peket be kell m�solni az src k�nyvt�rb�l a classes k�nyvt�rba!

%JAVA_HOME%\bin\javac -sourcepath src -d classes -classpath .;c:\javaprog\lib\javalib.jar; @src\Files.txt
pause