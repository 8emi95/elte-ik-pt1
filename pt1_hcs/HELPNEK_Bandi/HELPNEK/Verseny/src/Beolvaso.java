import java.io.*;
import java.util.*;

 /** A szöveges fájl beolvasása. */
public class Beolvaso {
     /** Minden fájl elején van egy szám, ami az induló lények számát jelenti.
      Ennek megfelelően beolvassa a lényeket, és eltárolja azokat.
      Majd beolvassa a napokat.
      Ha valamilyen hiba lép fel a fájl olvasásakor, a program leállítja a futást és egy hibaüzenetet ad.
       @param fileName A fájl neve
       @param lenyek Az induló versenyzők
       @param days A verseny napjai*/
    public void read(String fileName, ArrayList<Leny> lenyek, ArrayList<Character> days) {
        try {
            File file = new File(fileName);
            if(file.length()==0){
                System.out.println("A fájl üres!");
                System.exit(2);
            }
            else{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                String name, type, currentWater;
                int count = Integer.parseInt(br.readLine());
                for (int i = 0; i < count; i++) {
                    line = br.readLine();
                    String[] splitted = line.split(" ");
                    name = splitted[0];
                    type = splitted[1];
                    currentWater = splitted[2];
                    if (type.equals("h")) {
                        lenyek.add(new Homokjaro(name, Integer.parseInt(currentWater)));
                    }
                    else if (type.equals("s")) {
                        lenyek.add(new Szivacs(name, Integer.parseInt(currentWater)));
                    }
                    else if (type.equals("l")) {
                        lenyek.add(new Lepegeto(name, Integer.parseInt(currentWater)));
                    }
                }
                line = br.readLine();
                for (int i = 0; i < line.length(); i++) {
                    days.add(line.charAt(i));
                }
                br.close();
            }
        } 
        catch (IOException ex) {
            System.out.println("Valamilyen hiba lépett fel a fájl olvasása közben!");
            System.exit(2);
        }
    }
}