package java21;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Example shows how virtual threads can be pinned.
 */
public class PinnedVirtualThreads {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        var threads = IntStream.range(0, 10)
                .mapToObj(index -> Thread.ofVirtual()
                        .unstarted(() -> {
                            if (index == 5) {
                                System.out.println("Before locking thread  : " + Thread.currentThread());
                            }
                            synchronized (lock) {
                                try {
                                    counter++;
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if (index == 5) {
                                System.out.println("After unlocking thread : " + Thread.currentThread());
                            }
                        }))
                .toList();

        //Invoke start on all threads
        threads.forEach(Thread::start);
        //Join
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Counter  : " + counter);
    }
}
