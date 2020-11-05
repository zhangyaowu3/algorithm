package 设计模式.单例模式;


public class HungrySingleton {

    private HungrySingleton() {

    }

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

}
