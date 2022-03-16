package animal;

public class Dog implements Animal{
    @Override
    public String getType() {
        return "DOG";
    }

    @Override
    public String makeSound() {
        return "bark";
    }
}
