import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int K;
	static int N;
	static String[] arr;
	static ArrayList<String> ans;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); // 조합숫자의 개수
		N = sc.nextInt(); // 총 숫자 개수
		
		arr = new String[N];
		for(int i =0;i<N;i++) {
			arr[i] = sc.next();			
		}
		
		Arrays.sort(arr);
		ans = new ArrayList<>();
		// 일단 입력받아서 정렬함
		// 이제 선정
		choice(0,0);
		
	}
	public static void choice(int idx,int cnt) {
		if(cnt==K) {
			// k개 만큼 선정완료
			if(solve()) {
				// 조건을 만족하는 경우
				// ans배열을 출력
				for(int i =0;i<K;i++) {
					System.out.print(ans.get(i));
				}
				System.out.println();
			}
			return;
		}
		// 선정한것은 ans에 추가하고
		// 선정하지 않은 것은 추가 x
		int i=idx;
		if(idx==N) { // N까지 모두 탐색하면 끝
			return;
		}
			ans.add(arr[i]);
			choice(i+1,cnt+1);
			ans.remove(ans.size()-1);
			choice(i+1,cnt);
		
		
	}
	public static boolean solve() {
		int a =0;
		int b= 0;
		// 모음이면 a를 ++
		// 아니면 b를 ++해줘서
		// 모음의 개수와 아닌것의 개수를 구한다.
		for(int i =0;i<K;i++) {
			if(ans.get(i).equals("a") || ans.get(i).equals("e") || ans.get(i).equals("i") || ans.get(i).equals("o") || ans.get(i).equals("u")) {
				a++;
			}
			else {
				b++;
			}
		}
		// 개수를 모두 구했으면 이제
		// a가 1개이상이고 b가 2개이상인지
		// 판별하고 맞으면 flag는 true로 바꾼다.
		if(a>=1 && b>=2) {
			return true;
		}
		return false;
	}
	
}
