import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] finalArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            finalArr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int k1 = 1; k1 < N; k1++){
            for (int k2 = 1; k2 < N; k2++){
                int p = -1, q = -1;

                for (int i = 0; i < N; i++){
                    int idx1 = i + k1;
                    if (idx1 >= N) idx1 -= N;
                    int s1 = idx1 + 1; 
                        
                    int idx2 = i - k2;
                    if (idx2 < 0) idx2 += N;
                    int s2 = finalArr[idx2];
                    
                    if (s1 != s2) {
                        p = i;
                        break;
                    }
                }
                if (p == -1) continue;
                
                for (int i = N - 1; i >= 0; i--){
                    int idx1 = i + k1;
                    if (idx1 >= N) idx1 -= N;
                    int s1 = idx1 + 1;
                    
                    int idx2 = i - k2;
                    if (idx2 < 0) idx2 += N;
                    int s2 = finalArr[idx2];
                    
                    if (s1 != s2) {
                        q = i;
                        break;
                    }
                }
                if (p >= q) continue;
                
                boolean valid = true;
                for (int i = p; i <= q; i++){
                    int idx2 = i - k2;
                    if (idx2 < 0) idx2 += N;
                    int s2 = finalArr[idx2];
                    
                    int mirrorIndex = (p + q - i + k1) % N;
                    int s1Mirror = mirrorIndex + 1;
                    if (s2 != s1Mirror) {
                        valid = false;
                        break;
                    }
                }
                if (valid){
                    System.out.println(k1);
                    System.out.println((p+1) + " " + (q+1));
                    System.out.println(k2);
                    return;
                }
            }
        }
    }
}
