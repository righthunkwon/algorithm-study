function solution(m, n, startX, startY, balls) {
    const answer = [];
    // 모서리 맞추는 경우는 무조건 더 길다 -> 고려 X
    // 위아래오른왼 쿠션 맞추는 경우 모두 고려.. 뚫고 지나갈때 빼고

    balls.forEach(([x, y]) => {
        const tmp = [];

        // 위 쿠션
        if(!(startX === x && startY < y))
            tmp.push((x - startX) ** 2 + (2 * n - startY - y) ** 2);

        // 아래 쿠션
        if (!(startX === x && startY > y))
            tmp.push((x - startX) ** 2 + (startY + y) ** 2);

        // 오른쪽 쿠션
        if (!(startY === y && startX < x))
            tmp.push((2 * m - startX - x) ** 2 + (startY - y) ** 2);

        // 왼쪽 쿠션
        if (!(startY === y && startX > x))
            tmp.push((startX + x) ** 2 + (startY - y) ** 2);

        // console.log(tmp)
        answer.push(Math.min(...tmp));
    });
    
    return answer;
}
