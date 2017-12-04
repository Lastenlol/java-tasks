package ae.lesson;

import ae.common.Lesson;
import ae.lesson.second.taxi.TaxiStation;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SixthLesson extends Lesson {

    public void run() {
        task1();
    }

    protected static void task1() {
        // создание и запись объекта

        TaxiStation station = new TaxiStation();

        File fw = new File("demo.dat");
        try {
            ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(fw));

            ostream.writeObject(station);
            ostream.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        File fr = new File("demo.dat");
        try {
            ObjectInputStream istream = new ObjectInputStream(new FileInputStream(fr));

            TaxiStation unknown = (TaxiStation) istream.readObject();
            istream.close();
            System.out.println(unknown);
        } catch (ClassNotFoundException ce) {
            System.err.println(ce);
            System.err.println("Класс не существует");
        } catch (FileNotFoundException fe) {
            System.err.println(fe);
            System.err.println("Файл не найден");
        } catch (IOException ioe) {
            System.err.println(ioe);
            System.err.println("Ошибка доступа");
        }
    }

}
