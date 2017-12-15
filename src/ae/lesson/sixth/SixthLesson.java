package ae.lesson.sixth;

import ae.common.Lesson;
import ae.lesson.second.SecondLesson;
import ae.lesson.second.taxi.TaxiStation;

import java.io.*;
import java.util.Arrays;

public class SixthLesson extends Lesson {

    public void run() {
        task1();
    }

    protected static void task1() {
        TaxiStation station = SecondLesson.mockData();

        final String filePath = "station.dat";

        File fw = new File(filePath);
        try {
            ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(fw));

            ostream.writeObject(station);
            ostream.close();
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        File fr = new File(filePath);
        try {
            ObjectInputStream istream = new ObjectInputStream(new FileInputStream(fr));

            TaxiStation deserializedStation = (TaxiStation) istream.readObject();
            istream.close();

            System.out.println(deserializedStation);
            System.out.println(Arrays.toString(deserializedStation.getCars().toArray()));
        } catch (ClassNotFoundException ce) {
            System.err.println("Class " + ce.getClass().getName() + " not found");
        } catch (FileNotFoundException fe) {
            System.err.println("File " + filePath + " not found");
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

}
