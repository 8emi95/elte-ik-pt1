/*
 * Projekt: Tilitoli
 *
 * Csomag: play
 * Result.java

 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A játék eredményét (név, idõ, lépések száma) eltároló objektum.
 * Rendezési szempont: idõ + lépések száma.
 */

package play;

import java.io.Serializable;
import extra.Format;

public class Result implements Comparable, Serializable {
  private String name = "";
  private int time;
  private int numberOfSteps;

  public Result(String name, int time, int numberOfSteps) {
    this.name = name;
    this.time = time;
    this.numberOfSteps = numberOfSteps;
  }

  public Result(int time, int numberOfSteps) {
    this("",time,numberOfSteps);
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTime() {
    return time;
  }

  public int getNumberOfSteps() {
    return numberOfSteps;
  }

  // this < obj, ha az idõ, azon belül a lépés kisebb:
  public int compareTo(Object obj) {
    int ido = (int)(time - ((Result)obj).getTime());
    if (ido != 0)
      return ido;
    return numberOfSteps - ((Result)obj).getNumberOfSteps();
  }

  // Kiegészítés balról 0-val:
  private String str(int n) {
    return (n<10)? "0"+n : ""+n;
  }

  public String toString() {
    return Format.left(name,20)+Format.right(str(time/60),4)+
        ":"+str(time%60)+Format.right(numberOfSteps,6);
  }

} // Result
