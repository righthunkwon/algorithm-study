import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		arr=new int[m];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) arr[i]=Integer.parseInt(st.nextToken());
		int sum=0;
		for(int i=1;i<m-1;i++) {
			int l=0,r=0;
			for(int j=0;j<=i;j++) l=Math.max(l,arr[j]);
			for(int j=i;j<m;j++) r=Math.max(r,arr[j]);
			sum+=Math.min(l,r)-arr[i];
		}
		if(sum<0) sum=0;
		System.out.println(sum);
	}
}
