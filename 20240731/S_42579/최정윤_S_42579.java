import java.io.*;
import java.util.*;

class Solution {
    public static class Genre{
        int sum;
        PriorityQueue<int[]> pq;
        public Genre(int sum,PriorityQueue<int[]> pq){
            this.sum=sum;
            this.pq=pq;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Genre> map=new HashMap();
        for(int i=0;i<genres.length;i++){
            Genre g=map.getOrDefault(genres[i],new Genre(0,new PriorityQueue<>((o1,o2)->o2[1]-o1[1])));
            g.sum+=plays[i];
            g.pq.add(new int[]{i,plays[i]});
            map.put(genres[i],g);
        }
        PriorityQueue<Genre> pq=new PriorityQueue<>((o1,o2)->o2.sum-o1.sum);
        for(Genre g:map.values()){
            pq.add(g);
        }
        List<Integer> ans=new ArrayList();
        //장르의 합이 높은 것부터 꺼내진다.
        //거기서 2개가 있다면 높은거 2개 꺼내기
        while(!pq.isEmpty()){
            Genre g=pq.poll();
            for(int j=0;j<2;j++){
                if(!g.pq.isEmpty()) ans.add(g.pq.poll()[0]);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
}
