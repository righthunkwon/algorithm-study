import java.util.*;
class Solution {
    static class Boom{
        int s, e;
        public Boom(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
    public int solution(int[][] targets) {
        //얼마전 cctv랑 비슷한 문제인가?
        //정렬해서 빼기
        List<Boom> list=new ArrayList();
        for(int i=0;i<targets.length;i++){
            list.add(new Boom(targets[i][0],targets[i][1]));
        }
        //끝 지점 빠른 순서로 정렬
        Collections.sort(list,(o1,o2)-> o1.e-o2.e);
        int answer = 1;
        int poss=list.get(0).e;
        for(int i=0;i<list.size();i++){
            Boom curr=list.get(i);
            //미사일 범위에서 벗어난다면
            //새로운 범위 갱신
            if(curr.s>=poss){
                answer++;
                poss=curr.e;
            }
        }
        return answer;
    }
}
