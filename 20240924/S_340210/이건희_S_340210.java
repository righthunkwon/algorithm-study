// 1. 최소 진법 선택 => 예제 4,5에서 터짐 방지
// 2. 가능한 진법 찾기
// 3. 전체에서 유효한지 실제로 계산해서 체크하고
// 4. 채워넣고 출력
import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String> result = new ArrayList<>();

        Set<Integer> bases = findbases(expressions);

        // 지워진 결괏값이 있는 수식을 채워 넣음
        for (String expr : expressions) {
            if (expr.endsWith("= X")) {
                String filledExpr = fill(expr, bases);
                result.add(filledExpr);
            }
        }

        return result.toArray(new String[0]);
    }

    // 가능한 진법을 찾는 메서드
    private Set<Integer> findbases(String[] expressions) {
        Set<Character> digitsUsed = new HashSet<>();
        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            String[] numbers = {parts[0], parts[2], parts[4]};
            for (String num : numbers) {
                if (!num.equals("X")) {
                    for (char c : num.toCharArray()) {
                        digitsUsed.add(c);
                    }
                }
            }
        }

        // 사용된 숫자의 최대 자릿수로 최소 진법 결정
        int maxDigit = 0;
        for (char c : digitsUsed) {
            int digit = Character.digit(c, 10);
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }
        int minBase = maxDigit + 1;
        if (minBase < 2) {
            minBase = 2;
        }

        Set<Integer> bases = new HashSet<>();
        for (int base = minBase; base <= 9; base++) {
            boolean isValidBase = true;
            for (String expr : expressions) {
                if (expr.endsWith("= X")) continue;
                if (!validExp(expr, base)) {
                    isValidBase = false;
                    break;
                }
            }
            if (isValidBase) {
                bases.add(base);
            }
        }

        return bases;
    }

    private boolean validNum(String num, int base) {
        for (char c : num.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (digit >= base || digit == -1) {
                return false;
            }
        }
        return true;
    }

    // 수식이 주어진 진법에서 유효한지 확인하는 메서드
    private boolean validExp(String expr, int base) {
        String[] parts = expr.split(" ");
        String A = parts[0];
        String op = parts[1];
        String B = parts[2];
        String C = parts[4];

        if (!validNum(A, base) || !validNum(B, base) || !validNum(C, base))
            return false;

        int numA = Integer.parseInt(A, base);
        int numB = Integer.parseInt(B, base);
        int numC = Integer.parseInt(C, base);

        if (op.equals("+")) {
            return numA + numB == numC;
        } else {
            return numA - numB == numC;
        }
    }

    // 지워진 결괏값을 채우는 메서드
    private String fill(String expr, Set<Integer> bases) {
        String[] parts = expr.split(" ");
        String A = parts[0];
        String op = parts[1];
        String B = parts[2];

        String resultStr = null;
        boolean consistent = true;

        for (int base : bases) {
            if (!validNum(A, base) || !validNum(B, base)) continue;

            int numA = Integer.parseInt(A, base);
            int numB = Integer.parseInt(B, base);
            int result = op.equals("+") ? numA + numB : numA - numB;

            if (result < 0) continue;

            String tmpResultStr = Integer.toString(result, base).toUpperCase();

            if (!validNum(tmpResultStr, base)) continue;

            if (resultStr == null) {
                resultStr = tmpResultStr;
            } else if (!resultStr.equals(tmpResultStr)) {
                consistent = false;
                break;
            }
        }

        String filledResult;
        if (consistent && resultStr != null) {
            filledResult = resultStr;
        } else {
            filledResult = "?";
        }
        return A+" "+op+" "+B+" = "+filledResult;
    }
}