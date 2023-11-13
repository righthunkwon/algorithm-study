import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int[]arr = new int[N];
		
		for(int i = 0; i<M; i++)arr[sc.nextInt()]=1;
		
		while(K>0) {
			
			int[]tmp=new int[N]; //임시 저장용 배열
			
			if(arr[1]+arr[N-1]==0 || arr[1]+arr[N-1]==2)
				tmp[0]=0;
			else tmp[0]=1;
			
			for(int i=1;i<N-1;i++) {
				if(arr[i-1]+arr[i+1]==0 || arr[i-1]+arr[i+1]==2)
					tmp[i]=0;
				else tmp[i]=1;
			}
			
			if(arr[0]+arr[N-2]==0 || arr[0]+arr[N-2]==2)
				tmp[N-1]=0;
			else tmp[N-1]=1;
			
			arr=tmp.clone(); //복사
			
			K--;
		}
		
		int cnt =0;
		
		for(int i=0;i<N;i++) cnt+=arr[i];
		
		System.out.println(cnt);
		
	}

}
