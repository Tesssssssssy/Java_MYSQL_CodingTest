class Solution {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        // 정확한 순위를 매길 수 있는 선수의 수

        boolean[][] graph = new boolean[n + 1][n + 1];
        // 선수들간의 승패를 저장할 그래프

        // 결과 입력받기, A가 B를 이긴다면 graph[A][B] = true
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = true;
        }

        // 플로이드-워셜 알고리즘으로 각 선수간 도달 가능성 계산
        // k: 중간 지점, i: 출발 지점, j: 도착 지점
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        // i가 k를 이기고 k가 j를 이긴다면 i는 j를 이길 수 있음

                        graph[i][j] = true;
                    }
                }
            }
        }

        /*
            각 선수에 대해,
            자신이 이긴 선수와 자신에게 진 선수의 총 수가 n-1이면 순위를 확정할 수 있다.
            (5명 중 4위에게 지면 나는 자동으로 5위가 되니까)
         */
        for (int i = 1; i <= n; i++) {
            int known = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] || graph[j][i]) {
                    // i가 j를 이기거나 j가 i를 이기는 관계가 확인된 경우

                    known++;
                }
            }
            if (known == n - 1) {
                // 모든 선수와의 관계가 명확하면

                answer++;  // 순위 확정 가능한 선수 수 증가
            }
        }

        return answer;  // 결과 반환
    }
}