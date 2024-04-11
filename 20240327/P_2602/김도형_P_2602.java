import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = new String(br.readLine());
		String str1 = new String(br.readLine());
		String str2= new String(br.readLine());
		
		char[]arr = str.toCharArray();
		char[]devil = str1.toCharArray();
		char[]angel = str2.toCharArray();

		//dp배열 초기화
		int [][] devilStart= new int[devil.length][arr.length]; //악마다리 먼저 건너는 경우 dp
		int [][] angelStart= new int[angel.length][arr.length]; //천사다리 먼저 건너는 경우 dp
		
		//dp 시작점 초기화(첫 글자 일치하면 1로)
		if(devil[0]==arr[0])devilStart[0][0]=1; 
		if(angel[0]==arr[0])angelStart[0][0]=1;
		
		for(int i=1;i<devil.length;i++) {

			// 현재 위치에서 첫 글자가 일치하는 경우, 이전 경우의 수에 1을 더해줌
			devilStart[i][0] = devil[i]==arr[0] ? devilStart[i-1][0]+1 : devilStart[i-1][0];
			for(int j=1;j<arr.length;j++) {
				// 악마 다리를 건너면서, 현재 글자가 일치할 경우 이전 위치의 경우의 수를 더해줌
				devilStart[i][j]= devil[i]==arr[j]? devilStart[i-1][j]+angelStart[i-1][j-1]:devilStart[i-1][j];
			}

			//천사다리부터 건너는 경우도 동일
			angelStart[i][0] = angel[i]==arr[0]? angelStart[i-1][0]+1 : angelStart[i-1][0];
			for(int j=1;j<arr.length;j++) {
				angelStart[i][j]= angel[i]==arr[j]? angelStart[i-1][j]+devilStart[i-1][j-1]:angelStart[i-1][j];
			}			
		}

		//악마 다리와 천사 다리의 마지막 요소의 합 출력
		int ans = devilStart[devil.length-1][arr.length-1]+ angelStart[angel.length-1][arr.length-1];
		System.out.println(ans);
		
		
	}
}
