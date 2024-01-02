

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 장미
// 로직 생각하는 게 어려워 구글링...
// 두 가게에서 팔고자하는 단위의 최소공배수 만큼의 장미를 구매해 더 저렴한 경우를 찾는다
// 참조: https://velog.io/@alswndit/%EB%B0%B1%EC%A4%80-3343%EB%B2%88-%EC%9E%A5%EB%AF%B8-G4
public class P_3343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		long n = Long.parseLong(st.nextToken()); // 장미 개수
		long cntA = Long.parseLong(st.nextToken()); // A 꽃다발 장미 개수
		long priceA = Long.parseLong(st.nextToken()); // A 꽃다발 가격
		long cntB = Long.parseLong(st.nextToken()); // B 꽃다발 장미 개수
		long priceB = Long.parseLong(st.nextToken()); // B 꽃다발 가격
		long ans = Long.MAX_VALUE; // 최소 비용
		long cheapCnt, cheapPrice, expensiceCnt, expensicePrice;

		// 저렴한 케이스 찾기
		// 가성비를 찾는 게 아니라,
		// A개를 B번 사는 것보다 B개를 A번 사는 것이 더 저렴하다면
		// A개를 B번 이상 살 필요가 없음을 구하는 것!!!
		if (priceB * cntA < priceA * cntB) {
			cheapCnt = cntB;
			cheapPrice = priceB;
			expensiceCnt = cntA;
			expensicePrice = priceA;
		} else {
			cheapCnt = cntA;
			cheapPrice = priceA;
			expensiceCnt = cntB;
			expensicePrice = priceB;
		}

		// 싼 꽃다발 개수만큼 탐색
		for (int i = 0; i < cheapCnt; i++) { 
			long j = (long) Math.ceil((double) (n - i*expensiceCnt) / cheapCnt);
			boolean flag = false; // 종료조건
			
			if (j < 0) {
				j = 0;
				flag = true;
			}

			// 최소비용 갱신
			ans = Math.min(ans, j*cheapPrice + i*expensicePrice);
			
			// 종료조건
			if (flag) {
				break;
			}
		}
		System.out.println(ans);
	}
}
