class Solution {
    public int solution(int storey) {
        int result = 0;
        
        while (storey > 0) {
            int now = storey % 10; 5
            int next = storey / 10; 48
            if (now > 6) { 
                result += 10 - now;
                storey = next + 1;
            } else if (now == 5 && next % 10 > 6) {
                result += 10 - now;
                storey = next + 1;
            } else {
                result += now;
                storey = next;
            }
        }
        return result;
    }
}

// class Solution {
//     public int solution(int storey) {
//         int[] tool = new int[]{0,1,2,3,4,5,4,3,2,1};
//         int result = 0;
//         while(storey > 0){
//             int tmp = storey%10;
//             result += tool[tmp];
//             storey = storey/10;
//             if(tmp > 5) storey+=1;
//         }
//         return result;
//     }
// }

// 2554 => 255 / 4 => 25 / 9 => 2 / 14 => 0 / 16
// 485 => 490 / 5 => 500 / 6 => 0 / 11
// 16 => 20 / 4 => 0 / 6