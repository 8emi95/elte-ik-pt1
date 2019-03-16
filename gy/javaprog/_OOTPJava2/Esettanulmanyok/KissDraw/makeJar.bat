"%JAVA_HOME%\bin\jar" cvfm KissDraw.jar meta-inf\manifest.mf -C classes . -C c:\javaprog\lib\javalib .
pause

Rem Az útvonalat azért kell aposztrófok közé tenni, 
Rem mert A Program Files mappa nevében szóköz van :-)