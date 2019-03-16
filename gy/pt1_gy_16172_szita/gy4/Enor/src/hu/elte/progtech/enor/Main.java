package hu.elte.progtech.enor;

public class Main {
    public static String FILE_NAME = "resources/matches.txt";

    public static void main(String args[]) {
        Enor t = new Enor(FILE_NAME);
        for (t.First(); !t.End(); t.Next()) {
            System.out.println(t.Current());
        }
    }

}
