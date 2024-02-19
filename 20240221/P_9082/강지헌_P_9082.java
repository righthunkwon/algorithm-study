import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int te=0;te<T;te++) {
            int ans=0;
            int N = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray(), brr = br.readLine().toCharArray();
            if(arr[0]!='0' && arr[1]!='0') { arr[0]--; arr[1]--; ans++;}
            for(int i=1;i<N-1;i++) {
                if(arr[i-1]!='0' && arr[i]!='0' && arr[i+1]!='0') { arr[i-1]--; arr[i]--; arr[i+1]--; ans++; }
            }
            if(arr[N-2]!='0' && arr[N-1]!='0') { arr[N-1]--; arr[N-2]--; ans++; }
            System.out.println(ans);
        }
    }
}
