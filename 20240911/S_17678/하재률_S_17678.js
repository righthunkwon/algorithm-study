function solution(n, t, m, timetable) {
    var answer = '';
    
    // 타임테이블 분으로 바꾸기
    timetable = timetable.map(time => Number(time.slice(0, 2)) * 60 + Number(time.slice(3)));
    // 타임테이블 오름차순 정렬
    timetable.sort((a, b) => a - b);
    // console.log(timetable)
    
    // 버스 출발 시간표
    const bus = Array.from(Array(n), (_, i) => 540 + i * t);
    console.log(bus, '버스 출발 시간표')
    
    for(let i = 0; i < bus.length; i++) {
        // 해당 버스에 탈 수 있는 승객들
        const passengers = timetable.filter(p => p <= bus[i]);
        
        // 마지막 버스일 경우
        if(i === bus.length - 1) {
            // 마지막에 탄 승객보다 1분 일찍 도착
            if(passengers.length >= m) answer = passengers[m - 1] - 1;
            // 버스 출발 시간에 도착
            else answer = bus[i];
        }
        
        // 마지막 버스 아닐 경우
        // 빈자리에 탈 수 있는 승객들 다 태우기
        if(passengers.length < m) timetable.splice(0, passengers.length);
        // 탈 수 있는 승객이 빈자리보다 많으면 다음 버스 타야하니까 m명만 태우기
        else timetable.splice(0, m);
    }
    
    // padStart(n, str) : n자리로 만들건데, 앞에 str을 채워라 <-> padEnd
    const hour = Math.floor(answer / 60).toString().padStart(2, '0');
    const minutes = (answer % 60).toString().padStart(2, '0');
    
    return `${hour}:${minutes}`;
}
