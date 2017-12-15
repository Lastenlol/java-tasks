package ae.lesson.second.taxi;

import ae.lesson.second.taxi.repository.Criteria;

public class CarCriteria implements Criteria<Car> {

    public String model = "";
    public CarType type = CarType.MOTOR;

    public double price = 0;
    public double fuelConsumption = 0;

    public boolean test(Car car) {
        return car.model.equals(model) && type == car.type && price == car.getPrice() && fuelConsumption == car.getFuelConsumption();
    }

}
