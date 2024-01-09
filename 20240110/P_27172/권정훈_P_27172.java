package level_12_bruteforce;

import java.io.*;
import java.util.*;

// 수 나누기 게임
// 에라토스테네스의 체
// 배수의 정의를 생각하며 구현
public class P_27172 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N]; // 플레이어의 카드
		int[] score = new int[1000001]; // 점수
		boolean[] checked = new boolean[1000001]; // 방문처리 

		// 카드 배열 요소 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			checked[card[i]] = true; // 등록
		}

		// 에라토스테네스의 체
		// 카드(i)마다 판단하고 먼저 카드의 2의 배수를 모두 제거하고 i배수를 제거
		// 배수의 정의를 생각하여 해당 숫자를 더하면 배수가 됨을 유추해야 하는데 이런 센스가 부족해서 슬프다
        for (int i : card) {
            for (int j = i * 2; j < 1000001; j += i) {
                if (checked[j]) {
                    score[i]++; // 점수 증가
                    score[j]--; // 점수 감소
                }
            }
        }
        for (int i : card) {
            sb.append(score[i]).append(' ');
        }
		System.out.println(sb.toString());
	}
}
