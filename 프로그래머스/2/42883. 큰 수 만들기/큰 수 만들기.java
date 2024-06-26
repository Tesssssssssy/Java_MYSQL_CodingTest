class Solution {
    public static String solution(String number, int k) {
        // 결과를 저장할 스택
        char[] stack = new char[number.length() - k];
        int top = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 스택의 최상위 값보다 현재 값이 크면 최상위 값을 제거 (k>0이면서 스택이 비어있지 않고, 스택의 최상단 값이 현재 값보다 작을 때)
            while (top > 0 && stack[top - 1] < c && k > 0) {
                top--;
                k--;
            }
            // 스택이 가득 차지 않았다면 현재 값을 스택에 추가
            if (top < stack.length) {
                stack[top++] = c;
            }
        }

        // 스택의 내용을 결과 문자열로 변환
        return new String(stack);
    }
}