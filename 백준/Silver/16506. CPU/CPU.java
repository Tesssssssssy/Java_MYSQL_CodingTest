import java.io.*;
import java.util.*;

public class Main {
    /**
     *  - ex.)
     *    두 수의 합을 구하는 연산의 어셈블리어 코드가 ADD,
     *    기계어 코드가 00000이면 어셈블러는 ADD 를 읽어서 그대로 00000로 바꾸어주는 것
     *  - 어셈블리어 코드는 "opcode rD rA rB" 또는 "opcode rD rA #C"의 형태
     *  - 레지스터 rA와 rB에 있는 두 수 또는 레지스터 rA에 있는 수와 상수 #C를 opcode 에 해당하는 연산을 수행하고,
     *    그 결괏값을 레지스터 rD에 저장하는 명령어
     *  - rA는 opcode 에 따라 사용하지 않을 수도 있다.
     *    어셈블러는 opcode, rD, rA, rB, #C를
     *    각 bit 의 자리에 맞게 2진수 0과 1로 이루어진 16-bit 기계어 코드로 변역
     *
     *  - 0~4 : CPU 가 수행해야 할 연산을 나타내는 opcode.
     *          만약 4번 bit 가 0일 경우 레지스터 rB를, 1일 경우 상수 #C를 사용.
     *    5 : 사용하지 않는 bit 이며, 항상 0.
     *    6~8 : 결괏값을 저장하는 레지스터 rD의 번호.
     *    9~11 : 연산에 사용되는 레지스터 rA의 번호.
     *           사용하지 않을 경우에는 000.
     *    12~15 : 만약 4번 bit 가 0일 경우 12~14번 bit 는 연산에 사용되는 레지스터 rB의 번호,
     *            15번 bit 는 항상 0.
     *            만약 4번 bit 가 1일 경우 12~15번 bit 는 상수 #C.
     *
     *  [입력]
     *  명령어의 개수 N
     *  opcode rD rA rB" 또는 "opcode rD rA #C"의 형태로 주어짐.
     *  (문자열 opcode는 항상 대문자)
     *  (정수 rD, rA, rB (0 ≤ rD, rA, rB ≤ 7)는 레지스터 번호를 의미)
     *  (사용하는 레지스터 번호는 1부터 7까지이며, 사용하지 않을 경우에만 0이 주어짐)
     *
     *  [출력]
     *  N개의 각 줄에 어셈블리어 코드를 기계어 코드로 번역하여 출력
     */
    static HashMap<String, String> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        hm.put("ADD", "0000");
        hm.put("SUB", "0001");
        hm.put("MOV", "0010");
        hm.put("AND", "0011");
        hm.put("OR", "0100");
        hm.put("NOT", "0101");
        hm.put("MULT", "0110");
        hm.put("LSFTL", "0111");
        hm.put("LSFTR", "1000");
        hm.put("ASFTR", "1001");
        hm.put("RL", "1010");
        hm.put("RR", "1011");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            int rD = Integer.parseInt(st.nextToken());
            int rA = Integer.parseInt(st.nextToken());
            int rB = Integer.parseInt(st.nextToken());
            if (opcode.charAt(opcode.length() - 1) == 'C') {
                sb.append(hm.get(opcode.substring(0, opcode.length() - 1))).append("1");
            } else {
                sb.append(hm.get(opcode)).append("0");
            }
            sb.append("0");

            String binary = Integer.toBinaryString(rD);
            String s = append(0, binary, 2);
            sb.append(append(0, binary, 2));
            if (opcode == "NOT" || opcode == "MOV" || opcode == "MOVC") {
                sb.append("000");
            } else {
                String binary1 = Integer.toBinaryString(rA);
                sb.append(append(0, binary1, 2));
            }
            String binary2 = Integer.toBinaryString(rB);
            if (opcode.charAt(opcode.length() - 1) == 'C') {
                sb.append(append(0, binary2, 3));
            } else {
                sb.append(append(0, binary2, 2)).append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static String append(int depth, String str, int limit) {
        if (depth >= limit || limit < str.length()) {
            return str;
        }
        return append(depth + 1, "0" + str, limit);
    }
}