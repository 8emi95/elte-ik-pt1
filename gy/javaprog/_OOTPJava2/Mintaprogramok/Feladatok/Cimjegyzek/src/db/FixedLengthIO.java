/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * FixedLengthIO.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * String beolvasása és kiírása RandomAccessFile-ból adott hosszban
 */

package db;
import java.io.*;

class FixedLengthIO {
  // String beolvasása in-bol adott hosszban. in-bol beolvas size darab
  // karaktert, és összeállítja egy fix hosszúságú Stringgé.
  public static String readString(DataInput in, int size)
                                          throws IOException {
    char c[] = new char[size];
    for (int i=0; i<size; i++)
      c[i] = in.readChar();
    return new String(c);
  }

  // String kiírása out-ra adott hosszban.
  // Az s stringet size hosszúságú karaktertömbbé alakítja, és kiírja out-ra:
  public static void writeString(DataOutput out, String s,
                               int size) throws IOException {
    char buffer[] = new char[size];
    int len = s.length();
    if (len > size)
      len = size;
    s.getChars(0, len, buffer, 0);
    for (int i=len; i<buffer.length; i++)
      buffer[i] = ' ';
    out.writeChars(new String(buffer));
  }
}
