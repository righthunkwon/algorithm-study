function solution(line) {
    // 교점 구해서 최소최대 x, y 판에다가 별찍기
    // 교점 어케 구하지
    // Ax + By + C = Dx + Ey + F 에서 x y 구하기.. 크래머 뭐시기
    // x = BF - CE / AE - BD
    // y = DC - AF / AE - BD
    
    // 교점 구하기
    const star = []; // 교점 저장용
    for(let i = 0; i < line.length; i++) {
        for(let j = 0; j < line.length; j++) {
            let [A, B, C] = line[i];
            let [D, E, F] = line[j];
            
            const tmp = (A * E) - (B * D);
            if(tmp === 0) continue;
            
            const x = ((B*F) - (C*E)) / tmp;
            const y = ((D*C) - (A*F)) / tmp;
            
            if(Number.isInteger(x) && Number.isInteger(y)) star.push([x, y]);
        }
    }
    
    // console.log(star)
    
    // 최소 최대 x, y 구하기
    const xx = star.map(v => v[0]);
    const yy = star.map(v => v[1]);
    const [minX, maxX, minY, maxY] = [Math.min(...xx), Math.max(...xx), Math.min(...yy), Math.max(...yy)];
    
    // console.log(minX, maxX, minY, maxY)
    
    const map = Array.from(Array(maxY - minY + 1), () => Array(maxX - minX + 1).fill('.'));
    // 좌표 조정해서 별찍기
    star.forEach(([x, y]) => {
        map[maxY - y][x - minX] = '*';
    })
    
    return map.map(row => row.join(''));
}
