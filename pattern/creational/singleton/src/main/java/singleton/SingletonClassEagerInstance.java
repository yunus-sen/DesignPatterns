package singleton;

public class SingletonClassEagerInstance {
    private static SingletonClassEagerInstance instance;

    static {
        instance = new SingletonClassEagerInstance();
    }

    private SingletonClassEagerInstance() {
    }

    public static SingletonClassEagerInstance getInstance() {
        return instance;
    }
}
