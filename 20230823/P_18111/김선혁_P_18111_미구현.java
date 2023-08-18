import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
    // 버퍼드써야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2차원 배열에서 각 땅의 높이가
        // 균일한 상태로 만들기
        // 일단 완전탐색    
        // 비교해서 더 작은 시간을 정답으로
        // 그때의 높이를 출력 +
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int K =Integer.parseInt(st.nextToken());        
        int[] arr = new int[N*M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i*M+j]=Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr);
        // 2차원 배열 N*M에 모두 입력완료

        int t=0;        //좌표마다 걸리는시간
        int height=0; // 기준점이 되는 좌표 높이
        int min=987654321; // 최소걸리는시간
        int maxh =-1; //최대높이 //땅의 높이는 0에서 256사이이기 때문에 기준점 0이될수도있어 -1로설정
        for(int i=arr[arr.length-1];i>=arr[0];i--) {

            t=0; // 좌표마다 t=0으로 초기화
            height = i; // 현재 위치를 height임시변수에
            int block = K; // 현재 가지고 있는 블록의 개수 - 기준좌표마다 복구
            // 기준점이 되는 좌표를 for문을 통해 정해서 
            // 완전탐색으로 구하기
            a : for(int k=0;k<N*M;k++) {
//                for(int l=0;l<M;l++) {
                    int tmp = height - arr[k]; // 두개의 차를 tmp로 놓고
                    // 이것이 음수이면 그만큼 채워야하고 양수면 -1로
                    if(tmp<0) {                            
                        t+=(-2)*tmp; // 제거하는데 2초므로 t는(-2)* tmp만큼
                        block+=(-1)*tmp;
                    }
                    else {
                        t+=tmp; // 추가하는데 1초므로 t는 tmp만큼
                        block-=tmp;
//                        if(block<0) { // 가진 블록의 개수가 부족하다면 
//                            t = min+1;
//                            break a;        // 기준점의 좌표가 잘못된것이므로 기준점 좌표를 바꿔야함
//                        }
                    }
                    // 시간초과떠서 중간에 조건 추가함
                    // 최소값보다 이미 많이걸리면 break
                    if(min<t) {
                        break a;
                    }
//                } // l for문
            } // k for문            
            if(min>t && block>=0) {                
                    min = t;
                    maxh = height;
                }
            
            // 모든 차이가 끝나고 높이가 가장로 저장

        } // i for문

        System.out.println(min+" "+maxh);




    }
}
