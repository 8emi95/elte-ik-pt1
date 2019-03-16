package java_bead_leny;

import java.util.ArrayList;
import java.util.Scanner;

public class Verseny {

    /**
     * @param args the command line arguments
     */
    ArrayList<Leny> lenyek = new ArrayList<>();
    ArrayList<Character> days = new ArrayList<>();
    public static void main(String[] args) {
        Beolvaso beolvas = new Beolvaso();
        Verseny v = new Verseny();
        v.readIn(beolvas);
        v.vezerles();
        v.selectWinner();
    }
    /**
     * Bekér konzolról egy fájlnevet és ha tudja beolvassa a fájlt és feltölti a lenyek és days ArrayListeket.
     * @param beolvas a beolvasó osztály egy példánya
     */
    private  void readIn(Beolvaso beolvas) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fajlnev: ");
        String fileName = sc.nextLine();
        sc.close();
        beolvas.read(fileName, lenyek, days);
    }
    
    private void vezerles() {
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i) == 'n') {
                for (int j = 0; j < lenyek.size(); j++) {
                    lenyek.get(j).sunny();

                }
            }
            else if (days.get(i) == 'f') {
                for (int j = 0; j < lenyek.size(); j++) {
                    lenyek.get(j).cloudy();

                }
            }
            else if (days.get(i) == 'e') {
                for (int j = 0; j < lenyek.size(); j++) {
                    lenyek.get(j).rainy();
                }
            }
        }
    }
    
    private  void selectWinner() {
        if(lenyek.size()>0){
            Leny winner = lenyek.get(0);
            boolean found=false;
            for (int i = 0; i < lenyek.size(); i++) {
                if (winner.roadSoFar() <= lenyek.get(i).roadSoFar() && lenyek.get(i).isAlive()) {
                    winner = lenyek.get(i);
                    found=true;
                }
            }
            if(found){
                System.out.println("A győztes lény: " + winner.getName() + "\nMegtett út: " + winner.roadSoFar());
            }
            else{
                System.out.println("Nem volt olyan lény, aki túlélte volna a versenyt!");
            }
            
        }
        else{
            System.out.println("Nem indult el a versenyen egyetlen lény sem!");
        }
    }

}
