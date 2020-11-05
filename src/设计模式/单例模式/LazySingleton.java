package 设计模式.单例模式;

public class LazySingleton {

    private LazySingleton() {}

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            return instance = new LazySingleton();
        } else {
            return instance;
        }
    }
}
