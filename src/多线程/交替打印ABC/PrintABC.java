package 多线程.交替打印ABC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串。
 *
 * 使用Lock
 *
 * 参考文章: https://zhuanlan.zhihu.com/p/270171164
 */
public class PrintABC {

    private int times;   // 打印次数
    private int state = 0;   // 状态值
    private Lock lock = new ReentrantLock();

    public PrintABC(int times) {
        this.times = times;
    }

    public void doPrintLetters(String name, int target) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == target) {
                state++;
                i++;  // 注意i++ 要写在里面
                System.out.println(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC(2);

        new Thread(() -> {
            printABC.doPrintLetters("A", 0);
        }, "A").start();

        new Thread(() -> {
            printABC.doPrintLetters("B", 1);
        }, "B").start();

        new Thread(() -> {
            printABC.doPrintLetters("C", 2);
        }, "C").start();
    }


}
