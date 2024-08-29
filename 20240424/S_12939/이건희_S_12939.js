// 문제: 12939번 (최댓값 과 최솟값)
// 등급: Level 2
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939
function solution(s) {
    let arr = s.split(' ').sort((a,b)=>a-b)
    return arr[0]+" "+arr[arr.length-1];
}