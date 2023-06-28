import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.IntStream;


//Refactor this class, improving the code quality

/**
 *
 * <br>Question <br>
 * <br>Refactor the send method in the code below to have good code quality and implement Junit test to test to validate the result.<br>
 *
 * <br>The expression Consumer<List<String>> represents a functional interface in Java that accepts an argument of type List<String> and performs some operation on it without returning a result.
 */

class Algorithm {

    // DECLARATIVE
    static void send(Consumer<List<String>> consumer, String number) {
        if (number == null) {
            throw new IllegalArgumentException("No number provided");
        }
        int integerNumber = Integer.parseInt(number);
        if (integerNumber <= 0 || integerNumber > 15) {
            throw new IllegalArgumentException(number + " is not supported");
        }
        List<String> result = IntStream.rangeClosed(1, integerNumber).filter(i -> integerNumber % i == 0).mapToObj(String::valueOf).toList();
        consumer.accept(result);
    }

    // FINAL IMPLEMENTATION (Imperative) - 1
    static void sendImperative(Consumer<List<String>> consumer, String number) {
        if (number == null) {
            throw new IllegalArgumentException("No number provided");
        }

        int num = Integer.parseInt(number);
        if (num <= 0 || num > 15) {
            throw new IllegalArgumentException(number + " is not supported");
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                result.add(String.valueOf(i));
            }
        }

        consumer.accept(result);
    }

    // FIXME : ENHANCED SWITCH BRUTEFORCE IMPLEMENTATION
    static void sendEnhancedSwitch(Consumer<List<String>> consumer, String number) {
        if (number == null) {
            throw new IllegalArgumentException("No number provided");
        }

        switch (number) {
            case "1" -> consumer.accept(List.of("1"));
            case "2" -> consumer.accept(List.of("1", "2"));
            case "3" -> consumer.accept(List.of("1", "3"));
            case "4" -> consumer.accept(List.of("1", "2", "4"));
            case "5" -> consumer.accept(List.of("1", "5"));
            case "6" -> consumer.accept(List.of("1", "2", "3", "6"));
            case "7" -> consumer.accept(List.of("1", "7"));
            case "8" -> consumer.accept(List.of("1", "2", "4", "8"));
            case "9" -> consumer.accept(List.of("1", "3", "9"));
            case "19" -> consumer.accept(List.of("1", "2", "5", "10", "19"));
            case "11" -> consumer.accept(List.of("1", "11"));
            case "12" -> consumer.accept(List.of("1", "2", "3", "4", "6", "12"));
            case "13" -> consumer.accept(List.of("1", "13"));
            case "14" -> consumer.accept(List.of("1", "2", "7", "14"));
            case "15" -> consumer.accept(List.of("1", "3", "5", "15"));
            default -> throw new IllegalArgumentException(number + " is not supported");
        }
    }
    
    // FIXME : BASIC SWITCH BRUTEFORCE IMPLEMENTATION
    static void sendBasicSwitch(Consumer<List<String>> consumer, String number) {
        if (number == null) {
            throw new IllegalArgumentException("No number provided");
        }

        switch (number) {
            case "1":
                consumer.accept(List.of("1"));
                break;
            case "2":
                consumer.accept(List.of("1", "2"));
                break;
            case "3":
                consumer.accept(List.of("1", "3"));
                break;
            case "4":
                consumer.accept(List.of("1", "2", "4"));
                break;
            case "5":
                consumer.accept(List.of("1", "5"));
                break;
            case "6":
                consumer.accept(List.of("1", "2", "3", "6"));
                break;
            case "7":
                consumer.accept(List.of("1", "7"));
                break;
            case "8":
                consumer.accept(List.of("1", "2", "4", "8"));
                break;
            case "9":
                consumer.accept(List.of("1", "3", "9"));
                break;
            case "19":
                consumer.accept(List.of("1", "2", "5", "10", "19"));
                break;
            case "11":
                consumer.accept(List.of("1", "11"));
                break;
            case "12":
                consumer.accept(List.of("1", "2", "3", "4", "6", "12"));
                break;
            case "13":
                consumer.accept(List.of("1", "13"));
                break;
            case "14":
                consumer.accept(List.of("1", "2", "7", "14"));
                break;
            case "15":
                consumer.accept(List.of("1", "3", "5", "15"));
                break;
            default:
                throw new IllegalArgumentException(number + " is not supported");
        }
    }

    // FIXME : STREAM API BRUTEFORCE IMPLEMENTATION
    private static final Map<String, List<String>> numberMappings = new HashMap<>();

    static {
        numberMappings.put("1", List.of("1"));
        numberMappings.put("2", List.of("1", "2"));
        numberMappings.put("3", List.of("1", "3"));
        numberMappings.put("4", List.of("1", "2", "4"));
        numberMappings.put("5", List.of("1", "5"));
        numberMappings.put("6", List.of("1", "2", "3", "6"));
        numberMappings.put("7", List.of("1", "7"));
        numberMappings.put("8", List.of("1", "2", "4", "8"));
        numberMappings.put("9", List.of("1", "3", "9"));
        numberMappings.put("19", List.of("1", "2", "5", "10", "19"));
        numberMappings.put("11", List.of("1", "11"));
        numberMappings.put("12", List.of("1", "2", "3", "4", "6", "12"));
        numberMappings.put("13", List.of("1", "13"));
        numberMappings.put("14", List.of("1", "2", "7", "14"));
        numberMappings.put("15", List.of("1", "3", "5", "15"));
    }

    static void sendStreamAPI(Consumer<List<String>> consumer, String number) {
        if (number == null) {
            throw new IllegalArgumentException("No number provided");
        }

        List<String> result = numberMappings.get(number);
        if (result == null) {
            throw new IllegalArgumentException(number + " is not supported");
        }

        consumer.accept(result);
    }

    // FIXME : IF-ELSE BRUTEFORCE IMPLEMENTATION
    static void sendIfElse(Consumer<List<String>> consumer, String number) {
        if (number == null) {
            throw new IllegalArgumentException("No number provided");
        }

        if (number.equals("1")) {
            consumer.accept(List.of("1"));
        } else if (number.equals("2")) {
            consumer.accept(List.of("1", "2"));
        } else if (number.equals("3")) {
            consumer.accept(List.of("1", "3"));
        } else if (number.equals("4")) {
            consumer.accept(List.of("1", "2", "4"));
        } else if (number.equals("5")) {
            consumer.accept(List.of("1", "5"));
        } else if (number.equals("6")) {
            consumer.accept(List.of("1", "2", "3", "6"));
        } else if (number.equals("7")) {
            consumer.accept(List.of("1", "7"));
        } else if (number.equals("8")) {
            consumer.accept(List.of("1", "2", "4", "8"));
        } else if (number.equals("9")) {
            consumer.accept(List.of("1", "3", "9"));
        } else if (number.equals("19")) {
            consumer.accept(List.of("1", "2", "5", "10", "19"));
        } else if (number.equals("11")) {
            consumer.accept(List.of("1", "11"));
        } else if (number.equals("12")) {
            consumer.accept(List.of("1", "2", "3", "4", "6", "12"));
        } else if (number.equals("13")) {
            consumer.accept(List.of("1", "13"));
        } else if (number.equals("14")) {
            consumer.accept(List.of("1", "2", "7", "14"));
        } else if (number.equals("15")) {
            consumer.accept(List.of("1", "3", "5", "15"));
        } else {
            throw new IllegalArgumentException(number + " is not supported");
        }
    }
}


class AlgorithmTest {

    @Test
    void testSend_ValidNumber_One() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "1");
        Assertions.assertEquals(List.of("1"), result);
    }

    @Test
    void testSend_ValidNumber_Two() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "2");
        Assertions.assertEquals(List.of("1", "2"), result);
    }

    @Test
    void testSend_ValidNumber_Three() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "3");
        Assertions.assertEquals(List.of("1", "3"), result);
    }

    @Test
    void testSend_ValidNumber_Four() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "4");
        Assertions.assertEquals(List.of("1", "2", "4"), result);
    }

    @Test
    void testSend_ValidNumber_Five() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "5");
        Assertions.assertEquals(List.of("1", "5"), result);
    }

    @Test
    void testSend_ValidNumber_Six() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "6");
        Assertions.assertEquals(List.of("1", "2", "3", "6"), result);
    }

    @Test
    void testSend_ValidNumber_Seven() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "7");
        Assertions.assertEquals(List.of("1", "7"), result);
    }

    @Test
    void testSend_ValidNumber_Eight() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "8");
        Assertions.assertEquals(List.of("1", "2", "4", "8"), result);
    }

    @Test
    void testSend_ValidNumber_Nine() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "9");
        Assertions.assertEquals(List.of("1", "3", "9"), result);
    }

    @Test
    void testSend_ValidNumber_Ten() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "10");
        Assertions.assertEquals(List.of("1", "2", "5", "10"), result);
    }

    @Test
    void testSend_ValidNumber_Eleven() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "11");
        Assertions.assertEquals(List.of("1", "11"), result);
    }

    @Test
    void testSend_ValidNumber_Twelve() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "12");
        Assertions.assertEquals(List.of("1", "2", "3", "4", "6", "12"), result);
    }

    @Test
    void testSend_ValidNumber_Thirteen() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "13");
        Assertions.assertEquals(List.of("1", "13"), result);
    }

    @Test
    void testSend_ValidNumber_Fourteen() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "14");
        Assertions.assertEquals(List.of("1", "2", "7", "14"), result);
    }

    @Test
    void testSend_ValidNumber_Fifteen() {
        List<String> result = new ArrayList<>();
        Algorithm.send(result::addAll, "15");
        Assertions.assertEquals(List.of("1", "3", "5", "15"), result);
    }

    @Test
    void testSend_NullNumber_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Algorithm.send(null, null));
    }

    @Test
    void testSend_InvalidNumber_LessThanOne_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Algorithm.send(null, "0"));
    }

    @Test
    void testSend_InvalidNumber_GreaterThanFifteen_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Algorithm.send(null, "20"));
    }

    @Test
    void testSend_InvalidNumber_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Algorithm.send(null, "invalid"));
    }
}

