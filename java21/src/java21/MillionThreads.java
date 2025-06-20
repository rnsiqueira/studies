package java21;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MillionThreads {

    private static final int COUNT = 1_000_000;

    public static void main(String[] args) {

        createMillionThreads();
        createMillionThreadsUsingExecutorsV1();
        createMillionThreadsUsingExecutorsV2();
    }

    public static void createMillionThreadsUsingExecutorsV2() {

        AtomicInteger atomicInteger = new AtomicInteger();
        var start = System.currentTimeMillis();

        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            IntStream.range(0,1_000_000)
                    .forEach( i -> executor.submit(atomicInteger::incrementAndGet));
        }
        var end = System.currentTimeMillis();

        System.out.println("Time : " + (end-start));
        System.out.println("Finished creating and executing million threads: " + atomicInteger.get());
    }

    public static void createMillionThreadsUsingExecutorsV1() {
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor())
        {
            for(var i =0; i < COUNT;i++){
                String taskName = "task: "+i;
                executor.submit(() -> run(taskName));
            }
        }
    }
    public static void run(Object o){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ie){
            throw new RuntimeException(ie);
        }
        System.out.println(o);
    }

    public static void createMillionThreads() {

        CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        for(var i = 0; i< COUNT;i++){
            Thread.startVirtualThread( () -> {
                try{
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                }catch(InterruptedException ie){
                    throw new RuntimeException(ie);
                }
            });
        }
    }
}
