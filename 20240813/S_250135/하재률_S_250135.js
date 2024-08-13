function solution(h1, m1, s1, h2, m2, s2) {
    var answer = 0;
    
    // 초로 변환
    const getSecond = (h, m, s) => {
        return h * 3600 + m * 60 + s;
    }
    
    // 각도계산
    // 1초에 초침: 6도, 분침: 1/10도, 시침: 1/120도
    // 1분에 분침: 6도, 시침: 1/2도
    // 1시간에 시침: 30도
    const getDegree = (s) => {
        let hour = Math.floor(s / 3600);
        if(hour >= 12) hour = hour - 12;
        const minute = Math.floor(s % 3600 / 60);
        const second = s%3600%60;
        
        let hourDegree = hour * 30 + minute * 1/2 + second * 1/120;
        if(hourDegree >= 360) hourDegree = hourDegree - 360;
        let minuteDegree = minute * 6 + second * 1/10;
        let secondDegree = second * 6;
        
        return [hourDegree, minuteDegree, secondDegree];
    }
    
    
    // 시침과 겹치나요
    const overlapHour = (s) => {
        const [curHour, , curSecond] = getDegree(s);
        const [nextHour, , nextSecond] = getDegree(s+1);
        if(curHour > 354 && curSecond === 354) return true;
        return curHour > curSecond && nextHour < nextSecond;
    }
    
    // 분침과 겹치나요
    const overlapMinute = (s) => {
        const [, curMinute, curSecond] = getDegree(s);
        const [, nextMinute, nextSecond] = getDegree(s+1);
        if(curMinute > 354 && curSecond === 354) return true;
        return curMinute > curSecond && nextMinute < nextSecond;
    }
    
    const st = getSecond(h1, m1, s1);
    const end = getSecond(h2, m2, s2);
    
    // 0초 또는 12시 0분 0초
    if (st === 0 || st === 43200) answer++;
    
    for(let i = st; i < end; i++) {
        const [nh, nm, ns] = getDegree(i+1);
        
        if(overlapHour(i) && overlapMinute(i)) {
            if(nh === nm) answer++;
            else answer += 2;
        } else if(overlapHour(i) || overlapMinute(i)) answer++;
    }
    
    return answer;
}
