import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[]arr=new long[6];
		for(int i=0;i<6;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		//3가지 경우
		//case 1. 한 면 노출 -> 그냥 최소값
		//case 2. 두 면 노출 -> 붙어있는 두면 최소값
		//case 3. 세 면 노출 -> 붙어있는 세면 최소값 
		//N=1인 경우 -> a~f 합 중 가장 큰거만 빼면 됨
		//N=2인 경우 -> 2번 4개 + 3번 4개
		//N=3이상 -> 1번 :(N-2)*(N-1)*4+(N-2)*(N-2)개 , 2번 : (N-2)*4+(N-1)*4 = 8N-12개, 3번:4개
		long case1 = (N-2)*(N-1)*4+(N-2)*(N-2);
		long case2 = 8*N-12;
		long case3 = 4;
		if(N==1) {
			Arrays.sort(arr);
			System.out.println(arr[0]+arr[1]+arr[2]+arr[3]+arr[4]);
		}else {
			long x1 = arr[0]; //한면 노출 경우 구하기
			for(int i=1;i<6;i++) {
				x1=Math.min(x1, arr[i]);
			}
			long x2 = 2000001; //두개합 최소값 초기화
			for(int i=0;i<6;i++) {
				for(int j=0;j<6;j++) {
					if(i!=j && i+j !=5)x2=Math.min(x2, arr[i]+arr[j]);
				}
			}
			long x3 = Math.min(arr[0], arr[5])+Math.min(arr[1], arr[4])+Math.min(arr[2], arr[3]);
			//21억 넘을 수 있으니 
			long ans = x1*case1+x2*case2+x3*case3;
			System.out.println(ans);
		}
		
	}
}


 
