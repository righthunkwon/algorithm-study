// 마지막 비트 2개를 잡고 패턴을 보면
// ~10 -> ~11 로 변환
// ~01 -> ~10 로 변환 왜 11이 아닌가? 값이 제이 작아야 하므로
// ~00 -> ~01 로 변환
// ~11 -> 이게 문제인데 그냥 0인 부분을 찾아서 떠나면 된다.
// 예외 조건 전부 111 인경우 
// 이 경우는 1011 이렇게 맨앞만 01 -> 10으로 스왑 맨앞에 0이 있다고 생각하면 쉽다.
// 비트 연산자는 풀이 참고 중
 class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                
                // 10 -> 11
                // 00 -> 01 인 경우
                answer[i] = num + 1;
            } else {
                String binary = Long.toBinaryString(num);
                if (binary.contains("0")) {
                    // 01 -> 10 인 경우
                    int idx = binary.lastIndexOf("0");
                    binary = binary.substring(0, idx) + "10" + binary.substring(idx + 2);
                } else {
                    binary = "10" + binary.substring(1);
                }
                answer[i] = Long.parseLong(binary, 2);
            }
        }
        return answer;
    }
}

// 초기 코드
// class Solution {
//     public long[] solution(long[] numbers) {
//         // 마지막 비트 2개를 잡고 패턴을 보면
//         // ~10 -> ~11 로 변환
//         // ~01 -> ~10 로 변환 왜 11이 아닌가? 값이 제이 작아야 하므로
//         // ~00 -> ~01 로 변환
//         // ~11 -> 이게 문제인데 이 경우에는 11을 잘라내고 다시 시작한다.
//         // 마지막 조건으로 인한 탈출 조건
//         // ex) 11111111(2^8-1) 이 경우는 어떻게 할거냐? => 111111111(2^9-1)
//         long[] answer = new long[numbers.length];
//         for(int i = 0; i < numbers.length; i++){
//             answer[i] = find(numbers[i]);
//         }
//         return answer;
//     }
//     public long find(long number){
//         char[] binary = Long.toBinaryString(number).toCharArray();
//         if (binary[binary.length - 2] == '1' && binary[binary.length - 1] == '1') {
//         // 마지막 11 패턴 찾기
//         int idx = binary.length - 3; // '11' 바로 앞의 인덱스에서 시작
//         while (idx >= 0 && binary[idx] == '1' && binary[idx + 1] == '1') {
//             idx -= 2; // 11 패턴을 거슬러 올라갑니다
//         }
//         idx += 2; // 올바른 시작점으로 조정

//         // 패턴을 찾았으며, 이제 그 위치에서 변환을 수행
//         if (idx >= 1) {
//             if (binary[idx - 1] == '0' && binary[idx] == '0') {
//                 // '00' -> '01'
//                 binary[idx + 1] = '1';
//             } else if (binary[idx - 1] == '0' && binary[idx] == '1') {
//                 // '01' -> '10'
//                 binary[idx] = '0';
//                 binary[idx + 1] = '1';
//             } else if (binary[idx - 1] == '1' && binary[idx] == '0') {
//                 // '10' -> '11'
//                 binary[idx + 1] = '1';
//             }
//         }
//             // char 배열을 다시 문자열로 변환하고 10진법으로 변환
//             return Long.parseLong(new String(binary), 2);
//         }else{
//             return number + 1;
//         }
//     }
// }