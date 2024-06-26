import java.util.Arrays;


class Solution {
    public static int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 진출 지점 기준 정렬
        
        int count = 0; // 카메라 개수
        int lastCamera = Integer.MIN_VALUE; // 마지막으로 설치한 카메라의 위치

        for (int[] route : routes) {
            // 현재 차량이 마지막으로 설치한 카메라에 포착되지 않으면 새로운 카메라 설치
            if (lastCamera < route[0]) {
                lastCamera = route[1]; // 현재 차량의 진출 지점에 카메라 설치
                count++; // 카메라 개수 증가
            }
        }

        return count;
    }
}