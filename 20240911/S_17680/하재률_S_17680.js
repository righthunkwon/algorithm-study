function solution(cacheSize, cities) {
    var answer = 0;
    let cache = [];
    
    // 캐시크기 0일때!!
    if(cacheSize === 0) return cities.length * 5;
    
    cities.forEach(v => {
        const city = v.toLowerCase();
        // miss일 경우
        if(!cache.includes(city)) {
            // 캐시 꽉찼을때는 빼고
            if(cache.length >= cacheSize) cache.pop();
            // 앞에 넣고 실행시간 +5
            cache.unshift(city);
            answer += 5;
        } else {
            // hit 일 경우 빼서 처음으로 넣기
            cache.splice(cache.indexOf(city), 1);
            cache.unshift(city);
            answer++;
        }
    })
    
    return answer;
}
