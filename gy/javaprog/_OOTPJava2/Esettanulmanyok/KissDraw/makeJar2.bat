Rem Ezt a jar k�sz�t�t akkor kell haszn�lni, ha el akarjuk k�sz�teni a 
Rem KissDraw.jar-t, �s ha elveszett a c:/javaprog/lib/javalib/extra mappa.
Rem A projektben a lib k�nyvt�r csak biztons�gi okokb�l van bent.

%JAVA_HOME%\bin\jar cvfm KissDraw.jar meta-inf\manifest.mf -C classes . -C lib .
pause
