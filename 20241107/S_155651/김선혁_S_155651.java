class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 끝나는 시간을 기준으로 
        // 시작시간과 비교해 안에 포함되면 +1 , 끝나게 되면 -1
        
        // 전부 분으로 치환하면서
        // 하나씩 꺼내서 시작부분과 끝부분에 +1과 -1을 기록해서
        // 전체 for문을 통해 해당 시간에 몇개가 있는지 체크하면서 최댓값 갱신
        int [] time = new int[24*60+10];
        for(int i = 0;i<book_time.length;i++){
            String start = book_time[i][0];
            String end = book_time[i][1];
            int startTime = Integer.parseInt(start.substring(0,2)) * 60 + Integer.parseInt(start.substring(3,5));
            int endTime = Integer.parseInt(end.substring(0,2)) * 60 + Integer.parseInt(end.substring(3,5)) +10;
            time[startTime]++;
            time[endTime]--;
        }
        // 이제 time 배열에서 count 하면서
        // 최대의 개수 갱신
        int count = 0;
        for(int i = 0 ; i< time.length;i++){
            if(time[i] != 0){
                count += time[i];
            }
            answer = Math.max(answer, count);
        }
        
        
        return answer;
    }
}
