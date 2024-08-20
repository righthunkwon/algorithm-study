function solution(numbers) {
    // string으로 바꿔서 이어붙인거 비교
    const arr = numbers.map(e => e+'').sort((a, b) => (b + a) - (a + b));
    // [0, 0, 0] 일때 '0' 출력..
    return +arr.join('') === 0 ? '0' : arr.join('');
}
