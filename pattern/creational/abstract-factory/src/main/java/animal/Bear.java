package animal;

public class Bear implements Animal{
    @Override
    public String getType() {
        return "BEAR";
    }

    @Override
    public String makeSound() {
        return "roar";
    }
}
