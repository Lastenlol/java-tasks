package ae.lesson.second;

import ae.common.Lesson;
import ae.lesson.second.taxi.TaxiStation;

public class SecondLesson extends Lesson {

    public void run() {
        task1();
    }

    public void task1() {
        TaxiStation station = new TaxiStation();
        station.getPrice();
    }

}
