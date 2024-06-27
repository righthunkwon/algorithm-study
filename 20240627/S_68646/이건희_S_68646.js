function solution(a) {
    const n = a.length;
    const leftMin = new Array(n);   // 왼쪽에서부터의 최소값을 저장하는 배열
    const rightMin = new Array(n);  // 오른쪽에서부터의 최소값을 저장하는 배열
  
    // 왼쪽과 오른쪽 최소값 배열의 첫 번째와 마지막 요소 초기화
    leftMin[0] = a[0];
    rightMin[n - 1] = a[n - 1];
  
    // leftMin 배열을 채움 인덱스 i까지 왼쪽에서 발견된 최소값
    for (let i = 1; i < n; i++) {
      leftMin[i] = Math.min(leftMin[i - 1], a[i]);
    }
  
    // rightMin 배열을 채움 인덱스 i까지 오른쪽에서 발견된 최소값
    for (let i = n - 2; i >= 0; i--) {
      rightMin[i] = Math.min(rightMin[i + 1], a[i]);
    }
  
    let count = 0;
  
    // 어떤 풍선이 마지막까지 남을 수 있는지 판단
    for (let i = 0; i < n; i++) {
      // 풍선이 자신의 왼쪽 또는 오른쪽 모든 풍선보다 작지 않은 경우만 최후까지 남을 수 있음
      if ((i === 0 || a[i] > leftMin[i - 1]) && (i === n - 1 || a[i] > rightMin[i + 1])) {
        continue;
      }
      count++;
    }
    return count;
  }