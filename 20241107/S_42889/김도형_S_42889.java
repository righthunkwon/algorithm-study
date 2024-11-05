import java.io.*;
import java.util.*;
class Solution {  
    public int[] solution(int N, int[] stages) {
        int[] failCnt = new int[N+2];
        
        //{스테이지번호,실패율} 저장
        double [][] fail_percent = new double[N+1][2];

        //스테이지 별 멈춰있는 사람 수 구하기
        for(int i=0;i<stages.length;i++){
            failCnt[stages[i]]++;
        }
        
        int sum = failCnt[N+1]; //마지막 스테이지 까지 클리어한 사람으로 누적합 초기화
        
        //뒤에서부터 누적합으로 스테이지 도달한 사람 수 구하면서, 실패율 계산
        for(int i=N;i>0;i--){
            sum+=failCnt[i];
            fail_percent[i][0]=i;
            if(sum==0){
                fail_percent[i][1]=0;
                continue;   
            }
            fail_percent[i][1]= failCnt[i]/(double)sum;
        }
        
        //예외처리 (0번 인덱스에 음수 넣어서 뒤로 빼버리기)
        fail_percent[0][1]=-1;
        
        // 실패율 높은순으로 정렬(실패율 같으면 스테이지 번호 낮은순)
        Arrays.sort(fail_percent, (a, b) -> {
            if (b[1] == a[1]) {
                return Double.compare(a[0], b[0]);
            }
            return Double.compare(b[1], a[1]); 
        });
        
        //정답 배열에 옮기기
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) fail_percent[i][0];
        }
        
        return answer;
    }
}
