package 多线程.交替打印ABC;

import java.util.concurrent.Semaphore;

/**
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串。
 *
 * 使用Semaphore
 *
 * 信号量主要用于两个目的: 一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * acquire（获取） 当一个线程调用 acquire 操作时，它要么通过成功获取信号量（信号量减1），要么一直等下去，直到有线程释放信号量，或超时。
 * release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。
 */
public class PrintABCUsingSemaphore {
    private int times;
    private static Semaphore semaphoreA = new Semaphore(1);  // 只有A 初始信号量为1,第一次获取到的只能是A
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public PrintABCUsingSemaphore(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingSemaphore printer = new PrintABCUsingSemaphore(3);

        new Thread(() -> printer.print("A", semaphoreA, semaphoreB)).start();
        new Thread(() -> printer.print("B", semaphoreB, semaphoreC)).start();
        new Thread(() -> printer.print("C", semaphoreC, semaphoreA)).start();
    }

    public void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < times; i++) {
            try {
                current.acquire();  // A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                System.out.println(name);
                next.release();     // B释放信号，B信号量加1（初始为0），此时可以获取B信号量
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
