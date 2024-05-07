import java.io.*;
import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
           String[] answer;
       
       
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int cnt : course) { //코스로 만들고 싶어하는 개수가 담긴 배열
            max= 0;
            map = new HashMap<>();//조합, 누적수
            for(String order : orders) {
        		char[] order_ch = order.toCharArray();
        		Arrays.sort(order_ch); 
        		selected = new boolean[order_ch.length]; 
        		select(order_ch,0,0,cnt); 
        	}
        	for(String str:map.keySet()){
                if(map.get(str)==max&&max>1) pq.add(str);
            }
        }
         answer = new String[pq.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = pq.poll();
        }
        return answer;
    }
	public static Map<String,Integer> map;
    public static boolean[] selected;
    static int max;
	public static void select(char[] arr, int start, int idx, int r){
		
        if(idx==r){
			String str = "";
			for(int i = 0; i < arr.length; i++){
				if(selected[i]) str += String.valueOf(arr[i]);
			}
            int cnt=map.getOrDefault(str,0)+1;
            map.put(str,cnt);
            max=Math.max(max,cnt);
			return;
		}
		
		for(int i = start; i < arr.length; i++){
			if(!selected[i]){
				selected[i] = true;
				select(arr,i+1,idx+1,r);
				selected[i] = false;
			}
		}
    }
}
