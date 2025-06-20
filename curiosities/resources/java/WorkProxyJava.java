package ilearn.resources.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Objects;

public class WorkProxyJava {

    public static void main(String[] args) {

        SerivceTest serivceTest = new WritingOnService();

        System.out.println("No Proxy:");
        System.out.println(serivceTest.write("Testing Class Method..."));
        System.out.println("-------------------------");
        System.out.println("Proxy Working");
        SerivceTest proxy = ProxyFactory.createProxy(serivceTest, SerivceTest.class);
        System.out.println(proxy.write("Testing Class Method..."));

    }
}


interface SerivceTest {
    String write(String text);
}

class WritingOnService implements SerivceTest {

    @Override
    public String write(String text) {
        return "Dev Rafa writing: " + text;
    }
}

class LoggingInvocationProxy implements InvocationHandler {

    private final Object target;

    public LoggingInvocationProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Called Method: " + method.getName() + " args is: " +
                (Objects.nonNull(args) ? Arrays.toString(args) : "Empty"));

        Object invoke = method.invoke(target, args);
        System.out.println("result of Method: " + invoke);

        return invoke;
    }
}

class ProxyFactory {

    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new LoggingInvocationProxy(target));
    }
}