package ae.lesson.second;

import ae.common.Lesson;
import ae.lesson.second.taxi.Car;
import ae.lesson.second.taxi.CarType;
import ae.lesson.second.taxi.TaxiStation;
import ae.lesson.second.taxi.exception.InvalidFuelConsumptionException;
import ae.lesson.second.taxi.exception.InvalidPriceException;

public class SecondLesson extends Lesson {

    public void run() {
        task1();
    }

    public void task1() {
        TaxiStation station = mockData();
        System.out.println(station.getPrice());
        System.out.println(station.getSortedCarsByFuelConsumption());
    }

    public static TaxiStation mockData() {
        TaxiStation station = new TaxiStation();

        try {
            station.addCar(new Car("Hyundai Sonata", 21000, 15, CarType.MOTOR));
            station.addCar(new Car("Mercedes Bus Edition", 15000, 20, CarType.BUS));
            station.addCar(new Car("Gruzovichok ø", 100000, 45, CarType.TRUCK));
        } catch (InvalidPriceException | InvalidFuelConsumptionException e) {
            System.out.println("Invalid car data");
        }

        return station;
    }

}
