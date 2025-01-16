import java.util.*;

public class Main {
	static final int LIMIT = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 소수와 소수 집합 생성
        Set<Integer> primeSet = new HashSet<>();
        List<Integer> primes = new ArrayList<>();

        // 에라토스테네스의 체
        boolean[] isPrime = new boolean[LIMIT + 1];
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= LIMIT; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 2; i <= LIMIT; i++) {
            if (!isPrime[i]) { 
                primes.add(i);// 소수만 리스트에 추가
                primeSet.add(i);// 집합에도 추가
            }
        }

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int m = sc.nextInt();
            int[] input = new int[m];

            for (int i = 0; i < m; i++) {
                input[i] = sc.nextInt();
            }

            int result = find(input, primes, primeSet);
            if (t > 1) System.out.println();
            System.out.println("Scenario " + t + ":");        
            System.out.println(result);
        }

        sc.close();
    }

    public static int find(int[] input, List<Integer> primes, Set<Integer> primeSet) {
        List<Set<Integer>> primeSums = new ArrayList<>(); // 각 n값에 대한 소수 합 집합 리스트

        for (int n : input) {
            Set<Integer> currentSums = new HashSet<>(); // 현재 n값에 대한 소수 합 집합
            int windowSum = 0;

            // 처음 n개의 소수의 합 계산
            for (int i = 0; i < n; i++) {
                windowSum += primes.get(i);
            }
            if (primeSet.contains(windowSum)) { // 합이 소수인지 확인
                currentSums.add(windowSum);
            }

            // 슬라이딩 윈도우로 n개의 연속된 소수 합 계산
            for (int i = 1; i <= primes.size() - n; i++) {
                windowSum = windowSum - primes.get(i - 1) + primes.get(i + n - 1); // 윈도우 이동
                if (windowSum > LIMIT) break; // 합이 범위를 초과하면 종료
                if (primeSet.contains(windowSum)) { // 합이 소수인지 확인
                    currentSums.add(windowSum);// 이거 안하면 2번째 테케에서 터짐
                }
            }

            primeSums.add(currentSums); // 현재 n값에 대한 소수 합 집합 저장
        }

        // 모든 소수 합 집합의 교집합 찾기
        Set<Integer> common = new HashSet<>(primeSums.get(0)); // 첫 번째 집합으로 초기화
        for (int i = 1; i < primeSums.size(); i++) {
            Set<Integer> nextSet = primeSums.get(i);
            Set<Integer> tempSet = new HashSet<>();
            for (int value : common) {
                if (nextSet.contains(value)) {
                    tempSet.add(value); // 공통된 값만 추가
                }
            }
            common = tempSet; // 교집합으로 갱신
        }

        // 교집합에서 가장 작은 값 찾기
        int minValue = Integer.MAX_VALUE;
        for (int value : common) {
            if (primeSet.contains(value) && value < minValue) { // 최종 합도 소수인지 확인
                minValue = value;
            }
        }

        return common.isEmpty() ? -1 : minValue; // 교집합이 비었으면 -1 반환
    }
}
