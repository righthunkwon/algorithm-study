package _20240103;

import java.util.*;
import java.io.*;

public class _4920_테트리스게임2 {

    static int[][][] figure = {
    		// 앞부분이 행값이고 뒷부분이 열값임
        { // ㅡ
            {0, 0, 0, 0}, {0, 1, 2, 3}
        },
        { // ㅣ
            {0, 1, 2, 3}, {0, 0, 0, 0}
        },

        { // Z
            {0, 0, 1, 1}, {0, 1, 1, 2}
        },
        { // Z 90도 회전
            {0, 1, 1, 2}, {0, 0, -1, -1}
        },

        { // ㄱ
            {0, 0, 0, 1}, {0, 1, 2, 2}
        },
        { // ㄱ 90도 회전
            {0, 1, 2, 2}, {0, 0, 0, -1}
        },
        { // ㄱ 180도 회전, ㄴ
            {0, 1, 1, 1}, {0, 0, 1, 2}
        },
        { // ㄱ 270도 회전
            {0, 0, 1, 2}, {0, 1, 0, 0}
        },

        { // ㅗ
            {0, 1, 1, 1}, {0, -1, 0, 1}
        },
        { // ㅏ
            {0, 1, 1, 2}, {0, 0, 1, 0}
        },
        { // ㅜ
            {0, 0, 0, 1}, {0, 1, 2, 1}
        },
        { // ㅓ
            {0, 1, 1, 2}, {0, -1, 0, 0}
        },

        { // ㅁ
            {0, 0, 1, 1}, {0, 1, 1, 0}
        },

    };
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=0;
        while ((N = Integer.parseInt(br.readLine().trim())) != 0) {
        	tc++;
            arr = new int[N][N];
            int max = Integer.MIN_VALUE;
            for (int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    for (int a=0;a<figure.length;a++) {
                        int sum = 0;
                        boolean flag = true;
                        for (int b=0;b<4;b++) {
                            int nx = i +figure[a][0][b];
                            int ny = j +figure[a][1][b];
                            if (nx>=0 && nx<N && ny>=0 && ny<N) {
                                sum += arr[nx][ny];
                            } else {
                            	// 범위 벗어난건 더 구하지 않고 다음으로 넘어간다
                                flag = false;
                                break;
                            }
                        }
                        // 범위 내에서 구해진 합을 바탕으로 max값을 구한다
                        if (flag) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
            System.out.println(tc+". "+max);
        }
    }
}

    // 이전에 테트로미노 풀었던 dfs 방식은 이 문제에서 사용할 수 없다
    // 90도 회전을 통해 나온 블록모양만 사용할 수 있기 때문이다
    
//    static void solve(int x, int y, int sum, int cnt) {
//        if(cnt==4) {
//            max = Math.max(max, sum);
//            return;
//        }
//        
//        for(int i=0;i<4;i++) {
//            int nr = x + dr[i];
//            int nc = y + dc[i];
//            if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
//            if(!visited[nr][nc]) {
//                if(cnt==2) {
//                    visited[nr][nc]=true;
//                    solve(x,y,sum+arr[nr][nc],cnt+1);
//                    visited[nr][nc]=false;
//                }
//                visited[nr][nc]=true;
//                solve(nr,nc,sum+arr[nr][nc],cnt+1);
//                visited[nr][nc]=false;
//            }
//        }
//    }//solve

// 아래꺼 25퍼에서 계속 틀리는데 왜틀리는지 모르겠음ㅜㅜㅜㅜㅜㅜ
/////////////////////////////////////////////////////////////////////////////////////////
//public class _4920_테트리스게임 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int N=100;
//        int tc=0;
//        out: while(N!=0){
//            tc++;
//            N = Integer.parseInt(br.readLine().trim());
//            if(N==0) break out;
//            int[][] arr = new int[N][N];
//            for(int i=0;i<N;i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                for(int j=0;j<N;j++) {
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            int max=-987654321;
//            
//            for(int i=0;i<N;i++) {
//                for(int j=0;j<N;j++) {
//                    int sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0;
//                    int sum9=0,sum10=0,sum11=0,sum12=0,sum13=0;
//                    if(j+3<N) { // ㅡ
//                        sum1 += arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3];
//                    }
//                    max = Math.max(max, sum1);
//                    
//                    if(i+3<N) { // ㅣ
//                        sum2 += arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+3][j];
//                    }
//                    max = Math.max(max, sum2);
//                    
//                    if(i+1<N && j+2<N) {  // Z
//                        sum3 += arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2];
//                    }
//                    max = Math.max(max, sum3);
//                    
//                    if(i+2<N && j-1>=0) { // Z 90도회전
//                        sum4 += arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j-1];
//                    }
//                    max = Math.max(max, sum4);
//                    
//                    if(i+1<N && j+2<N) { // ㄱ
//                        sum5 += arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2];
//                    }
//                    max = Math.max(max, sum5);
//                    
//                    if(i+2<N && j-1>=0) { // ㄱ 90도 회전
//                        sum6 += arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j-1];
//                    }
//                    max = Math.max(max, sum6);
//                    
//                    if(i+1<N && j+2<N) { // ㄱ 180도 회전
//                        sum7 += arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2];
//                    }
//                    max = Math.max(max, sum7);
//                    
//                    if(i+2<N && j+1<N) { // ㄱ 270도 회전
//                        sum8 += arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+2][j];
//                    }
//                    max = Math.max(max, sum8);
//                    
//                    if(i+1<N && j+2<N) { // ㅜ
//                        sum9 += arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1];
//                    }
//                    max = Math.max(max, sum9);
//                    
//                    if(i+2<N && j-1>=0) { //ㅓ
//                        sum10 += arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j-1];
//                    }
//                    max = Math.max(max, sum10);
//                    
//                    if(i-1>=0 && j+2<N) { // ㅗ
//                        sum11 += arr[i][j]+arr[i-1][j+1]+arr[i][j+1]+arr[i][j+2];
//                    }
//                    max = Math.max(max, sum11);
//                    
//                    if(i+2<N && j+1<N) { // ㅏ
//                        sum12 += arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j+1];
//                    }
//                    max = Math.max(max, sum12);
//                    
//                    if(i+1<N && j+1<N) { // ㅁ
//                        sum13 += arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1];
//                    }
//                    max = Math.max(max, sum13);
//                    
//                }
//            }
//            
//            sb.append(tc+". "+max);
//            sb.append("\n");
//            
//        }//T
//        System.out.println(sb);
//        
//        
//        
//    }//main
//}
