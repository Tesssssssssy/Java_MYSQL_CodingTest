import java.io.*;

public class Main {
    /**
     *  테스트 케이스 개수 입력
     *      - testCaseCnt 변수로 테스트 케이스 개수를 입력받음.
     *  각 테스트 케이스 처리
     *      - testCaseCnt 만큼 반복하면서 각 테스트 케이스에 대해 처리.
     *  이진수 변환과 1의 위치 확인
     *      - 입력받은 정수 n을 비트 연산을 통해
     *        오른쪽으로 이동시키며 (n >> 1), 각 비트가 1인지 확인 (n & 1).
     *  인덱스 출력
     *      - 1인 비트의 위치 (idx)를 출력.
     *      - idx는 매번 0에서 시작하여 n이 0이 될 때까지 증가.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 받기

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 각 테스트 케이스마다 정수 n 입력 받기
            int idx = 0; // 비트 위치를 추적할 인덱스 초기화

            // n을 이진수로 변환하면서 1의 위치 찾기
            while (n > 0) {
                if ((n & 1) == 1) { // 현재 비트가 1인지 검사
                    System.out.print(idx + " "); // 1이면 해당 인덱스 출력
                }
                n = n >> 1; // 다음 비트로 이동
                idx++; // 인덱스 증가
            }
            System.out.println(); // 각 테스트 케이스 후 줄바꿈
        }
    }
}