import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []arr=new int[N];
		int hap=0;
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
			hap+=arr[i];
		}
		double sansul = hap/(double)N;
		
		//1.산술평균 출력
		System.out.println(Math.round(sansul)); 
		
		Arrays.sort(arr);//오름차순 정렬
		
		//2.중앙값 출력(N은 홀수이므로)
		System.out.println(arr[N/2]);
		
		int[]cnt=new int[N]; //빈도수 저장 배열
		
		int maxBin = 0; //최빈값 초기화
		
		int []maxBinArr = new int[2]; //최빈값 저장해둘 배열(중복을 위해 2개짜리)
		maxBinArr[1]=4001; //두번째자리에는 일단 들어올 수 없는 값으로 초기화
		
		for(int i=1;i<N;i++) {
			if(arr[i]==arr[i-1]) { //전꺼랑 같으면 +1씩 빈도수 더해줌
				cnt[i]=cnt[i-1]+1;
				if(cnt[i]>maxBin) { //더 많이 나온 수 있으면 
					maxBin=cnt[i]; //최빈값 갱신
					maxBinArr[0]=arr[i]; //갱신했으면 최빈수 최초값을 저장하고
					maxBinArr[1]=4001;//두번째는 비움(올 수 없는 값 넣기)
				}else if(cnt[i]==maxBin) { //최빈수와 동일한 빈도수가 되면
					if(maxBinArr[1]==4001) { 
						maxBinArr[1]=arr[i]; //두번쨰 비어있으면 넣음
					}
				}
			}else cnt[i]=0;
		}
		
		//3.최빈값 출력
		if(maxBin==0) { //최빈값이 0이라는건 다 돌았는데 겹치는 수 없다는 것..
			if(N==1) { //N이 1개면 첫번째 값 출력
				System.out.println(arr[0]);
			}else
			System.out.println(arr[1]);//N이 2이상이면 두번째 값을 출력 
		}else { //최빈값이 0이 아니라면
			if(maxBinArr[1]==4001) { //최빈값이 동일한게 없으면
				System.out.println(maxBinArr[0]); //최빈값배열 첫번째꺼 출력
			}else System.out.println(maxBinArr[1]); //동일한게 있으면 두번째꺼 출력
		}
		
		
		//4.범위 출력
		int range = arr[N-1]-arr[0];
		System.out.println(range); 
		
		
	}//main
}//class
