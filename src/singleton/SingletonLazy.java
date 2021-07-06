package singleton;

public class SingletonLazy {
    private volatile SingletonLazy instance;

    public SingletonLazy() {
    }

    public SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
