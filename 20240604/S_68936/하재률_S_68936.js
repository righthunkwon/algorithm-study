function solution(arr) {
    var answer = [0, 0];
    
    const sol = (x, y, length) => {
        const st = arr[x][y];
        const half = Math.floor(length / 2);
        
        for(let i = x; i < x + length; i++){
            for(let j = y; j< y + length; j++){
                if(arr[i][j] !== st){
                    sol(x, y, half); // 2사분면
                    sol(x + half, y, half); // 1사분면
                    sol(x, y + half, half); // 3사분면
                    sol(x + half, y + half, half); // 4사분면
                    return;
                }
            }
        }
        // 압축했으면 그 값 ++
        answer[st]++;
        // console.log(answer);
    }
    
    sol(0, 0, arr.length);
  
    return answer;
}
