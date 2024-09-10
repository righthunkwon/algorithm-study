function solution(cacheSize, cities) {
    const MISS = 5, HIT = 1;
    if (cacheSize === 0) return MISS * cities.length;
    let answer = 0,
        cache = [];
    cities.forEach(city => {
        city = city.toLowerCase();

        let idx = cache.indexOf(city);

        if (idx > -1) {
            cache.splice(idx, 1);
            answer += HIT;
        } else {
            if (cache.length >= cacheSize) cache.shift();
            answer += MISS;
        }
        cache.push(city);
    });
    return answer;
}