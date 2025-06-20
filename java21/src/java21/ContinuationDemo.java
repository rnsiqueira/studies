package java21;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

/**
 * Class shows simple example of Continuation.
 * Continuation is internal to the JDK, use the following:
 * --add-exports=java.base/jdk.internal.vm=ALL-UNNAMED
 */
public class ContinuationDemo {

    public static void main(String[] args) {

        ContinuationScope continuationScope = new ContinuationScope("demo");
        Continuation continuation = new Continuation(continuationScope,
                ()->{
                    System.out.println("Starting : " + Thread.currentThread());
                    Continuation.yield(continuationScope);
                    System.out.println("Finishing :" + Thread.currentThread());
                });
        System.out.println("Continuation Demo");
        continuation.run();
        System.out.println("Continuation done ? "+continuation.isDone());
        continuation.run();
        System.out.println("Continuation done ? "+continuation.isDone());
    }
}
