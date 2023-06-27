

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class PossibleEvaluationResult {

    /*
     * Complete the 'onesAndTwos' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */

    public static int onesAndTwos(int a, int b) {
        int MOD = 1000000007;

        int[][] dp = new int[a + 1][b + 1];

        if (a == 0 && b == 0) {
            dp[0][0] = 0;
        }

        if (a == 0 && b !=0) {
            dp[0][b] = b;
        }

        if (a != 0 && b ==0) {
            dp[a][0] = a;
        }

        dp[0][0] = 1;

        // Compute the dp array
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i > 0 && j > 0)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] + dp[i][j - 1]) % MOD;
                else if (i > 0)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                else if (j > 0)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }
        return dp[a][b];
    }
}

public class PossibleEvaluationSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = PossibleEvaluationResult.onesAndTwos(a, b);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
}
