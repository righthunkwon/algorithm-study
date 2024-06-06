function solution(m, musicinfos) {
    let answer = [];
    
    // # 붙은거 소문자로 바꿔주기
    const getLowCase = (melody) => {
        return melody.replace(/(C#)/g, 'c')
                    .replace(/(D#)/g, 'd')
                    .replace(/(F#)/g, 'f')
                    .replace(/(G#)/g, 'g')
                    .replace(/(A#)/g, 'a')
                    .replace(/(B#)/g, 'b'); // 34번 테케 B#이 있다네요
    }
    
    // 분으로 바꾸기
    const getMin = (time) => {
        const [hour, min] = time.split(':').map(Number);
        return hour * 60 + min;
    }
    
    // 분 차이 구하기
    const getDiff = (st, end) => {
        return getMin(end) - getMin(st);
    }
    
    let music = musicinfos.map(info => {
        const [st, end, title, melody] = info.split(','); // 구조분해할당
        return {
            time: getDiff(st, end),
            title,
            melody: getLowCase(melody)
        };
    });
    
    // console.log('뮤직', music);
    
    m = getLowCase(m);
    music.forEach(info => {
        // 객체 분해
        let { time, title, melody } = info;
        
        // 멜로디 길이보다 시간이 작으면 멜로디 끊어주기
        if(melody.length > time) melody = melody.substring(0, time);
        // 그렇지 않으면 이어서 붙여주기
        else {
            let str = '';
            for(let i = 0; i < time; i++){
                str += melody[i%melody.length];
            }
            melody = str;
        }
        // console.log(melody);
        // 멜로디에 네오가 기억한거 들어있으면 answer에 시간과 함께 push
        if(melody.includes(m)) answer.push([title, time]);
    })
    
    // 시간으로 정렬
    answer.sort((a,b)=>b[1]-a[1])
    // 아무것도 push 안되면 (None) 리턴
    if(answer.length === 0) return '(None)';
    
    // console.log('answer: ', answer);
    
    return answer[0][0];
}
