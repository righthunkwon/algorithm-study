import java.util.*;
class Solution {
    public static int solution(int[] picks, String[] minerals) {
        int[][] chk = {{1,1,1},{5,1,1},{25,5,1}};
        List<L> list = new ArrayList<>();
        int N=minerals.length, M=picks[0]+picks[1]+picks[2];
        for(int i=0;i<N && list.size()<M;i+=5) {
            int a=0,b=0,c=0;
            for(int j=i;j<Math.min(i+5,N);j++) {
                if(minerals[j].charAt(0)=='d') a++;
                else if(minerals[j].charAt(0)=='i') b++;
                else c++;
            }
            list.add(new L(a,b,c));
        }
        Collections.sort(list,(o1,o2) -> {
            if(o1.d==o2.d) {
                if(o1.r==o2.r) return o2.s-o1.s;
                return o2.r-o1.r;
            }
            return o2.d-o1.d;
        });
        int answer=0,l=0;
        for (L m : list) {
            while (l<3 && picks[l]==0) l++;
            if (l==3) break;
            answer+=m.d*chk[l][0]+m.r*chk[l][1]+m.s*chk[l][2];
            picks[l]--;
        }
        return answer;
    }
}
class L {
    int d, r, s;
    public L(int d, int r, int s) {
        this.d = d;
        this.r = r;
        this.s = s;
    }
}
