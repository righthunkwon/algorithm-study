function solution(n, stations, w) {
    var answer = 0;
    
    let idx = 1; // 순회할 인덱스
    let tmp = 0; // station 인덱스
    
    while(idx <= n) {
        // 기존 기지국 범위에 들어와있으면 끝으로 idx 이동
        if(idx >= stations[tmp] - w && idx <= stations[tmp] + w) {
            idx = stations[tmp] + w;
            tmp++;
        // 그게 아니라면 설치한 범위 끝으로 이동
        } else {
            idx += w * 2;
            answer++;
        }
        idx++;
    }

    return answer;
}
