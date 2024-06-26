import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        /*
            citations 배열 오름차순 정렬.
            -> 우선 Arrays.sort 함수를 이용해 citations 배열을 정렬하게 되면 
               특정 인덱스 i부터 citations배열의 길이까지 만큼의 논문이 citations[i]번 만큼 인용되었다고 할 수 있음.
         */
        
        Arrays.sort(citations);

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // h 결정. h-index는 배열의 길이에서 현재 인덱스를 뺀 값이 됨.
            // 인용된 논문의 수
            int h = n - i;

            // 현재 인덱스의 인용 횟수가 h 이상이면, h 반환.
            // 여기서 h는 인용 횟수가 h 이상인 논문이 h 편 이상 보장.
            if (citations[i] >= h) {
                return h;
            }
        }

        // 만약 모든 논문의 인용 횟수가 논문 수보다 작다면 H-Index는 0.
        return 0;
    }
}