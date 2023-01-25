package factory;

import java.util.StringJoiner;

public class Bus implements VehicleFactory1.Vehicle {
    private final VehicleFactory1.VehicleColor color;

    public Bus(VehicleFactory1.VehicleColor color) {
        this.color = color;
    }

    public VehicleFactory1.VehicleColor color() {
        return color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bus.class.getSimpleName() + "[", "]")
                .add("color=" + color)
                .toString();
    }
}
