package singleton;

public class SingletonHungry {

    private static final SingletonHungry instance = new SingletonHungry();

    public SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}
