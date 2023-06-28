import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BreakingRecordsResult {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        int minCount = 0;
        int maxCount = 0;

        int minValue = 0;
        int maxValue = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                minValue = scores.get(i);
                maxValue = scores.get(i);
            }

            if (scores.get(i) < minValue) {
                minValue = scores.get(i);
                minCount++;
            }

            if (scores.get(i) > maxValue) {
                maxValue = scores.get(i);
                maxCount++;
            }
        }
        result.add(maxCount);
        result.add(minCount);

        return result;
    }
}

public class BreakingRecordsSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = BreakingRecordsResult.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

