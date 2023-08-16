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
        int total = M * K;// total개 필요
        int i = list.size();
        boolean isdone=true;
        while(isdone&&i>0) {//index가 1까지여야 i--
            i--;
            total-=list.get(i);
            if(total<=0) isdone=false;//음수이거나 0이면 종료후 원래 사이즈에서 현재 i만큼 빼면 빌린 수 
        }
        if(total>0)System.out.println("STRESS");//list.size가 0인데도 구해야하는 펜의 수가 양수=> 부족함
        else {
            System.out.println(list.size()-i);
        }

    }
}
