import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int scov : scoville) {
            minHeap.offer(scov);
        }
        // 입력받은 스코빌 정수 배열을 PriorityQueue에 저장

        while (minHeap.size() > 1 && minHeap.peek() < K) {
            int firstMin = minHeap.poll();
            int secondMin = minHeap.poll();

            int mixedScoville = firstMin + (secondMin * 2);
            minHeap.offer(mixedScoville);
            answer++;
        }

        /*
            이 떄, 만약 최소 값이 K보다 넘지 않으면
            모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우이므로 -1 반환
        */
        if (minHeap.peek() < K) {
            return -1;
        }

        return answer;
    }
}