function solution(routes) {
    let answer = 1;
    routes.sort((a, b) => a[1] - b[1] || a[2] - b[2]);
    // console.log(routes)
    
    let camera = routes[0][1];
    
    for(let i = 1; i < routes.length; i++) {
        if(camera < routes[i][0]) {
            answer++;
            camera = routes[i][1];
        }
    }
    
    return answer;
}
