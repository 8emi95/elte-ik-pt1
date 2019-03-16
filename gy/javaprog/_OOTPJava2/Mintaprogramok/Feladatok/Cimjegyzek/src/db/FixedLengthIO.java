/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * FixedLengthIO.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * String beolvas�sa �s ki�r�sa RandomAccessFile-b�l adott hosszban
 */

package db;
import java.io.*;

class FixedLengthIO {
  // String beolvas�sa in-bol adott hosszban. in-bol beolvas size darab
  // karaktert, �s �ssze�ll�tja egy fix hossz�s�g� Stringg�.
  public static String readString(DataInput in, int size)
                                          throws IOException {
    char c[] = new char[size];
    for (int i=0; i<size; i++)
      c[i] = in.readChar();
    return new String(c);
  }

  // String ki�r�sa out-ra adott hosszban.
  // Az s stringet size hossz�s�g� karaktert�mbb� alak�tja, �s ki�rja out-ra:
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
