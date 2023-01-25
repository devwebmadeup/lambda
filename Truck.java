package factory;

public class Truck implements VehicleFactory1.Vehicle {
    private final VehicleFactory1.VehicleColor color;

    public Truck(VehicleFactory1.VehicleColor color) {
        this.color = color;
    }

    public VehicleFactory1.VehicleColor color() {
        return color;
    }
}
