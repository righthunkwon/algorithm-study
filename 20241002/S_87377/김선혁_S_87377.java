import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        // line에서 하나를 선택하고 나머지 직선들 하나를 골라서
        // 두개의 직선의 교점을 저장해놓음(정수만)
        
        // 그후 x와 y의 최대 최소 점을 구해서
        // 해당 크기를 기준으로 표시
        
        ArrayList<Integer> arx = new ArrayList<Integer>();
        ArrayList<Integer> ary = new ArrayList<Integer>();
        // 첫째예시로 구하는 방법 찾아보자 
        // 2 -1 4 . -2 -1 4 --> x가 0이되게 계산하여 (-1-1)*y = 8이되는 -4를찾고
        // y가 0이되게 게산하여 4x = 0 -> x = 0을 찾음 -- > 두개 모두 정수로 
        for(int i = 0 ;i<line.length;i++){
            for(int j = i+1;j<line.length;j++){
                // 두개를 선택해서 서로 반대숫자를 곱함
                // 둘다 양수일경우 양수라 빼면됨 , 하나가 음수일경우 둘다 음수되서 빼면됨, 둘다 음수일경우도 똑같음
                // 1. x 먼저없앰
                // 각 직선의 계수
                long A = line[i][0], B = line[i][1], C = line[i][2];
                long D = line[j][0], E = line[j][1], F = line[j][2];

                // 분모 계산 (A*E - B*D)
                long tmp = A * E - B * D;
                // 두 직선이 평행하면 교점이 없음
                if (tmp == 0) {
                    continue;
                }
                // 분자 계산
                long tmpx = B * F - C * E;
                long tmpy = C * D - A * F;

                // x와 y가 정수로 나누어지는지 확인
                if (tmpx % tmp != 0 || tmpy % tmp != 0) {
                    continue;
                }

                // 교점 (x, y) 구함
                int x = (int) (tmpx / tmp);
                int y = (int) (tmpy / tmp);
                
                arx.add(x);
                ary.add(y);
            }
        }
        // 현재 리스트에서 최소점과 최대점 구해옴
        // 최소/최대 좌표 구함
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
        for (int i = 0; i < arx.size(); i++) {
            minx = Math.min(minx, arx.get(i));
            miny = Math.min(miny, ary.get(i));
            maxx = Math.max(maxx, arx.get(i));
            maxy = Math.max(maxy, ary.get(i));
        }

        // 범위에 맞는 배열 생성
        // 교점 위치에는 *을 넣어놓고 나머지는 .
        int width = maxx - minx + 1;
        int height = maxy - miny + 1;
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        // *넣는 과정
        for (int i = 0; i < arx.size(); i++) {
            int x = arx.get(i) - minx;
            int y = maxy - ary.get(i); 
            arr[y][x] = '*';
        }

        // 결과 문자열 배열로 변환
        String[] ans = new String[height];
        for (int i = 0; i < height; i++) {
            ans[i] = new String(arr[i]);
        }

        return ans;
        
        
    }
}
