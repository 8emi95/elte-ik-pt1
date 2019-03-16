Rem Ezt a jar készítõt akkor kell használni, ha el akarjuk készíteni a 
Rem KissDraw.jar-t, és ha elveszett a c:/javaprog/lib/javalib/extra mappa.
Rem A projektben a lib könyvtár csak biztonsági okokból van bent.

%JAVA_HOME%\bin\jar cvfm KissDraw.jar meta-inf\manifest.mf -C classes . -C lib .
pause
