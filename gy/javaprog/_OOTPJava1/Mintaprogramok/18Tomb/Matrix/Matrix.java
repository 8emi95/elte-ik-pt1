/*
 * Mintaprogramok/18. fejezet
 * Matrix.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Matrix {
  static int printN = 0;   // A printel�s sz�ma
  static int[][] matrix = new int[5][3]; // 5 sor, 3 oszlop

  // A m�trix ki�r�sa soronk�nt:
  static void printMatrix() {
    printN++;
    System.out.println("---- "+printN+" -----");
    for (int i=0; i<5; i++) {
      for (int j=0; j<3; j++)
        System.out.print(Format.right(matrix[i][j],4));
      System.out.println();
    }
  }

  public static void main(String[] args) {
    System.out.println("Sorok sz�ma   ="+matrix.length);
    System.out.println("Oszlopok sz�ma="+matrix[0].length);

    // A m�trix felt�lt�se 1, 2, 3 ... �rt�kekkel sorfolytonosan:
    int ertek=0;
    for (int i=0; i<5; i++)
      for (int j=0; j<3; j++)
        matrix[i][j] = ++ertek;
    printMatrix();                 // m�trix ki�r�sa       //1

    // A 2. sor �tm�sol�sa az 1. sorba:
    System.arraycopy(matrix[2],0,matrix[1],0,matrix[1].length);
    printMatrix();                 // m�trix ki�r�sa       //2

    // A 2. sor 1. eleme 999 lesz:
    matrix[2][1] = 999;
    printMatrix();                 // m�trix ki�r�sa       //3

    // 2. oszlop felt�lt�se 0 �rt�kekkel:
    for (int i=0; i<5; i++)
      matrix[i][2] = 0;
    printMatrix();                 // m�trix ki�r�sa       //4

    // Ezen �rt�kad�s ut�n a 0. sor ugyanaz lesz,
    // mint a 4. sor (ett�l kezdve mindig!).
    // A k�t referencia ugyanarra az t�mbre mutat.
    matrix[0] = matrix[4];         // A 0. sor elv�sz!
    printMatrix();                 // m�trix ki�r�sa       //5

    // �rt�kad�s a 4. sor 1. elemnek. A 0. sor 1. elem is v�ltozik.
    matrix[4][1] = -1;
    printMatrix();                 // m�trix ki�r�sa       //6
  }
}
