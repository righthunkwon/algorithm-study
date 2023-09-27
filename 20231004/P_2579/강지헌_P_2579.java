import java.io.*;
public class q2579 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N],dy=new int[N];
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
		
		dy[0]=arr[0]; //dy[0]초기화
		if(N>1) dy[1]=arr[0]+arr[1]; //dy[1] 초기값 넣기
		if(N>2) dy[2]=arr[2]+Math.max(arr[0], arr[1]); //dy[2] 초기값 넣기
		for(int i=3;i<N;i++) dy[i]=Math.max(dy[i-2]+arr[i], dy[i-3]+arr[i-1]+arr[i]); //2칸 뛰어서 온 경우와 2칸 뛰고 1칸을 뛰어서 온 경우중에 최대값을 갱신
		System.out.println(dy[N-1]);
	}
}
