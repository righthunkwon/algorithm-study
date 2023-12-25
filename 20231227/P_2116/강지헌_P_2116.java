import java.io.*;
import java.util.*;
public class Main {
	static int side[]={5,3,4,1,2,0};
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		arr=new int[n][6];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		int ans=0,sum=0;
		for(int i=0;i<6;i++) {
			int t=arr[0][i];
			sum=check(t,0,i);
			for(int j=1;j<n;j++) {
				for(int k=0;k<6;k++) {
					if(t==arr[j][k]) {
						sum+=check(arr[j][k],j,k);
						t=arr[j][side[k]];
						break;
					}
				}
			}
			ans=Math.max(ans,sum);
		}
		System.out.println(ans);
	}
	static int check(int a,int b,int x) {
		int t=0;
		for(int i=0;i<6;i++) if(arr[b][i]!=arr[b][x] && arr[b][i]!=arr[b][side[x]]) t=Math.max(t,arr[b][i]);
		return t;
	}
}
