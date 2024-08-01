function solution(genres, plays) {
    // 장르별 가장 많이 재생된 상위 두 개
    // 장르별 재생 횟수
    var answer = [];
    
    const arr = genres.reduce((acc, cur, idx) => {
        if(!acc[cur]) {
            acc[cur] = {
                cnt: 0,
                list: [],
            };
        }
        
        acc[cur].cnt += plays[idx];
        acc[cur].list.push([idx, plays[idx]]);
        
        return acc;
    }, {});

    // console.log(arr.classic)
    // 장르별 재생횟수 많은거부터 정렬
    const sortedGenre = Object.keys(arr).sort((a, b) => arr[b].cnt - arr[a].cnt);
    // console.log(sortedGenre)
    
    sortedGenre.forEach(genre => {
        // 장르 노래 재생 횟수 정렬
        const songs = arr[genre].list.sort((a, b) => b[1] - a[1]);
        // 최대 상위 2개까지만 answer에 push
        for(let i = 0; i < Math.min(songs.length, 2); i++)
            answer.push(songs[i][0]);
    });
    
    return answer;
}
