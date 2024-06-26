import java.util.*;

class Solution {
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;  // 가장 많이 선물을 받는 친구가 받을 선물의 수
        int friendsLength = friends.length;  // 친구들의 수
        HashMap<String, Integer> dic = new HashMap<>();  // 친구 이름과 인덱스를 매핑하는 사전
        int[] giftDegree = new int[friendsLength];  // 각 친구의 선물 지수를 저장하는 배열
        int[][] giftGraph = new int[friendsLength][friendsLength];  // 친구들 간의 선물 교환 횟수를 저장하는 2차원 배열

        // 친구 이름을 인덱스와 매핑
        for (int i = 0; i < friendsLength; i++) {
            dic.put(friends[i], i);
        }

        // 선물 기록 분석
        for (String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftDegree[dic.get(giftName[0])]++;  // 선물을 준 친구의 선물 지수 증가
            giftDegree[dic.get(giftName[1])]--;  // 선물을 받은 친구의 선물 지수 감소
            giftGraph[dic.get(giftName[0])][dic.get(giftName[1])]++;  // 선물을 준 친구와 받은 친구 간의 교환 횟수 증가
        }

        // 각 친구가 다음 달에 받을 선물 수 계산
        for (int i = 0; i < friendsLength; i++) {
            int num = 0;  // 친구 i가 받을 선물의 수
            for (int j = 0; j < friendsLength; j++) {
                if (i == j) {
                    continue;  // 자기 자신에게는 선물을 받지 않음
                }

                // 친구 i가 친구 j보다 선물을 많이 주었거나, 선물을 동일하게 주고받았지만 선물 지수가 높은 경우
                if (giftGraph[i][j] > giftGraph[j][i] ||
                        (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])) {
                    num++;  // 친구 i의 받을 선물 수 증가
                }
            }

            // 가장 많이 선물을 받을 예정인 친구의 선물 수 갱신
            if (answer < num) {
                answer = num;
            }
        }

        return answer;  // 다음 달에 가장 많이 선물을 받는 친구가 받을 선물의 수 반환
    }
}