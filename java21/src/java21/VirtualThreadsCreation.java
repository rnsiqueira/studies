package java21;

/**
 * Shows how virtual threads can be created.
 */
public class VirtualThreadsCreation {

    public static void main(String[] args) throws InterruptedException {

        //Platform thread.
        var pt = new Thread(() -> System.out.println("Starting (Platform) Threads " + Thread.currentThread()));
        pt.start();
        pt.join();

        //Virtual thread.
        var vt = Thread.startVirtualThread(() -> System.out.println("Starting (Virtual) Threads"));
        vt.join();

        //using builder
        var vtWithBuilder =
                Thread.ofVirtual()
                        .name("Virtual thread using builder")
                        .start(() -> System.out.println(Thread.currentThread()));

        vtWithBuilder.join();

        //using builder but not started
        var notStartedVtWithBuilder =
                Thread.ofVirtual()
                        .name("Un-started Virtual thread using builder")
                        .unstarted(() -> System.out.println(Thread.currentThread()));

        notStartedVtWithBuilder.start();
        notStartedVtWithBuilder.join();

    }
}
