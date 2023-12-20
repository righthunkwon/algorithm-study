package _20231220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1043_거짓말 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        //진실을 아는 사람들을 hashset에 저장
        Set<Integer> truthPeople = new HashSet<>();
        for (int i = 0; i < p; i++) {
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }
        //파티 사람들의 list를 list에 저장
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            List<Integer> party = new ArrayList<>();
            int partySize = Integer.parseInt(st.nextToken());
            for (int j=0; j<partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        // 파티 참가자 중 진실을 아는 사람이 있는지 확인
        for (int i=0; i<M; i++) {
        	// party 리스트  하나씩 꺼낸다
            for (List<Integer> party : parties) {
            	// 그 안에 있는 사람들을 하나씩 또 꺼내서
                for (int person : party) {
                	// 진실을 아는 사람들에 포함된 사람이 있으면
                	// 그 party리스트를 전부 진실 아는 사람에 추가한다
                    if (truthPeople.contains(person)) {
                        truthPeople.addAll(party);
                        break;
                    }
                }
            }
        }

        // 거짓말을 할 수 있는 파티 개수 계산
        int count = 0;
        // party 리스트를 하나씩 꺼낸다
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
            	// 진실 아는 사람이 있으면 거짓말 못하니까 false로 바꿔준다
                if (truthPeople.contains(person)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                count++;
            }
        }

        System.out.println(count);
    }
}
