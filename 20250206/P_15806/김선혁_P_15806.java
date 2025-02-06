// 20퍼 틀림 -> 6퍼 시간초과

package com.example.algo;
import java.util.*;

public class AlgoApplication{
    static class node{
        int x;
        int y;
        int date;

        public node(int x, int y, int date) {
            this.x = x;
            this.y = y;
            this.date = date;
        }
    }

static int N, M, K ,t;
static boolean[][] arr;
static int[][] flag;
static Queue<node> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        t = sc.nextInt();

        q = new LinkedList<>();
        // 해당자리가 겹칠 경우를 대비해 true false로 구분해보자
        arr = new boolean[N+1][N+1];
        flag = new int[N+1][N+1]; // 방문한 날짜기록
        for(int i=0;i<M;i++){
            int a= sc.nextInt();
            int b= sc.nextInt();
            // 만약 짝수번째날이면 곰팡이 존재한다
            // 여기서 반례하나 -> N의 크기가 3보다 작다면 의미가 없음.
            q.add(new node(a,b,0));
        }
        // 그냥 노가다 해보자
        // 다 하고 결과일을 true처리하고 K에 속하는 애들이 있을지 확인하면 될듯
        // K값에 대한 입력은 아예 나중에
        // --> 이걸 직접 수행하면 무한루프 나오기때문에
        // 한 곰팡이가 생성과 소멸 2일 반복하는걸 이용해서
        // 또다른 boolean배열만들어서 해당 배열을 지나면 아예 큐에 넣지말고 진행하자
        solve();
        String ans = "NO";
        for(int i =0;i<K;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(arr[a][b]){
                ans = "YES";
                break;
            }
        }
        System.out.println(ans);

    }
    static int[] dx = {-1,1,-2,2,-2,2,-1,1};
    static int[] dy = {-2,-2,-1,-1,1,1,2,2};

    static void solve(){
        // 큐에서 하나씩 꺼내서 진행
        a: while(!q.isEmpty()){
            node n = q.poll();

            // 마지막 날이면 곰팡이 존재 기록
            if (n.date == t) {
                arr[n.x][n.y] = true;
                continue;
            }

            for(int idx = 0; idx < dx.length; idx++){
                int x = n.x + dx[idx];
                int y = n.y + dy[idx];
                if(x<1 || x>=N || y<1 || y>=N){
                    continue;
                }

                    // 여기서 방문도하고 처리도됬다면 x , 방문은헀지만 처리 안됬으면 o ,방문안했으면 일단 확인
                    // 추가로 처리는 되었지만 다른날 방문일떄!!!!!
                    if(flag[x][y] != 0 && ((n.date+1)%2 == flag[x][y]%2)){
                        continue;
                    }
                    q.add(new node(x,y,n.date+1));
                    flag[x][y] = n.date+1;
                    // 만약 해당 곰팡이가 2로나눈 나머지가 같다면 미리 true처리
                    if((n.date+1)%2 == t%2){
                        arr[x][y] = true;
                    }
            }
        } // while

    }
}
