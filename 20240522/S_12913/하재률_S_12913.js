function solution(land) {
  // Math.max(...land) : land 배열 중 가장 큰 값을 반환
  // land.reduce(acc, cur) acc: 누산기. 콜백의 반환값을 누적 cur: 현재 요소
  // 끝에 있는 [0, 0, 0, 0] 은 initialValue
    return Math.max(...land.reduce((acc, cur)=> {
        // console.log(acc, cur)
        return[
     cur[0] + Math.max(acc[1], acc[2], acc[3]),   
     cur[1] + Math.max(acc[0], acc[2], acc[3]),   
     cur[2] + Math.max(acc[0], acc[1], acc[3]),   
     cur[3] + Math.max(acc[0], acc[1], acc[2]),   
    ]},[0,0,0,0]));
}
