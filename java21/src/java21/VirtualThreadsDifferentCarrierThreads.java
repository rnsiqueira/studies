package java21;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Example shows how virtual threads can land up on different carrier threads
 * during its lifetime.
 */
public class VirtualThreadsDifferentCarrierThreads {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger();

        var threads =
                IntStream.range(0, 200)
                        .mapToObj(index -> Thread.ofVirtual().unstarted(() ->
                                {
                                    try {
                                        if (index == 5) {
                                            System.out.println("Going to sleep : " + Thread.currentThread());
                                        }
                                        Thread.sleep(1000);
                                        if (index == 5) {
                                            System.out.println("Up and running : " + Thread.currentThread());
                                        }
                                        atomicInteger.incrementAndGet();
                                    } catch (InterruptedException ie) {
                                        throw new RuntimeException(ie);
                                    }
                                }))
                        .toList();

        //Invoke start on all threads
        threads.forEach(Thread::start);
        //Join
        for(Thread t:threads){
            t.join();
        }
        System.out.println("Counted threads : "+ atomicInteger.get());
    }
}
