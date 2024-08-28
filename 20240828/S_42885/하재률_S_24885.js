function solution(people, limit) {
    var answer = 0;
    // 오름차순 정렬
    people.sort((a, b) => a - b);

    let l = 0, r = people.length - 1;
    // 무거운 사람은 항상 타고, 가벼운 사람과 탈 수 있으면 같이 탄다
    while(l <= r) {
        if(people[l] + people[r] <= limit) l++;
        r--;
        answer++;
    }
    
    return answer;
}
