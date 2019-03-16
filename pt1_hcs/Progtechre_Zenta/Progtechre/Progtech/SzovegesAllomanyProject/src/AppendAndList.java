import java.io.*;
import extra.Console;

public class AppendAndList {

    private String path;

    public AppendAndList(String path) {
        this.path = path;
        appendText();
        listText();
    }

    void appendText() {
        try {
            FileWriter fw = new FileWriter(path, true);
            String line;
            while (!(line = Console.readLine("sor: ")).equals("")) {
                fw.write(line + "\r\n");
            }
            fw.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    void listText() {
        try {
            FileReader fr = new FileReader(path);
            System.out.println("Lista:");
            while (fr.ready())
                System.out.print((char)fr.read());
            fr.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new AppendAndList("Szoveg.txt");
    }

}
