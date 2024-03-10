package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q2539_모자이크 {
    static int r,c,paperNum,max;
    static boolean []arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); //행
        c = Integer.parseInt(st.nextToken()); //열
        paperNum = Integer.parseInt(br.readLine()); //색종이 장수 (100이하)
        int wrongNum = Integer.parseInt(br.readLine()); //잘못 질해진 칸 개수
        arr = new boolean [1000001];
        max = 0;//가장 큰 x값
        for(int i=0;i<wrongNum;i++) {
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y]=true;
            max = Math.max(max, x);
        }
        int left = max; //밑변에서 제일 거리가 먼 잘못칠해진 칸을 포함하려면 색종이가 최소 그거보다는 크거나 같아야함
        int right = 1000000;
        int answer = 1000000;
        while (left <= right) {
            int mid = (left + right) / 2; // 중간값을 기준으로 색종이 크기 설정
            if (check(mid)) { // mid 크기의 색종이로 모든 잘못 칠해진 칸을 커버할 수 있는 경우
                answer = mid; // 정답 업데이트
                right = mid - 1; // 더 작은 크기의 색종이로도 가능한지 탐색
            } else {
                left = mid + 1; // 더 큰 크기의 색종이가 필요한 경우
            }
        }
        System.out.println(answer); // 필요한 최소 색종이 크기 출력
        
        
    }//main
    
    //a : 사용할 색종이 크기
    public static boolean check(int a) {
        int cnt = 0;
        if(c-a+1<0) {
            return true;
        }
        
        for(int i=0;i<c-a+1;) {
            if(arr[i]==true) {
                cnt++;
                i+=a;
            }else {
                i++;
            }
        }
        
        //나머지 중에 하나라도 잘못 칠한거 있으면 +1
        for(int i=c-a+1;i<c;i++) {
            if(arr[i]==true) {
                cnt++;
                break;
            }
        }
        
        //가능여부 체크
        if(cnt<=paperNum) {
            return true;
        }
        return false;
    }
    
}//class
