import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(rot13(input));
    }

    private static String rot13(String plaintext) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (c >= 'a' && c <= 'm' || c >= 'A' && c <= 'M') {
                c += 13;
            } else if (c >= 'n' && c <= 'z' || c >= 'N' && c <= 'Z') {
                c -= 13;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}