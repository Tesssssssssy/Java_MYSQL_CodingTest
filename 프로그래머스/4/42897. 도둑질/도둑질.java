class Solution {
    public static int solution(int[] money) {
        int n = money.length;
        if (n == 1) 
            return money[0];

        // 첫 집을 포함, 마지막 집을 제외
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }

        // 마지막 집을 포함, 첫 집을 제외
        int[] dp2 = new int[n];
        dp2[0] = 0;  // 첫 집을 털지 않기 때문에 0으로 시작
        dp2[1] = money[1];
        
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        // 두 경우 중 최대값을 반환
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}