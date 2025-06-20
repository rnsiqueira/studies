package ilearn.thread;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ThreadingPloblemTest {

    @Test
    public void TwothreadsShouldFailEventually() throws InterruptedException {
        final WithThreadingProblem withThreadingProblem = new WithThreadingProblem();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                withThreadingProblem.takeNextId();
            }
        };

        for (int i = 0; i < 50000; i++) {
            int lastId = withThreadingProblem.nextId;
            int expectedresult = 2 + lastId;
            Thread thread1 = new Thread(runnable);
            Thread thread2 = new Thread(runnable);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            int endingId = withThreadingProblem.nextId;
            if (endingId != expectedresult)
                return;

        }


    }

    @Test
    public void threndingProblemWithExecutions() {
        final WithThreadingProblem withThreadingProblem = new WithThreadingProblem();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                withThreadingProblem.takeNextId();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(50000);
        int startId = withThreadingProblem.nextId;
        int expectativeId = 2 + startId;
        executorService.submit(runnable);
        int endId = withThreadingProblem.nextId;
        if (expectativeId != endId)
            return;

        fail("Error Theads executors!!");

    }

    @Test
    public void timeOutMethodTest() {
        ArrayList<String> strings = new ArrayList<>();
        Task task = new Task(strings, 2_000);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> submit = executor.submit(task);

        try {
            System.out.println("Started..");
            submit.get(6_000, TimeUnit.MILLISECONDS);


            ArrayList arrayList = task.getArrayList();
            assertEquals("Operação 2", arrayList.get(1));
            System.out.println("Finished!");
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            System.out.println("Terminou com Falhar");
            e.printStackTrace();
            fail("Execução excedeu o tempo limit!");
        } finally {
            executor.shutdownNow();
        }


    }

    @Test
    public void timeOutMultThreads() {
        ArrayList<String> strings = new ArrayList<>();
        Task task = new Task(strings, 2_000);
        Task task1 = new Task(strings, 3_000);
        Task task2 = new Task(strings, 1_000);

        List<Task> tasks = Arrays.asList(task, task1, task2);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (Task t : tasks) {
            Future<?> submit = executor.submit(t);

            try {
                System.out.println("Started..");
                submit.get(6_000, TimeUnit.MILLISECONDS);


                ArrayList arrayList = task.getArrayList();
                assertEquals("Operação 2", arrayList.get(1));
                System.out.println(arrayList.size());
                System.out.println("Finished!");
            } catch (ExecutionException | InterruptedException | TimeoutException e) {
                System.out.println("Terminou com Falhar");
                e.printStackTrace();
                fail("Execução excedeu o tempo limit!");
            }
        }


    }
}


class Task implements Runnable {

    private final ArrayList<String> arrayList;
    private long time;

    public Task(ArrayList<String> arrayList, long time) {

        this.arrayList = arrayList;
        this.time = time;
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    @Override
    public void run() {
        this.arrayList.add("Operação 1");

        try {
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.arrayList.add("Operação 2");


    }
}
