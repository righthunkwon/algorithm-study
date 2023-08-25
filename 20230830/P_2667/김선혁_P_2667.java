import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			}
		}

		int cnt =0;
		ArrayList<Integer> aList = new ArrayList<>();
		aList.add(0);
		aList.add(0);
		int change =2;

		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		boolean flag= false;
		while(true) {
			flag = false;
			a:	for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]== 1) {
						arr[i][j] = change;
						flag = true;
						break a;
					}
				}
			}			
			while(true) {
				int tmp =0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j] == change) {
							for(int index =0;index<4;index++) {
								if(i+dx[index]>=0 && i+dx[index]<N && j+dy[index]>=0 && j+dy[index]<N) {
									if(arr[i+dx[index]][j+dy[index]] ==1) {
										arr[i+dx[index]][j+dy[index]]=change;
										tmp++;
									}
								}
							}
						} // if 문
					}
				}
				if(tmp ==0) {
					break;
				}
			}
			change++;
			if(!flag) {
				break;
			}

		} // while 문
		//		for(int i=0;i<N;i++) {
		//			for(int j=0;j<N;j++) {
		//				System.out.print(arr[i][j]);
		//			}
		//		System.out.println();
		//		}

		//		int[] count = new int[change+1];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(aList.size()<=arr[i][j]) {
					aList.add(0);
				}
				aList.set(arr[i][j], aList.get(arr[i][j])+1);
			}
		}
		aList.remove(0);
		aList.remove(0);
		int[] ans = new int[aList.size()];
		for(int i=0;i<aList.size();i++) {
			ans[i] = aList.get(i);
		}
		Arrays.sort(ans);
		System.out.println(ans.length);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}


	}	
}
