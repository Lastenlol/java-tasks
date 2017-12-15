package ae.lesson.sixth;

import ae.common.Lesson;
import ae.lesson.second.taxi.TaxiStation;

import java.io.*;

public class SixthLesson extends Lesson {

    public void run() {
        task1();
    }

    protected static void task1() {
        TaxiStation station = new TaxiStation();

        final String fileName = "station.dat";

        File fw = new File(fileName);
        try {
            ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(fw));

            ostream.writeObject(station);
            ostream.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        File fr = new File(fileName);
        try {
            ObjectInputStream istream = new ObjectInputStream(new FileInputStream(fr));

            TaxiStation unknown = (TaxiStation) istream.readObject();
            istream.close();
            System.out.println(unknown);
        } catch (ClassNotFoundException ce) {
            System.err.println(ce.toString());
            System.err.println("Класс не существует");
        } catch (FileNotFoundException fe) {
            System.err.println(fe.toString());
            System.err.println("Файл не найден");
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
            System.err.println("Ошибка доступа");
        }
    }

}
