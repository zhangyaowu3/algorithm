package 设计模式.单例模式;

public class Test {

    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        System.out.println(hungrySingleton.hashCode());
        System.out.println(hungrySingleton1.hashCode());

    }

     static class HungrySingleton {

        private HungrySingleton() {

        }

        private static HungrySingleton instance = new HungrySingleton();

        private static HungrySingleton getInstance() {
            return instance;
        }

    }
}
