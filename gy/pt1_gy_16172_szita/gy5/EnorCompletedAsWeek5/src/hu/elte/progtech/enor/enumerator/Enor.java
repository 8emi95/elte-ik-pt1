package hu.elte.progtech.enor.enumerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

enum Status {
    NORM, ABNORM
}

public class Enor<T> {

    private Status sx = Status.NORM;
    private T dx;
    private Scanner x;
    private Parser<T> parser;

    public Enor(String fileName, Parser<T> parser) {
        try {
            this.parser = parser;
            x = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            sx = Status.ABNORM;
        }
    }

    public void First() {
        Next();
    }

    public boolean End() {
        return Status.ABNORM.equals(sx);
    }

    public void Next() {
        if (x.hasNext()) {
            dx = parser.parse(x.nextLine());
        } else {
            sx = Status.ABNORM;
            x.close();
        }
    }

    public T Current() {
        return dx;
    }

}
