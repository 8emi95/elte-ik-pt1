
import java.sql.Date;
import java.util.ArrayList;

public class Példa {

    public static void main(String[] args) throws BigámistaKivétel, SzingliVálniAkarKivétel, IdentitásZavarosKivétel {
        Személy Gyuri = new Személy(Nem.FÉRFI, "Gyuri",
                "12345ASD", "999999 Világvége, Isten háta mögött utca 9.");
        Személy Juli = new Személy(Nem.NÕ, "Juli",
                "12345DSA", "999999 Világvége, Isten háta mögött utca 9.");
        Személy Tomi = new Személy(Nem.FÉRFI, "Tomi",
                "98765EFG", "999999 Világvége, Isten háta elõtt utca 13.");
        Személy Tamara = new Személy(Nem.NÕ, "Tamara",
                "98765EFH", "999999 Világvége, Isten háta elõtt utca 13.");

        Házasság házasságGYJ = new Házasság(Gyuri, Juli, Tomi, Tamara,
                "999999 Világvége, Senki se tudja hol van tér 112.",
                Date.valueOf("2011-03-19"));

        Nászajándék ajándékToTa = new Nászajándék("Tomi és Tamara közös ajándéka Gyurinak és Julinak");
        ajándékToTa.újAjándékozó(Tomi);
        ajándékToTa.újAjándékozó(Tamara);
        házasságGYJ.újNászajándék(ajándékToTa);

        Nászajándék ajándékTomi = new Nászajándék("Tomi ajándéka Gyurinak és Julinak");
        ajándékTomi.újAjándékozó(Tomi);
        házasságGYJ.újNászajándék(ajándékTomi);

        Nászajándék ajándékTamara = new Nászajándék("Tamara ajándéka Gyurinak és Julinak");
        ajándékTamara.újAjándékozó(Tamara);
        házasságGYJ.újNászajándék(ajándékTamara);

        Házasság házasságToTa = new Házasság(Tomi, Tamara, Gyuri, Juli,
                "999999 Világvége, Senki se tudja hol van tér 112.",
                Date.valueOf("2011-03-22"));

        Nászajándék ajándékGYJ = new Nászajándék("Gyuri és Juli közös ajándéka Tominak és Tamarának");
        ajándékGYJ.újAjándékozó(Gyuri);
        ajándékGYJ.újAjándékozó(Juli);
        házasságToTa.újNászajándék(ajándékGYJ);

        Nászajándék ajándékGyuri = new Nászajándék("Gyuri ajándéka Tominak és Tamarának");
        ajándékGyuri.újAjándékozó(Gyuri);
        házasságToTa.újNászajándék(ajándékGyuri);

        Nászajándék ajándékJuli = new Nászajándék("Juli ajándéka Tominak és Tamarának");
        ajándékJuli.újAjándékozó(Juli);
        házasságToTa.újNászajándék(ajándékJuli);

        ArrayList<Házasság> házasságok = new ArrayList<>();
        házasságok.add(házasságGYJ);
        házasságok.add(házasságToTa);

        for (Házasság házasság : házasságok) {
            házasság.szentesít();
            System.out.println(házasság.férj().név() + " és " + házasság.feleség().név() + " házasságot kötöttek "
                    + házasság.házasságkötésHelye() + " helyen " + házasság.házasságkötésIdeje() + " napon "
                    + "elõttünk, mint tanúk elõtt: " + házasság.férjTanúja().név() + " és " + házasság.feleségTanúja().név());
        }

        ArrayList<Személy> személyek = new ArrayList<>();
        személyek.add(Gyuri);
        személyek.add(Juli);
        személyek.add(Tamara);
        személyek.add(Tomi);

        for (Személy személy : személyek) {
            Személy házastárs = személy.házastárs();
            String házastársNév = házastárs == null ? "nincs, szingli" : házastárs.név();
            System.out.println(személy.név() + " házastársa: " + házastársNév);
        }

        try {
            new Házasság(Gyuri, Tamara, Tomi, Juli,
                    "999999 Világvége, Senki se tudja hol van tér 112.",
                    Date.valueOf("2013-03-19")).szentesít();
        } catch (BigámistaKivétel e) {
            System.out.println("-------------");
            System.out.println("Nana Gyuri és Tamara, azért ezt nem kéne...");
        }
        házasságGYJ.válás();

        System.out.println("-----------");
        System.out.println("Gyuri és Juli válása után:");
        System.out.println("-----------");

        for (Személy személy : személyek) {
            Személy házastárs = személy.házastárs();
            String házastársNév = házastárs == null ? "nincs, szingli" : házastárs.név();
            System.out.println(személy.név() + " házastársa: " + házastársNév);
        }

        try {
            házasságGYJ.válás();
        } catch (SzingliVálniAkarKivétel e) {
            System.out.println("----------");
            System.out.println(
                    "Gyuri és Juli már elváltak, de még egyszer el akarnak. "
                    + "Ennyire azért nem utálhatják egymást...");
        }
        
       
            new Házasság(Juli, Gyuri, Tomi, Tamara,
                "999999 Világvége, Senki se tudja hol van tér 112.",
                Date.valueOf("2015-03-19")).szentesít();
       

    }
}
