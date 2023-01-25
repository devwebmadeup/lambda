package factory;

import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class VehicleFactory1 {

    enum VehicleColor {
        RED,
        BLUE,
        BLACK,
        WHITE
    }

    interface Vehicle {
        VehicleColor color();

    }

    enum VehicleType {
        BUS,
        TRUCK,
        CAR
    }

    enum VehicleFactory {
        CAR(Car::new, VehicleType.CAR::equals),
        BUS(Bus::new, VehicleType.BUS::equals);

        final Function<VehicleColor, Vehicle> factory;
        final Predicate<VehicleType> isVehicleType;

        VehicleFactory(Function<VehicleColor, Vehicle> factory, Predicate<VehicleType> isVehicleType) {
            this.factory = factory;
            this.isVehicleType = isVehicleType;
        }

        static VehicleFactory findVehicle(final VehicleType vehicleType) {
            return Arrays.stream(VehicleFactory.values())
                    .filter(factory -> factory.isVehicleType.test(vehicleType))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("해당하는 Vehicle 없습니다"));
        }

        public Vehicle paintedVehicle(VehicleColor vehicleColor) {
            return this.factory.apply(vehicleColor);
        }
    }

    @Test
    public void VehicleFactory() {
        VehicleFactory vehicleFactory = VehicleFactory.findVehicle(VehicleType.CAR);
        Vehicle vehicle = vehicleFactory.paintedVehicle(VehicleColor.BLUE);
        System.out.println(vehicle.toString());
    }



}
