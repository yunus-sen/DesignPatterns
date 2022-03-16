package animal;

public class Duck implements Animal{
    @Override
    public String getType() {
        return "DUCK";
    }

    @Override
    public String makeSound() {
        return "Squeks";
    }
}
