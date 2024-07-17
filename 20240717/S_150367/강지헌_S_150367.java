class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) answer[i] = chk(numbers[i]);
        return answer;
    }
    
    private int chk(long n) {
        String s = Long.toBinaryString(n);
        int t = (int) Math.pow(2, Integer.toBinaryString(s.length()).length()) - 1;
        String fill = String.format("%"+t+"s",s).replace(' ','0');
        for (int i = 1; i <= fill.length(); i++) {
            if (i % 2 == 0 && fill.charAt(i - 1) == '0') {
                int j = Integer.toBinaryString(i & -i).length() - 1;
                int st = i & ~(1 << j);
                int en = (1 << (j + 1)) - 1 + st;
                for (j = st; j < en; j++) {
                    if (fill.charAt(j) == '1') return 0;
                }
            }
        }
        return 1;
    }
}
