/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zentaidavid
 */
import java.io.*;

public class PrintWriterTest {

    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("print.txt"));
            writer.println("double: " + 12.78);
            writer.print('A');
            writer.println(new Integer(66));
            writer.close();
            
            FileReader reader=new FileReader("print.txt");
            while (reader.ready()) {
                char ch=(char)reader.read();
                System.out.print(ch);
            }
            reader.close();
        }
        catch (IOException ex){
            
        }
    }
}
