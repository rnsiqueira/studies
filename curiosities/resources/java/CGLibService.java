package ilearn.resources.java;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class CGLibService {

    public static void main(String[] args) {

        var execution = new ExecutionImpl();
        System.out.println("No proxy. " + execution.start("Testing..."));
        System.out.println("-------------");
        var proxy = ProxyWithCGLIB.createProxy(execution, ExecutionImpl.class);
        System.out.println(proxy.start("Testing..."));

    }
}

class ExecutionImpl {

    public <T extends String> String start(T text) {

        return "Writing: " + text;
    }
}

class LoggingMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Method: " + method.getName() + "is called args " + (Objects.nonNull(args) ? Arrays.asList(args) : "Empyt"));
        Object invoke = proxy.invoke(object, args);
        System.out.println("invoking Result: " + invoke);
        return invoke;
    }
}

class ProxyWithCGLIB {
    public static <T> T createProxy(T target, Class<T> superClassType) {
        var enhancer = new Enhancer();
        enhancer.setSuperclass(superClassType);
        enhancer.setCallback(new LoggingMethodInterceptor());
        return (T) enhancer.create();
    }
}
