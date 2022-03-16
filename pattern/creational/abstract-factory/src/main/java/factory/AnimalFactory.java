package factory;

import animal.Animal;
import animal.Bear;
import animal.Dog;
import animal.Duck;

public class AnimalFactory extends AbstractFactory<Animal> {
    @Override
    public Animal newInstance(String type) {
        if ("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(type)) {
            return new Duck();
        } else if ("Bear".equalsIgnoreCase(type)) {
            return new Bear();
        }
        return null;
    }
}
