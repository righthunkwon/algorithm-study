https://59travel.tistory.com/84 참고함..

import java.util.*;

public class Solution {

    public static String[] solution(String[] expressions) {
        List<String> answer = new ArrayList<>();
        List<Integer> answerFormat = new ArrayList<>();
        int maxFormat = 0; 
        List<String> hint = new ArrayList<>();

        // 주어진 식들에서 최대 숫자 형식을 찾고 힌트를 저장
        for (String e : expressions) {
            String[] parts = e.split(" ");
            String num1 = parts[0], func = parts[1], num2 = parts[2], ans = parts[4];

            for (int idx = 0; idx < num1.length(); idx++) maxFormat = Math.max(maxFormat, num1.charAt(idx) - '0');
            for (int idx = 0; idx < num2.length(); idx++) maxFormat = Math.max(maxFormat, num2.charAt(idx) - '0');

            //X없는 수식은 힌트 리스트에, X있는 수식은 정답 리스트에 넣기
            if (!ans.equals("X")) {
                hint.add(e);
                for (int idx = 0; idx < ans.length(); idx++) maxFormat = Math.max(maxFormat, ans.charAt(idx) - '0'); //X가 아니라면 숫자일테니 maxFormat 갱신
            } else {
                answer.add(e);
            }
        }

        // 가능한 모든 진법을 확인 (최대 숫자 형식 + 1부터 9까지)
        for (int n = maxFormat + 1; n < 10; n++) {
            boolean check = true;
            // 힌트로 주어진 모든 식을 확인
            for (String h : hint) {
                String[] parts = h.split(" ");
                String num1 = parts[0], func = parts[1], num2 = parts[2], ans = parts[4];
                
                int num1Int = Integer.parseInt(num1,n); //num1을 n진법으로 변환
                int num2Int = Integer.parseInt(num2,n);
                int ansInt = Integer.parseInt(ans,n);

                if (func.equals("+") && num1Int + num2Int != ansInt) {
                    check = false;
                    break;
                }
                if (func.equals("-") && num1Int - num2Int != ansInt) {
                    check = false;
                    break;
                }
            }

            // 해당 진법이 유효하면 저장
            if (check) {
                answerFormat.add(n);
            }
        }

        // "X"로 표시된 식들에 대해 정답을 찾음
        for (int i = 0; i < answer.size(); i++) {
            String[] parts = answer.get(i).split(" ");
            String num1 = parts[0], func = parts[1], num2 = parts[2];
            Set<String> ansSet = new HashSet<>();

            // 가능한 진법들에 대해 정답을 계산
            for (int a : answerFormat) {
                int num1Int = Integer.parseInt(num1,a); //a진법 수를 10진법으로 바꿔서
                int num2Int = Integer.parseInt(num2,a);

                //계산하고 다시 a진법으로 저장
                if (func.equals("+")) ansSet.add(Integer.toString(num1Int + num2Int,a)); 
                if (func.equals("-")) ansSet.add(Integer.toString(num1Int - num2Int,a));
            }

            // 정답이 하나면 해당 정답을 사용하고, 여러 개면 "?"로 표시
            if (ansSet.size() == 1) {
                answer.set(i, num1 + " " + func + " " + num2 + " = " + ansSet.iterator().next());
            } else {
                answer.set(i, num1 + " " + func + " " + num2 + " = ?");
            }
        }

        // 리스트를 배열로 변환하여 반환
        return answer.toArray(new String[answer.size()]);
    }

}
