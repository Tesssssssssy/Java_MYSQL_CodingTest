
import java.io.*;

public class Main {
    /**
     *  1. 오르막 수는 수의 자리가 오름차순을 이루는 수를 의미
     *  2. 인접한 수가 같아도 오름차순으로 친다.
     *  3. ex.)
     *     2234, 3678, 11119 -> 오르막 수 0.
     *     2232, 3676, 91111 -> 오르막 수 x.
     *  4. 오르막 수의 개수를 10,007로 나눈 나머지 출력
     *     (수는 0으로 시작 가능)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 10007;

        int[][] dp = new int[N + 1][10];
        //  i 자릿수의 수 중에서 마지막 숫자가 j로 끝나는 오르막 수의 개수 의미

        /*
            초기화
                한 자릿수 숫자의 경우, 각 숫자(0~9)는 자기 자신으로 끝나는 하나의 오르막 수가 될 수 있으므로
                dp[1][j] = 1 (j는 0부터 9까지).
        */
        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        /*
            동적 계획법 점화식 적용
                길이가 i이고 마지막 숫자가 j인 수의 개수는,
                길이가 i-1이고 마지막 숫자가 0부터 j 까지인 수들의 합.
                즉, dp[i][j] = dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j].

                이 점화식은 길이가 i-1인 오르막 수에서 숫자 j 또는 그 이하의 숫자로 끝나는 경우의 수를 모두 더하여
                길이가 i이고 j로 끝나는 수를 형성하는 방법의 수를 계산.

                이는 오르막 수의 정의에 따라, 숫자 j는 자신보다 작거나 같은 숫자 뒤에 올 수 있기 때문.
                따라서, i-1 길이의 모든 오르막 수 중에서
                      마지막 숫자가 j 이하인 경우에 j를 추가하여 새로운 오르막 수를 형성할 수 있다.

                즉, i-1 길이의 수 중에서 마지막 숫자가 0에서 j까지인 모든 수에 대해,
                각각 j를 추가하여 새로운 오르막 수를 형성할 수 있는 경우의 수를 계산한다는 의미.
        */
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;
                }
            }
        }

        /*
            길이가 N인 오르막 수의 총 개수 계산
                길이 N인 오르막 수의 총 개수는 모든 dp[N][0]부터 dp[N][9]까지의 합
        */
        int sum = 0;
        for (int j = 0; j < 10; j++) {
            sum = (sum + dp[N][j]) % MOD;
        }

        System.out.println(sum);
    }
}