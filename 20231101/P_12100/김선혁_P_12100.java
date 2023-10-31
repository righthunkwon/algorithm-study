import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int tmp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr[i][j] =sc.nextInt();
			}
		}
		// 입력끝
		
		// 우선 시작해서 4방향 각각의 배열을 저장해서 넘길까..?
		tmp = 0;
		solve(0);
		System.out.println(tmp);
	}
	public static void solve(int cnt) {
		if(cnt==5) {
			// 5번을 모두 밀었으면 최대숫자를 찾는다.
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					tmp = Math.max(arr[i][j],tmp);
					// 최대수 갱신
				}
			}
			return;
		}
		
		int[][] arr2 = new int[N][N];// arr을 옮길 배열
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		// 복사 완료
		
		for(int i =0;i<4;i++) {
			move(i);
			// 일단 방향대로 움직이고 cnt +1
			solve(cnt+1);
			// 이걸 다했으면 원위치 
			for(int k = 0;k<N;k++) {
				for(int j =0;j<N;j++) {
					arr[k][j] = arr2[k][j];
				}
			}
			// 현재방향이 끝나게 되면
			// 다시 arr 배열을 arr2 배열로 갱신한다.
		}
		
		
	}
	// 인자로 받아서 
	// 각항마다 좌우상하 방향으로 밀기
	public static void move(int i) {
		if(i==0) {
			left();
		}
		else if(i==1) {
			right();
		}
		else if(i==2) {
			up();
		}
		else {
			down();
		}
	}
	public static void left() {
		// 왼쪽 위부터 탐색하면서
		// 일단 0이면 패스
		 for(int i=0;i<N;i++) {
             int index = 0;
             int tmp = 0;
             for(int j=0;j<N;j++) {
                 // 만약 0이 아닌 숫자가 나왔을 때
            	 // 처음 나온거면 tmp에 그 숫자를 저장하고 
            	 // 그 숫자의 위치 index를 저장 
            	 // 다음 현재 tmp 숫자랑 같은 숫자가 나오면
            	 // 왼쪽으로 쭉~ 민다 생각함
            	 // index위치의 숫자를 *2해주고 
            	 // 현재위치 0으로 바꿔줌 
            	 if(arr[i][j] != 0) {
            		 // 만약 현재 tmp랑 다른숫자 나올수도 있으므로
            		 // tmp는 초기화
            		 if(tmp==arr[i][j]) {
                         arr[i][index-1] =tmp*2;
                         tmp = 0;
                         arr[i][j] = 0;
                     }
                     else {
                         tmp = arr[i][j];
                         arr[i][j] = 0;
                         arr[i][index] = tmp;
                         index++;
                     }
                 }
             }
         }
	}
	public static void right() {
		 for(int i =0;i<N;i++) {
             int index = N-1; 
             // 시작위치는 오른쪽 끝을 기준
             int tmp = 0;
             for(int j=N-1;j>=0;j--) {
                 // 만약 0이 아닌 숫자가 나왔을 때
            	 // 처음 나온거면 tmp에 그 숫자를 저장하고 
            	 // 그 숫자의 위치 index를 저장 
            	 // 다음 현재 tmp 숫자랑 같은 숫자가 나오면
            	 // 오른쪽으로 쭉~ 민다 생각함
            	 // index위치의 숫자를 *2해주고 
            	 // 현재위치 0으로 바꿔줌 
            	 if(arr[i][j] != 0) {
            		 // 만약 현재 tmp랑 다른숫자 나올수도 있으므로
            		 // tmp는 초기화
            		 if(tmp==arr[i][j]) {
                         arr[i][index+1] =tmp*2;
                         tmp = 0;
                         arr[i][j] = 0;
                     }
                     else {
                         tmp = arr[i][j];
                         arr[i][j] = 0;
                         arr[i][index] = tmp;
                         index--;
                     }
                 }
             }
         }
	}
	public static void up() {
		// 위부터 탐색해야 한다 . (i랑 j만 교환)
		// 행을 고정하고 열만 움직이는걸 생각
		for(int j =0;j<N;j++) {
            int index = 0; 
            // 시작위치는 좌측위
            int tmp = 0;
            for(int i=0;i<N;i++) {
                // 만약 0이 아닌 숫자가 나왔을 때
           	 // 처음 나온거면 tmp에 그 숫자를 저장하고 
           	 // 그 숫자의 위치 index를 저장 
           	 // 다음 현재 tmp 숫자랑 같은 숫자가 나오면
           	 // 위로 쭉~ 민다 생각함
           	 // index위치의 숫자를 *2해주고 
           	 // 현재위치 0으로 바꿔줌 
           	 if(arr[i][j] != 0) {
           		 // 만약 현재 tmp랑 다른숫자 나올수도 있으므로
           		 // tmp는 초기화
           		 if(tmp==arr[i][j]) {
                        arr[index-1][j] =tmp*2;
                        tmp = 0;
                        arr[i][j] = 0;
                    }
                    else {
                        tmp = arr[i][j];
                        arr[i][j] = 0;
                        arr[index][j] = tmp;
                        index++;
                    }
                }
            }
        }
	}
	public static void down() {
		for(int j =0;j<N;j++) {
            int index = N-1; 
            // 시작위치는 좌측위
            int tmp = 0;
            for(int i=N-1;i>=0;i--) {
                // 만약 0이 아닌 숫자가 나왔을 때
           	 // 처음 나온거면 tmp에 그 숫자를 저장하고 
           	 // 그 숫자의 위치 index를 저장 
           	 // 다음 현재 tmp 숫자랑 같은 숫자가 나오면
           	 // 아래로 쭉~ 민다 생각함
           	 // index위치의 숫자를 *2해주고 
           	 // 현재위치 0으로 바꿔줌 
           	 if(arr[i][j] != 0) {
           		 // 만약 현재 tmp랑 다른숫자 나올수도 있으므로
           		 // tmp는 초기화
           		 if(tmp==arr[i][j]) {
                        arr[index+1][j] =tmp*2;
                        tmp = 0;
                        arr[i][j] = 0;
                    }
                    else {
                        tmp = arr[i][j];
                        arr[i][j] = 0;
                        arr[index][j] = tmp;
                        index--;
                    }
                }
            }
        }
	}

}
