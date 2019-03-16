package java_bead_leny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Beolvaso {
    /*
     * @param fileName A fájl neve
     * @param lenyek Az induló versenyzők
     * @param days A verseny napjai
     */
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
                String name, type, watertouse;
                int count = Integer.parseInt(br.readLine());
                for (int i = 0; i < count; i++) {
                    line = br.readLine();
                    String[] darabolt = line.split(" ");
                    name = darabolt[0];
                    type = darabolt[1];
                    watertouse = darabolt[2];
                    if (type.equals("h")) {
                        lenyek.add(new Homokjaro(name, Integer.parseInt(watertouse)));
                    }
                    else if (type.equals("s")) {
                        lenyek.add(new Szivacs(name, Integer.parseInt(watertouse)));
                    }
                    else if (type.equals("l")) {
                        lenyek.add(new Lepegeto(name, Integer.parseInt(watertouse)));
                    }
                }
                line = br.readLine();
                for (int i = 0; i < line.length(); i++) {
                    days.add(line.charAt(i));
                }
                br.close();
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("Nem található ilyen fájl!");
            System.exit(2);
        } 
        catch (IOException ex) {
            System.out.println("Valamilyen hiba lépett fel a fájl olvasása közben!");
            System.exit(2);
        }
    }

}
