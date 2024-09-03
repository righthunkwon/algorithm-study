//예전에 푼거 ㅎㅎ
function solution(N, number) {
    let DP = Array.from(new Array(9), () => new Set()); // N 만큼 배열 생성, 최솟값이 8보다 크면 -1을 return
  
    if (N == number) {
      return 1;
    }
    DP.forEach((e, idx) => {
      if (idx != 0) e.add(Number(String(N).repeat(idx)));
    });
  
    for (let i = 0; i < 9; i++) {
      for (let j = 0; j < i; j++) {
        // => 이렇게 해야 first second 순서 바뀌는 것도 처리 가능
        for (let first of DP[j]) {
          for (let second of DP[i - j]) {
            //DP[i] = DP[j] 사칙연산 DP[i-j]
            DP[i].add(first + second);
            DP[i].add(first - second);
            DP[i].add(first * second);
            if (second != 0) {
              DP[i].add(Math.floor(first / second));
              // 예외처리 + 나눗셈에서 나머지 무시
            }
          }
        }
      }
      if (DP[i].has(number)) {
        return i; //
      }
    }
    return -1;
  }
  