/*
 * Mintaprogramok/16. fejezet
 * DatumBontas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

public class DatumBontas {
  public static void main(String[] args) {
    String datumStr = "1978.03.15.";
    StringTokenizer dt = new StringTokenizer(datumStr,".");
    int ev = Integer.parseInt(dt.nextToken());
    int ho = Integer.parseInt(dt.nextToken());
    int nap = Integer.parseInt(dt.nextToken());
    System.out.println("�v: "+ev+" H�: "+ho+" Nap: "+nap);
  }
}

