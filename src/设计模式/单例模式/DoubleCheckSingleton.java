package 设计模式.单例模式;

public class DoubleCheckSingleton {

    /**
     * 为什么必须要加volatile关键字?
     * 主要用来避免重排序问题导致其他的线程看到了一个已经分配内存和地址但没有初始化的对象，
     * 也就是说这个对象还不是处于可用状态，就被其他线程引用了。
     *
     * 关于volatile和null的解释
     * https://cloud.tencent.com/developer/article/1161095
     * https://www.cnblogs.com/ring2/p/11401809.html
     */
    private DoubleCheckSingleton() {

    }
    private static volatile DoubleCheckSingleton instance = null;

    public static DoubleCheckSingleton getInstance() {
        // 第一层检查
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                // 第二层检查
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
