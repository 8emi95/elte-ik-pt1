import java.io.*;
import java.*;
import java.util.*;
import extra.Console;

public class CreatureProject {

    private ArrayList<Creatures> livings;

    public CreatureProject() {
        livings = new ArrayList<Creatures>();
    }
    
    public static void main(String[] args) {
        CreatureProject cp = new CreatureProject();
    }
    
    public void FileRead(ArrayList<Creatures> livings){
        int n;
        String fileName = Console.readLine("\nFilename: ");
        try {
            System.out.println("Lista:");
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            n = Integer.parseInt(br.readLine());
            String line = "";
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                String[] piece = line.split(" ");
                name = piece[0];
                type = piece[1];
                watertouse = piece[2];
            }
            //while (fr.ready())
            //    System.out.print((char)fr.read());
            fr.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }     
    }
}
