package singleton;

public class SingletonEnum {

    public SingletonEnum() {
    }

    public enum Singleton {
        INSTANCE;

        private SingletonEnum instance;

        Singleton() {
            instance = new SingletonEnum();
        }

        public SingletonEnum getInstance() {
            return instance;
        }
    }

    public static SingletonEnum getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
