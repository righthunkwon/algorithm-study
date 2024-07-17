class Solution {
    static String str;

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            str = Long.toBinaryString(numbers[i]); // 2진수 문자열로 변환
            
            // 이진트리 되려면 길이가 2^n-1 (1, 3, 7, 15, 31...) 이어야 하니까 
            // 부족한 부분 앞에 0을 추가해줘서 이진트리 형태로 바꿔줌
            int n = 1;
            int len = str.length();
            int zero = 0; // 앞에 추가적으로 필요한 0의 갯수
            while (true) {
                n *= 2;
                if (n - 1 >= len) {
                    zero = n - 1 - len;
                    break;
                }
            }
            for (int j = 0; j < zero; j++) {
                str = "0" + str;
            }
            /////////완전 이진트리 형태로 변환 완료
            
            answer[i] = check(str, 0, str.length() - 1) ? 1 : 0;
        }
 
        return answer;
    }
    
    
    private static boolean check(String str, int start, int end) {
        if (start > end) {
            return true;
        }
        
        int mid = (start + end) / 2;
        
        // 중간 노드가 '0'인 경우 그 하위 트리들도 '0'이어야 함
        if (str.charAt(mid) == '0') {
            for (int i = start; i <= end; i++) {
                if (str.charAt(i) == '1') { //1이 나오면 표현 불가능한 트리
                    return false;
                }
            }
        }
        
        // 왼쪽과 오른쪽 서브트리에 대해 재귀적으로 체크
        return check(str, start, mid - 1) && check(str, mid + 1, end);
    }
}
