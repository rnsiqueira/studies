package java21;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Set;

/**
 * Shows example of pattern matching using switch from JDK 15-21
 */

public class PatternMatchingSwitch {
    public static void main(String[] args) {

        Object object = someThirdPartyCode();

        String result ="";
        result = beforeJDK16(object); // Upto JDK 15
        result = usingJDK17IfElse(object); // JDK 16+
        //result = usingSwitchPattern(object); //JDK 21
        //result = usingSwitchPatternWithOutGuard (object); //JDK 21
        result = usingSwitchPatternWithGuard(object); //JDK 21
        result = usingSwitchPatternDominance(object);
        System.out.println("Result is: "+result);

    }

    public static String beforeJDK16(Object datum) {

        String text = "Unknown schema";

        if (datum instanceof String) {
            String result  = (String) datum;
            text = "Creating String schema for: " +result.toUpperCase();
        } else if (datum instanceof LocalDate ) {
            LocalDate result = (LocalDate) datum;
            text = "Creating Date schema for: " +result.format(DateTimeFormatter.ISO_DATE);
        } else if (datum instanceof Enum) {
            Enum result = (Enum)datum;
            text = "Creating Enum schema for: " + result.name();
        } else if (datum instanceof Collection) {
            Collection result = (Collection) datum;
            text = "Creating Array like schema: " + result;
        }
        return text;
    }

    public static String usingJDK17IfElse(Object datum) {

        String text = "Unknown schema";
        if (datum instanceof String result) {
            text = "Creating String schema for: " +result.toUpperCase();
        } else if (datum instanceof LocalDate result) {
            text = "Creating Date schema for: " +result.format(DateTimeFormatter.ISO_DATE);
        } else if (datum instanceof Enum result) {
            text = "Creating Enum schema for: " + result.name();
        } else if (datum instanceof Collection result) {
            text = "Creating Array like schema for: " + result;
        }
        return text;
    }

    public static String usingSwitchPattern(Object datum) {
        if(null == datum){
            return "Creating null schema";
        }
        return switch (datum){
            case String result -> "Creating String schema for: "+result.toUpperCase();
            case LocalDate result -> "Creating Date schema for Date: " +
                    result.format(DateTimeFormatter.ISO_DATE);
            case Enum result ->  "Creating Enum schema for: " + result.name();
            case Collection result ->"Creating Array like schema: " + result;
            case null,default -> throw new IllegalArgumentException("Can't create schema for: "
                    + datum);
        };
    }

    public static String usingSwitchPatternWithOutGuard(Object datum) {
        return switch (datum){
            case null -> "Creating null schema";
            case String result -> {
                if(result.isBlank()){
                    yield "Creating String schema for an empty string";
                } else {
                    yield "Creating String schema for: " + result.toUpperCase();
                }
            }
            case LocalDate result -> "Creating Date schema for Date: " +
                    result.format(DateTimeFormatter.ISO_DATE);
            case Enum result ->  "Creating Enum schema for: " + result.name();
            case Collection result ->"Creating Array like schema: " + result;
            default -> throw new IllegalArgumentException("Can't create schema for: " + datum);
        };
    }

    public static String usingSwitchPatternWithGuard(Object datum) {
        return switch (datum){
            case null -> "Creating null schema";
            case String result when result.isBlank() -> "Creating String schema for an empty string";
            case String result -> "Creating String schema for: "+result.toUpperCase();
            case LocalDate result -> "Creating Date schema for Date: " +
                    result.format(DateTimeFormatter.ISO_DATE);
            case Enum result ->  "Creating Enum schema for: " + result.name();
            case Collection result ->"Creating Array like schema: " + result;
            default -> throw new IllegalArgumentException("Can't create schema for: " + datum);
        };
    }

    public static String usingSwitchPatternDominance(Object datum) {
        return switch (datum){
            case null -> "Creating null schema";
            case String result -> "Creating String schema for: "+result.toUpperCase();
            case LocalDate result -> "Creating Date schema for Date: " +
                    result.format(DateTimeFormatter.ISO_DATE);
            case Enum result ->  "Creating Enum schema for: " + result.name();
            case Set result ->  "Creating special schema for Set of size: "+ result.size();
            case Collection result ->"Creating Array like schema: " + result;
            default -> throw new IllegalArgumentException("Can't create schema for: " + datum);
        };
    }

    public static Object someThirdPartyCode(){
        return Set.of(1,2,3,4);
    }
}