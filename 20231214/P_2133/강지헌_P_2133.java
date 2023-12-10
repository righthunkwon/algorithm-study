import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		int[] dy=new int[15];
		dy[0]=3;
		dy[1]=dy[0]*3+2;
		int t=0;
		for(int i=2;i<15;i++) {
			t+=dy[i-2]*2;
			dy[i]=t+dy[i-1]*3+2;
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		if(N%2==1) System.out.println(0);
		else System.out.println(dy[N/2-1]);
	}
}
