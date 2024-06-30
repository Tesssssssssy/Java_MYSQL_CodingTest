import java.io.*;
import java.util.*;

public class Main {
    /**
     *  슬라이딩 윈도우 기법 사용한 풀이
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitors = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우
        int currentWindowSum = 0;
        for (int i = 0; i < X; i++) {
            currentWindowSum += visitors[i];
        }

        int maxVisitors = currentWindowSum;
        int maxCount = 1;  // 최대 방문자 수를 가진 기간이 몇 개인지 세는 변수

        // 슬라이딩 윈도우를 이동하며 최대 방문자 수 탐색
        for (int i = X; i < N; i++) {
            currentWindowSum += visitors[i] - visitors[i - X];
            if (currentWindowSum > maxVisitors) {
                maxVisitors = currentWindowSum;
                maxCount = 1;  // 새로운 최대값이므로 카운트를 1로 초기화
            } else if (currentWindowSum == maxVisitors) {
                maxCount++;  // 기존 최대값과 동일한 경우 카운트 증가
            }
        }

        // 결과 출력
        if (maxVisitors == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitors);
            System.out.println(maxCount);
        }
    }
}