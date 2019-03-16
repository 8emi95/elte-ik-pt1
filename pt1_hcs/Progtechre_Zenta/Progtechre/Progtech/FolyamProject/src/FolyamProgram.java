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

public class FolyamProgram {

    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("adatok.dat"));
            dos.writeByte(65);
            dos.writeDouble(12.4);
            dos.writeInt(2000);
            dos.writeBoolean(true);
            dos.writeChar('C');
            dos.close();
            
            DataInputStream dis=new DataInputStream( new FileInputStream("adatok.dat"));
            byte b= dis.readByte();
            System.out.println(b);
            double d = dis.readDouble();
            System.out.println(d);
            int i= dis.readInt();
            System.out.println(i);
            boolean bo = dis.readBoolean();
            System.out.println(bo);
            char c = dis.readChar();
            System.out.println(c);
            dis.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
