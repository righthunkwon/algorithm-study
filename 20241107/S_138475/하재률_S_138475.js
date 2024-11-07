function solution(e, starts) {
    var answer = [];
    // 약수... 이용해서 풀이? => 블로그
    // 약수 많이 가지면 곱셈 결과로 많이 등장
    const cnt = Array(e + 1).fill(0);
    
    // 1부터 e까지 약수 개수
    for(let i = 1; i <= e; i++) {
        for(let j = i; j <= e; j += i)
            cnt[j]++;
    }
    // console.log(cnt)
    
    // 각 숫자까지 누적 최대값
    const max = Array(e + 1).fill(0);
    let maxNum = 0;
    for(let i = e; i >= 1; i--) {
        if(cnt[i] >= cnt[maxNum]) maxNum = i;
        max[i] = maxNum;
    }
    // console.log(max)
    
    return starts.map(v => max[v]);
}
