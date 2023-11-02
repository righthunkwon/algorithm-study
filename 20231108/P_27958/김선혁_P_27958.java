import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int[][] arr;
	static int[][] arr2;
	static int[] pos; // 사격할 위치
	static int[] power; // 총알힘
	static int max;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][N];
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		power = new int[K];
		for(int i =0;i<K;i++) {	
			power[i] = sc.nextInt();
		}
		arr2 = new int[N][N];
		// 어차피 주변으로 파생되는거니깐 
		// 표적 저장하지말아보자
		max = 0;
		pos = new int[K]; // 총알 개수만큼 위치 선정
		choose(0,0);
		System.out.println(max);
	}
	// 쏠 위치 선정
	public static void choose(int cnt, int idx) {
		if(cnt==K) {
			// k개 만큼 선정하면 총쏘자 
			int score = shoot();
			max = Math.max(score, max);
			return;
		}
		for(int c =0;c<N;c++) {
			arr2[c] = Arrays.copyOf(arr[c],arr[c].length);
		}
		
		for(int i =0;i<N;i++) {
			pos[cnt] = i; // 해당번째 선정
			choose(cnt+1,idx);
			for(int c =0;c<N;c++) {
				arr2[c] = Arrays.copyOf(arr[c],arr[c].length);
			}
			
		}
		return;
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static int shoot() {
		// arr2 배열에서 게임을 해보자
		int score = 0;
		int[][] middle = new int[N][N]; // 중간점수 기록하기 위한 것
		for(int i =0;i<K;i++) {
			// 0번부터 K번째까지(총알개수) 시작
			int x = pos[i];
			// pos[i],0에서 시작
			for(int j=0;j<N;j++) {
				// 오른쪽으로 이동해보자
				// 보너스라면
				if(arr2[x][j]>=10) {
					score += arr2[x][j];
					arr2[x][j] = 0;
					break;
				}
				// 표적이라면
				else if(arr2[x][j]!=0) {
					// 총알파워가 더 쎄면 둘다 없어지게 하고 
					// 아니면 arr2배열에서 그만큼 -
					if(power[i]>=arr2[x][j]) {
						int tmp = (arr2[x][j]+middle[x][j])/4; // 중간에 깎았던 점수 + 현재 값
						score += arr2[x][j]+middle[x][j]; // 그값만큼 점수 증가
						middle[x][j] = 0; // 두개다 모두 0으로 바꿔줌
						arr2[x][j] =0;
						// 주변 4군데 총알 퍼트리기
						a : for(int in=0;in<4;in++) {
							int tmpx = x+dx[in];
							int tmpy = j+dy[in];
							// 배열내인지 확인
							if(tmpx<0 || tmpx >=N || tmpy<0 || tmpy>=N || arr2[tmpx][tmpy] !=0) {
								continue a;
							}
							arr2[tmpx][tmpy] = tmp;
						}
					}
					else {
						middle[x][j] += power[i];
						arr2[x][j] -= power[i];
					}
					break; 
				}
				// 표적도 보너스도 아니면 그냥 j 증가		
				
			} // j for
		} // i for
		return score;
		
	}
}
