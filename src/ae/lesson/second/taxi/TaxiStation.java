package ae.lesson.second.taxi;

import ae.lesson.second.taxi.repository.ArrayRepository;

import java.io.Serializable;
import java.util.Collection;

public class TaxiStation implements Pricing, Serializable {

    protected ArrayRepository<Car> carRepository = new ArrayRepository<>();

    public TaxiStation() { }

    public TaxiStation(Collection<Car> cars) {
        carRepository.add(cars);
    }

    public void addCar(Car car) {
        carRepository.add(car);
    }

    public Collection<Car> getCars() {
        return carRepository.findAll();
    }

    public Collection<Car> getSortedCarsByFuelConsumption() {
        return carRepository.findAll((a, b) -> (int) (a.getFuelConsumption() - b.getFuelConsumption()));
    }

    public double getPrice() {
        return carRepository.findAll()
                .stream()
                .reduce(0.0, (sum, car) -> sum += car.getPrice(), (sum1, sum2) -> sum1 + sum2);
    }

}
