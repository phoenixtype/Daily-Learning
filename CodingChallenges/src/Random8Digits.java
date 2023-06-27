import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Random8Digits {
    public static void main(String[] args) {
        System.out.println(generateRandomCode());
    }
    private static String generateRandomCode() {
        Random random = new Random();

        return IntStream.range(0, 8)
                .mapToObj(i -> {
                    if (i < 4) {
                        int letter = random.nextInt(26) + 'A'; // ASCII value of 'A' is 65
                        return String.valueOf((char) letter);
                    } else {
                        int digit = random.nextInt(10) + '0'; // ASCII value of '0' is 48
                        return String.valueOf((char) digit);
                    }
                })
                .collect(Collectors.joining());
    }
}
