import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while(true) {
            String st = br.readLine();
            Stack<Character> stack = new Stack<>();
            if(st.contains("-")) break;
            int n = st.length(), t = 0;
            for(int i = 0; i < n; i++) {
                char c = st.charAt(i);
                if(c == '{') stack.push(c);
                else {
                    if(stack.isEmpty()) {
                        stack.push('{');
                        t++;
                    }
                    else stack.pop();
                }
            }
            t += stack.size() / 2;
            System.out.println((++cnt)+". "+t);
        }
    }
}
