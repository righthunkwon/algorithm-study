package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BOJ_2108_통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 입력받을 수들 저장할 배열
		int sum = 0; // 합 저장용
		int max = -987654312; int min = 987654312; // 최대값 최소값 저장용
		HashMap<Integer, Integer> map = new HashMap<>(); // 최빈값 구하려고 해시맵
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 입력받기
			sum += arr[i]; // 합 구하기
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // 해당 값을 key로 가지고 빈도수가 value에 저장
			max = max < arr[i] ? arr[i] : max; // 최대값 구하기
			min = min > arr[i] ? arr[i] : min; // 최소값 구하기
		}
		// 정렬부터 해주자(중앙값을 찾기 위함)
		Arrays.sort(arr);
		
		List<Integer> list = new ArrayList<>(); // 빈도수가 많은 값이 여러개가 나올 수 있음. 그것들을 저장하기 위함
		int maxBin = 0;
		// 맵에 담긴 value(빈도수) 들을 돌면서 가장 큰 놈을 찾아서
		for(int a : map.values()) maxBin = maxBin < a ? a : maxBin;
		// 빈도수가 가장 많은 놈들의 key(입력받은 값)들을 list에 담는다
		for(int a : map.keySet()) if(map.get(a) == maxBin) list.add(a);
		// 최빈값들이 여러개가 있다면, 두 번째로 작은 값을 출력해야 하기 때문에
		Collections.sort(list);
		
		int bin = 0; // 최빈값 저장용
		if(list.size() > 1) bin = list.get(1);
		else bin = list.get(0);
		
		System.out.println((int)Math.round((double)sum / N)); // 산술평균
		System.out.println(arr[N/2]); // 중앙값
		System.out.println(bin); // 최빈값
		System.out.println(max-min); // 범위
		
	}
}
