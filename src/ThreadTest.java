import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest extends Thread{
    public static int threadcounter = 0;
    @Override
    public void run() {
        threadcounter++;
    }

    public static void main(String[] args) {
        for (int i =0; i < 10 ; i++) {
            synchronized (ThreadTest.class) {
            System.out.println(threadcounter);
                new ThreadTest().run();
           }
        }
    }
}

