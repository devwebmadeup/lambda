package factory;

import java.util.StringJoiner;

public class Car implements VehicleFactory1.Vehicle {
    private final VehicleFactory1.VehicleColor color;

    public Car(VehicleFactory1.VehicleColor color) {
        this.color = color;
    }

    @Override
    public VehicleFactory1.VehicleColor color() {
        return color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("color=" + color)
                .toString();
    }
}
