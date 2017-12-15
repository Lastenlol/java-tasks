package ae.lesson.second.taxi;

import ae.lesson.second.taxi.exception.InvalidFuelConsumptionException;
import ae.lesson.second.taxi.exception.InvalidPriceException;

import java.io.Serializable;

public class Car implements Pricing, Serializable {

    String model;
    CarType type;

    private double price;
    private double fuelConsumption;

    public Car(String model, double price, double fuelConsumption, CarType type) throws InvalidPriceException, InvalidFuelConsumptionException {
        if (price < 0) throw new InvalidPriceException();
        if (fuelConsumption < 0) throw new InvalidFuelConsumptionException();

        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public Car setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public Car setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public String toString() {
        return this.model + ", $" + price + ", fuel: " + fuelConsumption;
    }
}
