import java.util.*;

public class BOJ_G3_7512_연속하는_소수의_합 {
	static List<Integer> primeNum = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean [] isPrime = new boolean [10000001];
		Arrays.fill(isPrime, true);
		primeNum = new ArrayList<>();
		for(int i=2;i<3165;i++) {
			if(isPrime[i]) {
				int tmp = i+i;
				while(tmp<10000001) {
					isPrime[tmp]=false;
					tmp+=i;
				}
			}
		}
		//소수 리스트 만들기
		for(int i=2;i<10000001;i++)if(isPrime[i])primeNum.add(i);
		
		int t = sc.nextInt();
		for(int tc = 1;tc<=t;tc++) {
			int m = sc.nextInt(); //1~10
			int[]num = new int[m];
			for(int i=0;i<m;i++)num[i]=sc.nextInt();
			
			int ans = 0;
			
			Arrays.sort(num);
			
			TreeSet<Integer>set[] = new TreeSet[m]; //중복을 제거하고 오름차순 순서가 보장되도록 TreeSet사용
			for(int i=0;i<m;i++){
				int n = num[i];
				set[i]= new TreeSet<>();
				
				//슬라이딩 윈도우로 n크기의 구간합 소수이면 해시셋에 넣기
				int st = 0;
				int ed = n-1;
				int sum = 0;
				for(int j=0;j<=ed;j++) {
					sum+=primeNum.get(j); //n크기의 구간합 구하기 
				}
				while(ed<primeNum.size()) {
					if(sum>10000000)break; 
					if(isPrime[sum])set[i].add(sum);
					
					//if(sum<=10000000 && isPrime[sum])set[i].add(sum); 
					//이렇게 했었는데 ArrayIndexOutOfBounds 에러 뜸..
					
					sum-=primeNum.get(st);
					st++;
					ed++;
					if (ed < primeNum.size()) {
                        sum += primeNum.get(ed);
                    }
				}
			}
			
			// 모든 집합(set[0]~set[m-1])에 존재하는 가장 작은 수 찾기
            for (int el : set[m - 1]) {
                boolean flag = true;
                for (int i = 0; i < m; i++) {
                    if (!set[i].contains(el)) {
                    	flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans = el;
                    break;
                }
            }        

			// 결과 출력
            System.out.println("Scenario " + tc + ":");
            System.out.println(ans);
            System.out.println();	        
		}//tc
	}//main
}
