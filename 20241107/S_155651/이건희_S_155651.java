import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] book_time_int = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            int tmps = Integer.parseInt(book_time[i][0].substring(0,2))*60 
                        + Integer.parseInt(book_time[i][0].substring(3,5));
            int tmpe = Integer.parseInt(book_time[i][1].substring(0,2))*60 
                        + Integer.parseInt(book_time[i][1].substring(3,5));
            book_time_int[i][0] = tmps; book_time_int[i][1] = tmpe; 
        }
        Arrays.sort(book_time_int, (a,b) -> a[0]-b[0]);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < book_time_int.length; i++){
            // 리스트를 순회해서 입장 시간보다 일찍 청소되는 방이 있는지 찾기
            boolean toggle = true;
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) <= book_time_int[i][0]){
                    // 일찍 청소되는 방을 찾으면 해당 값 갱신
                    list.set(j, book_time_int[i][1] + 10);
                    toggle = false;
                    break;
                }
            }
            if(toggle){
                list.add(book_time_int[i][1]+10);
            }
        }
        return list.size();
    }
}