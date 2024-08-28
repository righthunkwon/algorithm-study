function solution(picks, minerals) {
    var answer = 0;

    // 보유 곡괭이로 캘 수 있는 광물, mineral 길이 중 min값
    const cnt = Math.min(picks.reduce((acc, cur) => acc + cur, 0)*5, minerals.length);
    
    // minerals 5개씩 잘라서 [다이아, 철, 돌] 개수로 정리
    const arr = [];
    for(let i = 0; i < cnt; i++) {
        const idx = Math.floor(i / 5);
        
        if(!arr[idx]) arr[idx] = [0, 0, 0]; // [다이아, 철, 돌]
        const type = ['diamond', 'iron', 'stone'].indexOf(minerals[i]);
        arr[idx][type]++;
    }
    
    // 다이아 많은거, 같다면 철 많은거순으로 정리
    arr.sort((a, b) => b[0] - a[0] || b[1] - a[1]);
    // console.log(arr)
    
    arr.forEach((e) => {
        // i는 곡괭이 다이아, 철, 돌
        for(let i = 0; i < picks.length; i++) {
            if(!picks[i]) continue; // 곡괭이 없음
            
            // idx는 캘 광물 다이아, 철, 돌
            e.forEach((el, idx) => {
                // 곡괭이보다 광물 레벨이 낮으면 5제곱 피로도 + 
                if(idx < i) answer += Math.pow(5, i - idx) * el;
                else answer += el;
            })
            picks[i]--;
            
            return;
        }
    })
    
    return answer;
}
