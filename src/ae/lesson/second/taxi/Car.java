package ae.lesson.second.taxi;

import java.io.Serializable;

public class Car implements Pricing, Serializable {

    String model;

    protected double price;
    protected double fuelConsumption;

    public Car(String model, double price, double fuelConsumption) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
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
}
