import java.util.HashMap;

class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1; // 경우의 수 곱해야 하므로 1로 설정

        HashMap<String, Integer> hashMap = new HashMap<>();

        // 각 의상의 종류별로 의상 수 세고
        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        // 각 의상의 종류별로 의상을 선택할 수 있는 경우의 수를 계산
        for (String key : hashMap.keySet()) {
            // 각 의상 종류는 선택하지 않는 경우도 포함해서 +1
            answer *= (hashMap.get(key) + 1);
        }

        // 최소 한 개의 의상은 입어야 하므로 모든 의상을 선택하지 않는 경우를 빼준다
        return answer - 1;
    }
}