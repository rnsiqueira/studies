package ilearn.thread;

public class ThreadPratic extends Thread {

    public ThreadPratic() {
        System.out.println(getNextValueId());
        System.out.println(getOddValueId());
    }


    private static int valueId = 42;

    private static synchronized int getNextValueId() {
        return ++valueId;
    }

    public synchronized static int getOddValueId() {
        return --valueId;
    }

    @Override
    public void run() {
        int i = 0;
        while (i <= 4) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i <= 10000; i++) {
            new ThreadPratic().start();

        }
    }
}

