package _20240228;
//ㅅㅣ간초과...
import java.util.*;
import java.io.*;

public class _16235_나무재테크 {
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 추가할 양분
		Queue<int[]> plus = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				plus.add(new int[] {i,j,Integer.parseInt(st.nextToken())});
				arr[i][j] = 5; // 초기 양분 넣어준다
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			// 나이가 어린 나무가 먼저 나오도록 설정
            public int compare(int[] o1, int[] o2) {
                if (o1[2] < o2[2]) return -1;
                else return 1;
            }
        });
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			q.add(new int[] {a-1,b-1,c});
			
		}
		
        for(int year=0; year<K; year++) {
            // 봄 & 여름
            int size = q.size();
            
            // 산 나무랑 죽은 나무를 나눠서 변화된 내용을 저장
            Queue<int[]> alive = new LinkedList<>();
            Queue<int[]> dead = new LinkedList<>();
            for(int i=0; i<size; i++) {
                int[] tree = q.poll();
                if(arr[tree[0]][tree[1]] >= tree[2]) {
                    arr[tree[0]][tree[1]] -= tree[2];
                    alive.add(new int[] {tree[0], tree[1], tree[2]+1});
                } else {
                    dead.add(new int[] {tree[0], tree[1], tree[2]});
                }
            }
            // 여름 : 죽은 나무를 양분으로 추가(앞에서 같이하면 양분이 계속 추가되니까 따로해야함.)
            while(!dead.isEmpty()) {
                int[] tree = dead.poll();
                arr[tree[0]][tree[1]] += tree[2] / 2;
            }

            // 가을 : 번식 저장
            for(int[] tree : alive) {
                q.add(tree);
                if(tree[2] % 5 == 0) {
                    for(int i=0; i<8; i++) {
                        int nx = tree[0] + dx[i];
                        int ny = tree[1] + dy[i];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            q.add(new int[] {nx, ny, 1});
                        }
                    }
                }
            }

            // 겨울 : 양분 추가
            for(int[] p : plus) {
                arr[p[0]][p[1]] += p[2];
            }
        }//for
		System.out.println(q.size());
	}//main

}
