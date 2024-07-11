// 예전에 본 적이 있던 문제라.....
function solution(n, times) {
    let answer = 0;
    times.sort((a,b) => a - b);// 오름차순 정렬 0번이 가장 빠름
    let left = 1;
    let right = n * times[times.length - 1]; // 큰 수 설정 => 모든 사람이 가장 느린 심사대를 통과하는 경우, 가장 빠른 심사대를 통과하는 것 기준으로 해도 풀리기는 함
    while(left <= right){
        let mid = Math.floor((right + left)/2);      
        let cnt = 0;
        for(el of times){
            cnt += Math.floor(mid / el);
            if(cnt > n) break; // n명 이상 심사 가능하면 더 이상 진행 X, for문 만 종료
        }
        if(cnt < n){ // 인원 부족
            left = mid+1; // 탐색 범위 증가
        }else{ // 인원 충분
            right = mid-1; // 최소 시간 찾아가기
            answer = mid;
        }
    }   
    return answer;
}