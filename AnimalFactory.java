package factory;

import org.junit.Test;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AnimalFactory {

    public enum AnimalType {
        CAT, DOG, NONE
    }

    static Map<AnimalType, Supplier<? extends Animal>> map = new HashMap<>();

    static {
        map.put(AnimalType.CAT, Cat::new);
        map.put(AnimalType.DOG, Dog::new);
    }

    static Supplier<? extends Animal> getAnimal(final AnimalType animalType) {

        return map.entrySet().stream()
                .filter(key -> key.getKey().equals(animalType))
                .findFirst()
                .map(Map.Entry::getValue)
                .get();


    }

    @Test
    public void FactoryTest() {
        Supplier<? extends Animal> animal = AnimalFactory.getAnimal(AnimalType.DOG);
        Animal an = animal.get();
        an.walk();

    }
}
