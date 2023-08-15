import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_12788 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        int total = M * K;// 100개 필요
        int i = list.size();
        boolean isdone=true;
        while(isdone&&i>0) {
            i--;
            total-=list.get(i);
            if(total<=0) isdone=false;
        }
        if(total>0)System.out.println("STRESS");
        else {
            System.out.println(list.size()-i);
        }

    }
}
