package factory;

public abstract class AbstractFactory <T>{
    public abstract T newInstance(String type);
}
