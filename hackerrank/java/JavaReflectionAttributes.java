package hackerrank.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class JavaReflectionAttributes {
    public static void main(String[] args) {

        Class student = StudentReflection.class;

        Method[] methods = student.getDeclaredMethods();
        ArrayList<String> methodsList = new ArrayList<>();
        for (Method m : methods) {
            methodsList.add(m.getName());

        }

        Collections.sort(methodsList);
        methodsList.forEach(System.out::println);

    }
}

class StudentReflection {
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
