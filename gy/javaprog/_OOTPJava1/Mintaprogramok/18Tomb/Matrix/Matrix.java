/*
 * Mintaprogramok/18. fejezet
 * Matrix.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Matrix {
  static int printN = 0;   // A printelés száma
  static int[][] matrix = new int[5][3]; // 5 sor, 3 oszlop

  // A mátrix kiírása soronként:
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
    System.out.println("Sorok száma   ="+matrix.length);
    System.out.println("Oszlopok száma="+matrix[0].length);

    // A mátrix feltöltése 1, 2, 3 ... értékekkel sorfolytonosan:
    int ertek=0;
    for (int i=0; i<5; i++)
      for (int j=0; j<3; j++)
        matrix[i][j] = ++ertek;
    printMatrix();                 // mátrix kiírása       //1

    // A 2. sor átmásolása az 1. sorba:
    System.arraycopy(matrix[2],0,matrix[1],0,matrix[1].length);
    printMatrix();                 // mátrix kiírása       //2

    // A 2. sor 1. eleme 999 lesz:
    matrix[2][1] = 999;
    printMatrix();                 // mátrix kiírása       //3

    // 2. oszlop feltöltése 0 értékekkel:
    for (int i=0; i<5; i++)
      matrix[i][2] = 0;
    printMatrix();                 // mátrix kiírása       //4

    // Ezen értékadás után a 0. sor ugyanaz lesz,
    // mint a 4. sor (ettõl kezdve mindig!).
    // A két referencia ugyanarra az tömbre mutat.
    matrix[0] = matrix[4];         // A 0. sor elvész!
    printMatrix();                 // mátrix kiírása       //5

    // Értékadás a 4. sor 1. elemnek. A 0. sor 1. elem is változik.
    matrix[4][1] = -1;
    printMatrix();                 // mátrix kiírása       //6
  }
}
