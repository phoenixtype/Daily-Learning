import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <br>Let's break down the code `hour = (hour % 12) + (period.equalsIgnoreCase("PM") ? 12 : 0);` and explain its purpose:
 *<br>
 * <br>1. `(hour % 12)`: This expression calculates the remainder when `hour` is divided by 12. It effectively converts the hour value to a 12-hour format by mapping any value greater than or equal to 12 to the corresponding value in the range 0-11.
 *<br>
 * <br>2. `period.equalsIgnoreCase("PM")`: This condition checks if the `period` string is equal to "PM" (ignoring case sensitivity). The `equalsIgnoreCase` method is used to perform a case-insensitive comparison.
 *<br>
 * <br>3. `? 12 : 0`: This is the ternary operator (`? :`), which is a shorthand for an if-else statement. It evaluates the condition (`period.equalsIgnoreCase("PM")`) and returns the value `12` if the condition is true (i.e., the period is "PM"). Otherwise, it returns the value `0`.
 *<br>
 * <br>4. `(hour % 12) + (period.equalsIgnoreCase("PM") ? 12 : 0)`: This expression adds the result of step 1, which is the hour value in the 12-hour format, to the result of step 3, which is either `12` (if the period is "PM") or `0` (if the period is "AM"). The overall effect is to convert the hour value to the military (24-hour) format.
 *<br>
 * <br>By performing the calculation `(hour % 12) + (period.equalsIgnoreCase("PM") ? 12 : 0)`, the code effectively converts the given time from a 12-hour AM/PM format to a 24-hour military format.
 */


class TimeConversionResult {


    public static String timeConversion(String s) {
        String[] splitTime = s.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);
        int second = Integer.parseInt(splitTime[2].substring(0, 2));
        String period = splitTime[2].substring(2, 4);

        hour = (hour % 12) + (period.equalsIgnoreCase("PM") ? 12 : 0);
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}


public class TimeConversionSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = TimeConversionResult.timeConversion(s);
        System.out.println(result);
        bufferedReader.close();
    }
}