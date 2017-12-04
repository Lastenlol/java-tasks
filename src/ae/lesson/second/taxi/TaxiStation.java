package ae.lesson.second.taxi;

import ae.lesson.second.taxi.repository.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class TaxiStation implements Pricing, Serializable {

    protected Repository<Car> carRepository = new Repository<>();

    public TaxiStation() { }

    public TaxiStation(Collection<Car> cars) {
        carRepository.add(cars);
    }

    public void addCar(Car car) {
        carRepository.add(car);
    }

    public List<Car> getSortedCarsByFuelConsumption() {
        return carRepository.findAll((a, b) -> (int) (a.fuelConsumption - b.fuelConsumption));
    }

    public double getPrice() {
        return carRepository.findAll()
                .stream()
                .reduce(0.0, (sum, car) -> sum += car.getPrice(), (sum1, sum2) -> sum1 + sum2);
    }

}
