
import java.sql.Date;
import java.util.ArrayList;

public class P�lda {

    public static void main(String[] args) throws Big�mistaKiv�tel, SzingliV�lniAkarKiv�tel, Identit�sZavarosKiv�tel {
        Szem�ly Gyuri = new Szem�ly(Nem.F�RFI, "Gyuri",
                "12345ASD", "999999 Vil�gv�ge, Isten h�ta m�g�tt utca 9.");
        Szem�ly Juli = new Szem�ly(Nem.N�, "Juli",
                "12345DSA", "999999 Vil�gv�ge, Isten h�ta m�g�tt utca 9.");
        Szem�ly Tomi = new Szem�ly(Nem.F�RFI, "Tomi",
                "98765EFG", "999999 Vil�gv�ge, Isten h�ta el�tt utca 13.");
        Szem�ly Tamara = new Szem�ly(Nem.N�, "Tamara",
                "98765EFH", "999999 Vil�gv�ge, Isten h�ta el�tt utca 13.");

        H�zass�g h�zass�gGYJ = new H�zass�g(Gyuri, Juli, Tomi, Tamara,
                "999999 Vil�gv�ge, Senki se tudja hol van t�r 112.",
                Date.valueOf("2011-03-19"));

        N�szaj�nd�k aj�nd�kToTa = new N�szaj�nd�k("Tomi �s Tamara k�z�s aj�nd�ka Gyurinak �s Julinak");
        aj�nd�kToTa.�jAj�nd�koz�(Tomi);
        aj�nd�kToTa.�jAj�nd�koz�(Tamara);
        h�zass�gGYJ.�jN�szaj�nd�k(aj�nd�kToTa);

        N�szaj�nd�k aj�nd�kTomi = new N�szaj�nd�k("Tomi aj�nd�ka Gyurinak �s Julinak");
        aj�nd�kTomi.�jAj�nd�koz�(Tomi);
        h�zass�gGYJ.�jN�szaj�nd�k(aj�nd�kTomi);

        N�szaj�nd�k aj�nd�kTamara = new N�szaj�nd�k("Tamara aj�nd�ka Gyurinak �s Julinak");
        aj�nd�kTamara.�jAj�nd�koz�(Tamara);
        h�zass�gGYJ.�jN�szaj�nd�k(aj�nd�kTamara);

        H�zass�g h�zass�gToTa = new H�zass�g(Tomi, Tamara, Gyuri, Juli,
                "999999 Vil�gv�ge, Senki se tudja hol van t�r 112.",
                Date.valueOf("2011-03-22"));

        N�szaj�nd�k aj�nd�kGYJ = new N�szaj�nd�k("Gyuri �s Juli k�z�s aj�nd�ka Tominak �s Tamar�nak");
        aj�nd�kGYJ.�jAj�nd�koz�(Gyuri);
        aj�nd�kGYJ.�jAj�nd�koz�(Juli);
        h�zass�gToTa.�jN�szaj�nd�k(aj�nd�kGYJ);

        N�szaj�nd�k aj�nd�kGyuri = new N�szaj�nd�k("Gyuri aj�nd�ka Tominak �s Tamar�nak");
        aj�nd�kGyuri.�jAj�nd�koz�(Gyuri);
        h�zass�gToTa.�jN�szaj�nd�k(aj�nd�kGyuri);

        N�szaj�nd�k aj�nd�kJuli = new N�szaj�nd�k("Juli aj�nd�ka Tominak �s Tamar�nak");
        aj�nd�kJuli.�jAj�nd�koz�(Juli);
        h�zass�gToTa.�jN�szaj�nd�k(aj�nd�kJuli);

        ArrayList<H�zass�g> h�zass�gok = new ArrayList<>();
        h�zass�gok.add(h�zass�gGYJ);
        h�zass�gok.add(h�zass�gToTa);

        for (H�zass�g h�zass�g : h�zass�gok) {
            h�zass�g.szentes�t();
            System.out.println(h�zass�g.f�rj().n�v() + " �s " + h�zass�g.feles�g().n�v() + " h�zass�got k�t�ttek "
                    + h�zass�g.h�zass�gk�t�sHelye() + " helyen " + h�zass�g.h�zass�gk�t�sIdeje() + " napon "
                    + "el�tt�nk, mint tan�k el�tt: " + h�zass�g.f�rjTan�ja().n�v() + " �s " + h�zass�g.feles�gTan�ja().n�v());
        }

        ArrayList<Szem�ly> szem�lyek = new ArrayList<>();
        szem�lyek.add(Gyuri);
        szem�lyek.add(Juli);
        szem�lyek.add(Tamara);
        szem�lyek.add(Tomi);

        for (Szem�ly szem�ly : szem�lyek) {
            Szem�ly h�zast�rs = szem�ly.h�zast�rs();
            String h�zast�rsN�v = h�zast�rs == null ? "nincs, szingli" : h�zast�rs.n�v();
            System.out.println(szem�ly.n�v() + " h�zast�rsa: " + h�zast�rsN�v);
        }

        try {
            new H�zass�g(Gyuri, Tamara, Tomi, Juli,
                    "999999 Vil�gv�ge, Senki se tudja hol van t�r 112.",
                    Date.valueOf("2013-03-19")).szentes�t();
        } catch (Big�mistaKiv�tel e) {
            System.out.println("-------------");
            System.out.println("Nana Gyuri �s Tamara, az�rt ezt nem k�ne...");
        }
        h�zass�gGYJ.v�l�s();

        System.out.println("-----------");
        System.out.println("Gyuri �s Juli v�l�sa ut�n:");
        System.out.println("-----------");

        for (Szem�ly szem�ly : szem�lyek) {
            Szem�ly h�zast�rs = szem�ly.h�zast�rs();
            String h�zast�rsN�v = h�zast�rs == null ? "nincs, szingli" : h�zast�rs.n�v();
            System.out.println(szem�ly.n�v() + " h�zast�rsa: " + h�zast�rsN�v);
        }

        try {
            h�zass�gGYJ.v�l�s();
        } catch (SzingliV�lniAkarKiv�tel e) {
            System.out.println("----------");
            System.out.println(
                    "Gyuri �s Juli m�r elv�ltak, de m�g egyszer el akarnak. "
                    + "Ennyire az�rt nem ut�lhatj�k egym�st...");
        }
        
       
            new H�zass�g(Juli, Gyuri, Tomi, Tamara,
                "999999 Vil�gv�ge, Senki se tudja hol van t�r 112.",
                Date.valueOf("2015-03-19")).szentes�t();
       

    }
}
