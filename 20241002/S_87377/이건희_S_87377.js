function solution(line) {
	let answer = [];
	const points = [];
	let maxX = Number.MIN_SAFE_INTEGER;
	let minX = Number.MAX_SAFE_INTEGER;
	let maxY = Number.MIN_SAFE_INTEGER;
	let minY = Number.MAX_SAFE_INTEGER;
	// let maxX = -987654321;
	// let minX = 987654321;
	// let maxY = -987654321;
	// let minY = 987654321;

	for (let i = 0; i < line.length; i++) {
		const [A, B, E] = line[i];
		for (let j = i + 1; j < line.length; j++) {
			const [C, D, F] = line[j];
			const cross = A * D - B * C;
			if (cross !== 0) {
				const x = (B * F - E * D) / cross;
				const y = (E * C - A * F) / cross;

				if (Number.isInteger(x) && Number.isInteger(y)) {
					points.push([x, y]);

					maxX = Math.max(maxX, x);
					minX = Math.min(minX, x);
					maxY = Math.max(maxY, y);
					minY = Math.min(minY, y);
				}
			}
		}
	}

	answer = Array.from(Array(maxY - minY + 1), () => Array(maxX - minX + 1).fill('.'));

	points.forEach(([x, y]) => {
		answer[maxY - y][x - minX] = '*';
	});

	return answer.map((x) => x.join(''));
}
