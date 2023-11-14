import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bf.readLine());
		int hap=0,max=0,d1=-1,d2=-1;
		int[] arr = new int[N];
		int[] brr = new int[8001];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			hap+=arr[i];
			brr[arr[i]+4000]++;
		}
		Arrays.sort(arr);
		for(int i=0;i<=8000;i++) {
			if(max<brr[i]) {
				max=brr[i];
				d1=i;
				d2=-1;
			}
			else if(max==brr[i] && d2==-1) {
				d2=i;
			}
		}
		if(d2!=-1) {
			d1=d2;
		}
		double d = hap/(double)N;
		if(d>-0.5 && d<0) d=0.1;
		System.out.printf("%.0f\n%d\n%d\n%d",d,arr[N/2],d1-4000,arr[N-1]-arr[0]);
	}
}
