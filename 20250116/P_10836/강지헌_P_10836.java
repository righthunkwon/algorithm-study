import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int[][] arr=new int[m][m];
		int[] order=new int[2*m];
		for(int t=0;t<n;t++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			order[a]++;
			order[a+b]++;
		}
		int sum=0,idx=0;
		for(int i=m-1;i>=0;i--) {
			sum+=order[idx++];
			arr[i][0]=sum;
		}
		for(int i=1;i<m;i++) {
			sum+=order[idx++];
			arr[0][i]=sum;
		}
		for(int i=1;i<m;i++)
			for(int j=1;j<m;j++) arr[i][j]=arr[0][j];
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) System.out.print(arr[i][j]+1+" ");
			System.out.println();
		}
	}
}
