package ilearn.resources.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotation {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        InjectAnnotation injectAnnotation = new InjectAnnotation();

        new ProcessAnnotation().takeMethodAnnotation(injectAnnotation);


    }
}


class ProcessAnnotation {

    public void takeMethodAnnotation(Object obj) throws InvocationTargetException, IllegalAccessException {

        Method[] declaredMethods = obj.getClass().getDeclaredMethods();

        for (Method m : declaredMethods) {
            if(m.isAnnotationPresent(UseTestAnnotatio.class)) {
                System.out.println("annotaion found!");
                m.invoke(obj);
            }
        }


    }
}

class InjectAnnotation {

    @UseTestAnnotatio
    public void startMethod() {
        System.out.println("Invoking method with annotation!!!");
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface UseTestAnnotatio {

}
