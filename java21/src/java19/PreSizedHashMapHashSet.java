package java19;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Shows an example of initial capacity and subtle error in calculation of table length
 * Needs to be run with:
 * --add-opens=java.base/java.util=ALL-UNNAMED
 */
public class PreSizedHashMapHashSet {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        var testMap = new HashMap<Integer,Integer>(12);

        //Use on Java 19+
        //Map<Integer,Integer> testMap = HashMap.newHashMap(12);

        fillMap(testMap);

        System.out.println("With initial capacity:"  +getArrayLength(testMap));

        var copyConstructorMap = new HashMap<>(testMap);
        System.out.println("Copy Constructor: " + getArrayLength(copyConstructorMap));

        var putAllMap = new HashMap<Integer,Integer>();
        putAllMap.putAll(testMap);
        System.out.println("Put All : "+ getArrayLength(putAllMap));

        System.out.println("Old calculation :"+ (int)(((float)12 / 0.75f) + 1.0F));
        System.out.println("New calculation :" + (int) Math.ceil(12 / (double)0.75f));
    }

    private static void fillMap(Map<Integer, Integer> testMap) {
        for (int i = 0; i < 12; i++) {
            testMap.put(i, i);
        }
    }

    public static int getArrayLength(Map<Integer, Integer> map) throws NoSuchFieldException, IllegalAccessException {
        Field field = HashMap.class.getDeclaredField("table");
        field.setAccessible(true);
        Object table = field.get(map);
        return Array.getLength(table);
    }
}
