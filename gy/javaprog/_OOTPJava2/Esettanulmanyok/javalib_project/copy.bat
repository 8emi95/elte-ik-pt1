Rem javalib �tm�sol�sa a c:\javaprog\lib-be
Rem javalib.jar, javalib_src.jar, valamint az extra k�nyvt�r

copy javalib.jar c:\javaprog\lib\javalib.jar
copy javalib_src.jar c:\javaprog\lib\javalib_src.jar
xcopy /e /y /i classes\extra\*.* c:\javaprog\lib\javalib\extra